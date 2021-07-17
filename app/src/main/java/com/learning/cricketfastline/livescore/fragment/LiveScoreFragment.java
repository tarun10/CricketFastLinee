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
import com.cricket.adfreecricketliveline.R;
import com.cricket.adfreecricketliveline.databinding.FragmentLiveBinding;
import com.cricket.adfreecricketliveline.livescore.models.LiveScoreModel;
import com.cricket.adfreecricketliveline.model.livejsondata.LiveScoreDataModel;
import com.cricket.adfreecricketliveline.model.livejsondata.LiveScoreModelJsonRun;
import com.cricket.adfreecricketliveline.model.players.Players;
import com.cricket.adfreecricketliveline.utility.TimeUtility;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class LiveScoreFragment extends Fragment {

    private LiveScoreModel liveScoreModel;
    private FragmentLiveBinding fragmentLiveBinding;
    private TextToSpeech textToSpeech;
    private ArrayList<Players> teamAPlayers = new ArrayList<>();
    private ArrayList<Players> teamBPlayers = new ArrayList<>();
    private String speakOnOff = "0.0";
    private boolean isSoundOn = true;
    private HashMap<String, String> scoreInfo = new HashMap<>();
    private Disposable disposable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentLiveBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_live, container, false);
        View view = fragmentLiveBinding.getRoot();

