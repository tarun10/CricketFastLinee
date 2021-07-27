package com.learning.cricketfastline.livescore.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.learning.cricketfastline.R;
import com.learning.cricketfastline.databinding.FragmentLiveBinding;
import com.learning.cricketfastline.livescore.models.LiveScoreModel;
import com.learning.cricketfastline.model.SocketLiveScore;
import com.learning.cricketfastline.model.players.Players;
import com.learning.cricketfastline.utility.CricketFastLine;
import com.learning.cricketfastline.utility.TimeUtility;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class LiveScoreFragment extends Fragment {

    private LiveScoreModel liveScoreModel;
    private FragmentLiveBinding fragmentLiveBinding;
    private TextToSpeech textToSpeech;
    private ArrayList<Players> teamAPlayers = new ArrayList<>();
    private ArrayList<Players> teamBPlayers = new ArrayList<>();
    private String speakOnOff = "0.0";
    private boolean isSoundOn = true;
    private HashMap<String, String> scoreInfo = new HashMap<>();
    private Socket mSocket;
    private final String TAG = "Socket error";
    private Boolean isConnected = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CricketFastLine app = (CricketFastLine) getActivity().getApplication();
        mSocket = app.getmSocket();
        if (!mSocket.connected()) {
            JSONObject mUser = new JSONObject();
            mSocket.emit("CONNECTION_REQUEST", mUser);
            mSocket.on("CONNECTION_ESTABLISHED", onConnectionEstb);
            mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
            mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
            mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
            mSocket.on("broadcastScore", broadcastScore);
            mSocket.connect();
        }

        if (mSocket.connected()) {
            Toast.makeText(getActivity(), "Socket connected", Toast.LENGTH_SHORT).show();
        }
    }

    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "Socket connection error");
                }
            });
        }
    };

    private Emitter.Listener onConnectionEstb = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!isConnected) {
                            isConnected = true;
                        }
                        Log.i(TAG, "Socket connection established");
                    }
                });
            }
        }
    };
    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            if (getActivity() != null)
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        isConnected = false;
                        Log.i(TAG, "Socket is disconnected");

                    }
                });
        }
    };
    private Emitter.Listener broadcastScore = args -> {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SocketLiveScore socketLiveScore = new Gson().fromJson(args[0].toString(), SocketLiveScore.class);
                getLiveScore(socketLiveScore);
            }
        });
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLiveBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_live, container, false);
        View view = fragmentLiveBinding.getRoot();
        scoreInfo.put("matchId", getActivity().getIntent().getStringExtra("matchId"));
        textToSpeech = new TextToSpeech(getActivity(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setLanguage(Locale.US);
            } else {
                Toast.makeText(getActivity(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
            }
        });
        liveScoreModel = new ViewModelProvider(this).get(LiveScoreModel.class);

        if (getActivity().getIntent().getStringExtra("matchType").equals("upcoming")) {
            fragmentLiveBinding.notYetStart.setVisibility(View.VISIBLE);
            fragmentLiveBinding.scoreCard.setVisibility(View.GONE);
        }
        fragmentLiveBinding.pullRefresh.setOnRefreshListener(() -> {
            fragmentLiveBinding.pullRefresh.setRefreshing(false);
        });
        fragmentLiveBinding.soundIcon.setOnClickListener(view1 -> {
            if (isSoundOn) {
                isSoundOn = false;
                fragmentLiveBinding.soundIcon.setImageResource(R.drawable.ic_baseline_volume_off_24);
                fragmentLiveBinding.soundStatus.setText("Sound is off");
            } else {
                isSoundOn = true;
                fragmentLiveBinding.soundIcon.setImageResource(R.drawable.ic_baseline_volume_up_24);
                fragmentLiveBinding.soundStatus.setText("Sound is on");
            }
        });

        return view;
    }

    private void getHistoryScore(HashMap<String, String> scoreInfo) {
        liveScoreModel.getFinishedScoreCard(scoreInfo).observeForever(players -> {
            fragmentLiveBinding.pullRefresh.setRefreshing(false);
            if (players.size() >= 1) {
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getTeamSide().equalsIgnoreCase("Team A")) {
                        teamAPlayers.add(players.get(i));
                    } else {
                        teamBPlayers.add(players.get(i));
                    }
                }

                fragmentLiveBinding.liveScoreT1.setText(teamBPlayers.get(0).getTeamRuns() + ")");
                fragmentLiveBinding.targetScore.setVisibility(View.VISIBLE);
                fragmentLiveBinding.targetScore.setText(teamAPlayers.get(0).getTeamRuns() + ")");
                fragmentLiveBinding.teamFlag.setVisibility(View.GONE);
                fragmentLiveBinding.sessionLayout.setVisibility(View.GONE);
                //fragmentLiveBinding.matchInfo.setText(getActivity().getIntent().getStringExtra("message"));

                if (players.contains(players.get(0).getMatchtype())) {
                    if (players.get(0).getMatchtype().equalsIgnoreCase("test")) {
                        fragmentLiveBinding.testSessionLayout.setVisibility(View.VISIBLE);
                        fragmentLiveBinding.testTeamA.setText(players.get(0).getTestTeamA());
                        fragmentLiveBinding.testTeamARate1.setText(players.get(0).getTestTeamARate1());
                        fragmentLiveBinding.testTeamARate2.setText(players.get(0).getTestTeamARate2());
                    }
                }


            } else {
                Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getLiveScore(SocketLiveScore socketLiveScore) {
        if (socketLiveScore != null) {
            fragmentLiveBinding.summary.setText(socketLiveScore.getSummary());
            fragmentLiveBinding.runXBall1.setText("" + socketLiveScore.getRunxa());
            fragmentLiveBinding.runXBall2.setText("" + socketLiveScore.getRunxb());
        }


        if (socketLiveScore.getMatchtype() != null) {
            if (socketLiveScore.getMatchtype().equalsIgnoreCase("Test")) {
                fragmentLiveBinding.testSessionLayout.setVisibility(View.VISIBLE);
                fragmentLiveBinding.sessionLayout.setVisibility(View.GONE);
                fragmentLiveBinding.testTeamA.setText(socketLiveScore.getTestTeamA());
                fragmentLiveBinding.testTeamARate1.setText(socketLiveScore.getTestTeamARate1());
                fragmentLiveBinding.testTeamARate2.setText(socketLiveScore.getTestTeamARate2());

                fragmentLiveBinding.testTeamB.setText(socketLiveScore.getTestTeamB());
                fragmentLiveBinding.testTeamBRate1.setText(socketLiveScore.getTestTeamBRate1());
                fragmentLiveBinding.testTeamBRate2.setText(socketLiveScore.getTestTeamBRate2());

                fragmentLiveBinding.testdraw.setText("Draw");
                fragmentLiveBinding.TestdrawRate1.setText(socketLiveScore.getTestdrawRate1());
                fragmentLiveBinding.TestdrawRate2.setText(socketLiveScore.getTestdrawRate2());
            }
        }

        fragmentLiveBinding.matchInfo.setText(socketLiveScore.getScore());
        //lst 6 balls
        if (!socketLiveScore.getLast6Balls().contains("-----")) {
            String[] lastSixBall = socketLiveScore.getLast6Balls().split("-");
            fragmentLiveBinding.bowlone.setText(lastSixBall[0]);
            fragmentLiveBinding.bowltwo.setText(lastSixBall[1]);
            fragmentLiveBinding.bowlthree.setText(lastSixBall[2]);
            fragmentLiveBinding.bowlfour.setText(lastSixBall[3]);
            fragmentLiveBinding.bowlfive.setText(lastSixBall[4]);
            fragmentLiveBinding.bowlsix.setText(lastSixBall[5]);

        }

        fragmentLiveBinding.scoreCard.setVisibility(View.VISIBLE);
        fragmentLiveBinding.notYetStart.setVisibility(View.GONE);

        String bastmanA = socketLiveScore.getBatsman().substring(0, socketLiveScore.getBatsman().indexOf("|"));
        String bastmanB = socketLiveScore.getBatsman().substring(socketLiveScore.getBatsman().indexOf("|") + 1);
        fragmentLiveBinding.btname1.setText(bastmanA);
        fragmentLiveBinding.btname2.setText(bastmanB);

        String btTotalScore = socketLiveScore.getOversB().substring(0, socketLiveScore.getOversB().indexOf("|"));
        String[] btScore = btTotalScore.split(",");
        fragmentLiveBinding.btRun1.setText(btScore[1]);
        fragmentLiveBinding.btRun2.setText(btScore[0]);
        String bttotalball = socketLiveScore.getOversB().substring(socketLiveScore.getOversB().indexOf("|") + 1);
        String[] btBall = bttotalball.split(",");
        fragmentLiveBinding.btBall1.setText(btBall[1]);
        fragmentLiveBinding.btBall2.setText(btBall[0]);

        fragmentLiveBinding.btFours1.setText(socketLiveScore.getS4());
        fragmentLiveBinding.btFours2.setText(socketLiveScore.getNs4());
        fragmentLiveBinding.btSixes1.setText(socketLiveScore.getS6());
        fragmentLiveBinding.btSixes2.setText(socketLiveScore.getNs6());
        //strickrates
        fragmentLiveBinding.btRunrates1.setText(TimeUtility.getStrickRate(btScore[1], btBall[1]));
        fragmentLiveBinding.btRunrates2.setText(TimeUtility.getStrickRate(btScore[0], btBall[0]));


//                    //bowler Data
        fragmentLiveBinding.bowlerName.setText(socketLiveScore.getBowler());


        if (!socketLiveScore.getWicketB().equalsIgnoreCase("0/0")) {
            fragmentLiveBinding.targetScore.setVisibility(View.VISIBLE);
            fragmentLiveBinding.targetScore.setText(socketLiveScore.getWicketB());
            if (getActivity() != null)
                Glide.with(getActivity()).load(socketLiveScore.getImgurl() + socketLiveScore.getTeamABanner()).circleCrop().into(fragmentLiveBinding.teamFlag);
            String teamBlive = socketLiveScore.getWicketA();
            fragmentLiveBinding.liveScoreT1.setText(socketLiveScore.getTeamA().substring(0, 3) + " " + teamBlive);
            //for target team
            fragmentLiveBinding.targetTeamname.setText(socketLiveScore.getTeamB());
            Glide.with(getActivity()).load(socketLiveScore.getImgurl() + socketLiveScore.getTeamBBanner()).circleCrop().into(fragmentLiveBinding.targetTeamImage);
        } else {
            String teamAlive = socketLiveScore.getWicketA();
            fragmentLiveBinding.liveScoreT1.setText(socketLiveScore.getTeamA() + " " + teamAlive);
            if (socketLiveScore.getImgurl() != null && socketLiveScore.getTeamABanner() != null)
                Glide.with(getActivity()).load(socketLiveScore.getImgurl() + socketLiveScore.getTeamABanner()).circleCrop().into(fragmentLiveBinding.teamFlag);
            //for target team
            fragmentLiveBinding.targetTeamname.setText(socketLiveScore.getTeamB());
            if (socketLiveScore.getImgurl() != null && socketLiveScore.getTeamBBanner() != null)
                Glide.with(getActivity()).load(socketLiveScore.getImgurl() + socketLiveScore.getTeamBBanner()).circleCrop().into(fragmentLiveBinding.targetTeamImage);
        }


        String favteam = socketLiveScore.getRateA().substring(socketLiveScore.getRateA().lastIndexOf("|") + 1);
        fragmentLiveBinding.currentOver.setText("In " + socketLiveScore.getOversA() + " Overs");
        fragmentLiveBinding.favTeamName.setText(favteam);

        // String[] rates = socketLiveScore.getRateA().substring(0, socketLiveScore.getRateA().indexOf("|")).split("-");
        fragmentLiveBinding.rateA.setText(socketLiveScore.getRateA());
        fragmentLiveBinding.rateB.setText(socketLiveScore.getRateB());


        fragmentLiveBinding.sessionA.setText(socketLiveScore.getSessionA());
        fragmentLiveBinding.sessionB.setText(socketLiveScore.getSessionB());
        fragmentLiveBinding.overs.setText(socketLiveScore.getSessionOver());


        if (!fragmentLiveBinding.currentOver.getText().toString().equals(speakOnOff) && isSoundOn) {

            switch (socketLiveScore.getScore().toLowerCase()) {
                case "0":
                    textToSpeech.speak("Khali ball", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "1":
                    textToSpeech.speak("single aya single", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "2":
                    textToSpeech.speak("Double aya Double", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "4":
                    textToSpeech.speak("four laga", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "6":
                    textToSpeech.speak("or ye six", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "wicket":
                    textToSpeech.speak("Out", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "wide":
                    textToSpeech.speak("wide", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "no ball":
                    textToSpeech.speak("no ball", TextToSpeech.QUEUE_ADD, null);
                    break;
                case "over":
                    textToSpeech.speak("Over", TextToSpeech.QUEUE_ADD, null);
                    break;
                default:
                    textToSpeech.speak(socketLiveScore.getScore().toLowerCase(), TextToSpeech.QUEUE_ADD, null);
            }

            speakOnOff = fragmentLiveBinding.currentOver.getText().toString();


        } else {
            fragmentLiveBinding.teamFlag.setVisibility(View.GONE);
        }


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        textToSpeech.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
        mSocket.close();
    }

}