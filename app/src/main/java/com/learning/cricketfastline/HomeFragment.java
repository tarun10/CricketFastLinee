package com.learning.cricketfastline;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.learning.cricketfastline.livescore.TabLayoutMainActivity;
import com.learning.cricketfastline.model.LiveMatchModel;
import com.learning.cricketfastline.utility.CricketFastLine;
import com.learning.cricketfastline.utility.constantfiles.RecyclerItemClickEvent;
import com.learning.cricketfastline.viewpageradapters.HomeFragementViewModel;
import com.learning.cricketfastline.viewpageradapters.HomePagerIndicatorAdaptor;
import com.learning.cricketfastline.viewpageradapters.HomeViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class HomeFragment extends Fragment implements RecyclerItemClickEvent {


    TabLayout tabLayout, taindicator;
    ViewPager2 viewPager2, headerViewPager;
    HomeViewPagerAdapter fragmentAdapter;
    private String[] tabHeading = {"Live", "Upcoming", "Finished", "Series"};
    private HomeFragementViewModel homeFragementViewModel;
    SpringDotsIndicator dotsIndicator;

    private Socket mSocket;
    {
        try {
            //mSocket = IO.socket("http://node.cricnet.co.in:7001");
            mSocket = IO.socket("http://node.cricnet.co.in:3026/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        //taindicator = view.findViewById(R.id.taindicator);
        viewPager2 = view.findViewById(R.id.viewPager2);
        headerViewPager = view.findViewById(R.id.headerViewPager);
        viewPager2.setOffscreenPageLimit(2);
        headerViewPager.setOffscreenPageLimit(3);
        dotsIndicator = view.findViewById(R.id.dotsss);
        fragmentAdapter = new HomeViewPagerAdapter(getActivity());
        viewPager2.setAdapter(fragmentAdapter);
        homeFragementViewModel = new ViewModelProvider(this).get(HomeFragementViewModel.class);
        loadeHeaderData();

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(tabHeading[position])).attach();


        //mSocket = CricketFastLine.getmSocket();
        //mSocket.connect();
        initSocket();
       /* if(socket.connected())
        {
            Toast.makeText(getActivity(), "Message", Toast.LENGTH_SHORT).show();
        }

        socket.on("", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject)args[0];//here the data is in JSON Format

            }
        });*/
        return view;
    }

    private void loadeHeaderData() {
        homeFragementViewModel.getUpComingData().observeForever(new Observer<ArrayList<LiveMatchModel>>() {
            @Override
            public void onChanged(ArrayList<LiveMatchModel> eventTitleViews) {
                HomePagerIndicatorAdaptor homePagerIndicatorAdaptor = new HomePagerIndicatorAdaptor(eventTitleViews, getContext(), HomeFragment.this::onClick);
                headerViewPager.setAdapter(homePagerIndicatorAdaptor);
                dotsIndicator.setViewPager2(headerViewPager);
            }
        });
    }

    private void initSocket() {
        try {
            if (mSocket != null) {
                if (!mSocket.connected()) {
                    JSONObject mUser = new JSONObject();
                    mSocket.emit("CONNECTION_REQUEST", mUser);
                    mSocket.on("CONNECTION_ESTABLISHED", onConnectionEstb);
                    mSocket.on("broadcastScore", broadcastScore);
                    mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
                    mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
                    mSocket.connect();

                }

            }

        } catch (Exception e) {
            Log.e(" Exception ", "" + e.getMessage());
        }

    }
    private Emitter.Listener onConnectionEstb = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.d("dddd","ddd");
                }
            });
        }
    };
    private Emitter.Listener broadcastScore = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    Log.d("dddd","ddd");
                }
            });
        }
    };
    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.d("dddd","ddd");
                }
            });
        }
    };
    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.d("dddd","ddd");
                }
            });
        }
    };


    @Override
    public void onClick(String matchType, String matchId, String title, String message) {
        startActivity(new Intent(getActivity(), TabLayoutMainActivity.class)
                .putExtra("matchId", matchId)
                .putExtra("matchType", matchType)
                .putExtra("title", title)
                .putExtra("message", message));
    }

    @Override
    public void onResume() {
        super.onResume();
        loadeHeaderData();
        initSocket();
    }

    @Override
    public void onPause() {
        super.onPause();
        mSocket.disconnect();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
        mSocket.close();
    }
}