//      scoreInfo.put("matchType", getActivity().getIntent().getStringExtra("matchType"));
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
            getAPiInforMation(0L);
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

        disposable = Observable.interval(1000, 1000,
                TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getAPiInforMation, this::onError);
        return view;
    }

    private void getAPiInforMation(Long aLong) {
        if (getActivity().getIntent().getStringExtra("matchType").equals("finished")) {
            getHistoryScore(scoreInfo);
        } else {
            getLiveScore(scoreInfo);
        }
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

    private void getLiveScore(HashMap<String, String> scoreInfo) {
        liveScoreModel.getUpComingData(scoreInfo).observeForever(jssondata -> {

            if (jssondata.size() >= 1) {

                LiveScoreDataModel liveScoreDataModel = new Gson().fromJson(jssondata.get(0).getJsondata(), LiveScoreDataModel.class);
                LiveScoreModelJsonRun liveScoreModelJsonRun = new Gson().fromJson(jssondata.get(0).getJsonruns(), LiveScoreModelJsonRun.class);

                if (liveScoreModelJsonRun != null && liveScoreModelJsonRun.getJsonruns() != null) {
                    fragmentLiveBinding.summary.setText(liveScoreModelJsonRun.getJsonruns().getSummary());
                    String runxball1 = liveScoreModelJsonRun != null ? liveScoreModelJsonRun.getJsonruns().getRunxa() : "-";
                    String runxball2 = liveScoreModelJsonRun != null ? liveScoreModelJsonRun.getJsonruns().getRunxb() : "-";
                    fragmentLiveBinding.runXBall1.setText(runxball1);
                    fragmentLiveBinding.runXBall2.setText(runxball2);
                }
                if (liveScoreDataModel != null && liveScoreDataModel.getJsondata() != null) {

                    if (jssondata.get(0).getMatchType().equalsIgnoreCase("Test")) {
                        fragmentLiveBinding.testSessionLayout.setVisibility(View.VISIBLE);
                        fragmentLiveBinding.sessionLayout.setVisibility(View.GONE);
                        fragmentLiveBinding.testTeamA.setText(liveScoreDataModel.getJsondata().getTestTeamA());
                        fragmentLiveBinding.testTeamARate1.setText(liveScoreDataModel.getJsondata().getTestTeamARate1());
                        fragmentLiveBinding.testTeamARate2.setText(liveScoreDataModel.getJsondata().getTestTeamARate2());

                        fragmentLiveBinding.testTeamB.setText(liveScoreDataModel.getJsondata().getTestTeamB());
                        fragmentLiveBinding.testTeamBRate1.setText(liveScoreDataModel.getJsondata().getTestTeamBRate1());
                        fragmentLiveBinding.testTeamBRate2.setText(liveScoreDataModel.getJsondata().getTestTeamBRate2());

                        fragmentLiveBinding.testdraw.setText("Draw");
                        fragmentLiveBinding.TestdrawRate1.setText(liveScoreDataModel.getJsondata().getTestdrawRate1());
                        fragmentLiveBinding.TestdrawRate2.setText(liveScoreDataModel.getJsondata().getTestdrawRate2());
                    }

                    fragmentLiveBinding.matchInfo.setText(liveScoreDataModel.getJsondata().getScore());
                    //lst 6 balls
                    if (!liveScoreDataModel.getJsondata().getLast6Balls().contains("-----")) {
                        String[] lastSixBall = liveScoreDataModel.getJsondata().getLast6Balls().split("-");
                        fragmentLiveBinding.bowlone.setText(lastSixBall[0]);
                        fragmentLiveBinding.bowltwo.setText(lastSixBall[1]);
                        fragmentLiveBinding.bowlthree.setText(lastSixBall[2]);
                        fragmentLiveBinding.bowlfour.setText(lastSixBall[3]);
                        fragmentLiveBinding.bowlfive.setText(lastSixBall[4]);
                        fragmentLiveBinding.bowlsix.setText(lastSixBall[5]);

                    }

                    fragmentLiveBinding.scoreCard.setVisibility(View.VISIBLE);
                    fragmentLiveBinding.notYetStart.setVisibility(View.GONE);

                    String bastmanA = liveScoreDataModel.getJsondata().getBatsman().substring(0, liveScoreDataModel.getJsondata().getBatsman().indexOf("|"));
                    String bastmanB = liveScoreDataModel.getJsondata().getBatsman().substring(liveScoreDataModel.getJsondata().getBatsman().indexOf("|") + 1);
                    fragmentLiveBinding.btname1.setText(bastmanA);
                    fragmentLiveBinding.btname2.setText(bastmanB);

                    String btTotalScore = liveScoreDataModel.getJsondata().getOversB().substring(0, liveScoreDataModel.getJsondata().getOversB().indexOf("|"));
                    String[] btScore = btTotalScore.split(",");
                    fragmentLiveBinding.btRun1.setText(btScore[1]);
                    fragmentLiveBinding.btRun2.setText(btScore[0]);
                    String bttotalball = liveScoreDataModel.getJsondata().getOversB().substring(liveScoreDataModel.getJsondata().getOversB().indexOf("|") + 1);
                    String[] btBall = bttotalball.split(",");
                    fragmentLiveBinding.btBall1.setText(btBall[1]);
                    fragmentLiveBinding.btBall2.setText(btBall[0]);

                    fragmentLiveBinding.btFours1.setText(liveScoreDataModel.getJsondata().getS4());
                    fragmentLiveBinding.btFours2.setText(liveScoreDataModel.getJsondata().getNs4());
                    fragmentLiveBinding.btSixes1.setText(liveScoreDataModel.getJsondata().getS6());
                    fragmentLiveBinding.btSixes2.setText(liveScoreDataModel.getJsondata().getNs6());
                    //strickrates
                    fragmentLiveBinding.btRunrates1.setText(TimeUtility.getStrickRate(btScore[1], btBall[1]));
                    fragmentLiveBinding.btRunrates2.setText(TimeUtility.getStrickRate(btScore[0], btBall[0]));


//                    //bowler Data
                    fragmentLiveBinding.bowlerName.setText(liveScoreDataModel.getJsondata().getBowler());


                    if (!liveScoreDataModel.getJsondata().getWicketB().equalsIgnoreCase("0/0")) {
                        fragmentLiveBinding.targetScore.setVisibility(View.VISIBLE);
                        fragmentLiveBinding.targetScore.setText(liveScoreDataModel.getJsondata().getWicketB());
                        if (getActivity() != null)
                            Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamABanner()).circleCrop().into(fragmentLiveBinding.teamFlag);
                        String teamBlive = liveScoreDataModel.getJsondata().getWicketA();
                        fragmentLiveBinding.liveScoreT1.setText(liveScoreDataModel.getJsondata().getTeamA().substring(0, 3) + " " + teamBlive);
                        //for target team
                        fragmentLiveBinding.targetTeamname.setText(liveScoreDataModel.getJsondata().getTeamB());
                        Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamBBanner()).circleCrop().into(fragmentLiveBinding.targetTeamImage);
                    } else {
                        String teamAlive = liveScoreDataModel.getJsondata().getWicketA();
                        fragmentLiveBinding.liveScoreT1.setText(liveScoreDataModel.getJsondata().getTeamA() + " " + teamAlive);
                        if (liveScoreDataModel.getJsondata().getImgurl() != null && liveScoreDataModel.getJsondata().getTeamABanner() != null)
                            Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamABanner()).circleCrop().into(fragmentLiveBinding.teamFlag);
                        //for target team
                        fragmentLiveBinding.targetTeamname.setText(liveScoreDataModel.getJsondata().getTeamB());
                        if (liveScoreDataModel.getJsondata().getImgurl() != null && liveScoreDataModel.getJsondata().getTeamBBanner() != null)
                            Glide.with(getActivity()).load(liveScoreDataModel.getJsondata().getImgurl() + liveScoreDataModel.getJsondata().getTeamBBanner()).circleCrop().into(fragmentLiveBinding.targetTeamImage);
                    }


                    String favteam = liveScoreDataModel.getJsondata().getRateA().substring(liveScoreDataModel.getJsondata().getRateA().lastIndexOf("|") + 1);
                    fragmentLiveBinding.currentOver.setText("In " + liveScoreDataModel.getJsondata().getOversA() + " Overs");
                    fragmentLiveBinding.favTeamName.setText(favteam);

                    String[] rates = liveScoreDataModel.getJsondata().getRateA().substring(0, liveScoreDataModel.getJsondata().getRateA().indexOf("|")).split("-");
                    fragmentLiveBinding.rateA.setText(getRates(rates[0]));
                    fragmentLiveBinding.rateB.setText(getRates(rates[1]));


                    fragmentLiveBinding.sessionA.setText(liveScoreDataModel.getJsondata().getSessionA());
                    fragmentLiveBinding.sessionB.setText(liveScoreDataModel.getJsondata().getSessionB());
                    fragmentLiveBinding.overs.setText(liveScoreDataModel.getJsondata().getSessionOver());


                    if (!fragmentLiveBinding.currentOver.getText().toString().equals(speakOnOff) && isSoundOn) {

                        switch (liveScoreDataModel.getJsondata().getScore().toLowerCase()) {
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
                                textToSpeech.speak(liveScoreDataModel.getJsondata().getScore().toLowerCase(), TextToSpeech.QUEUE_ADD, null);
                        }

                        speakOnOff = fragmentLiveBinding.currentOver.getText().toString();
                    }

                } else {
                    fragmentLiveBinding.teamFlag.setVisibility(View.GONE);
                }
            }
        });
    }

    private String getRates(String rate) {
        return rate.equals("") ? "0" : rate;
    }


    @Override
    public void onResume() {
        super.onResume();
        if (disposable.isDisposed()) {
            disposable = Observable.interval(1000, 1000,
                    TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::getAPiInforMation, this::onError);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        textToSpeech.stop();
        disposable.dispose();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void onError(Throwable throwable) {
        Log.d("ddddd", "dddd");
    }
}