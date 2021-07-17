package com.learning.cricketfastline.pointtable;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.R;
import com.learning.cricketfastline.model.seriesdata.PointTableModel;
import com.learning.cricketfastline.model.seriesdata.Pointsst;
import com.learning.cricketfastline.utility.CommonFunction;

import java.util.ArrayList;
import java.util.HashMap;

public class PointTableFragment extends Fragment {

    private PintTableViewModel mViewModel;
    private PointTableAdapter pointTableAdapter;
    private RecyclerView recyclerView;
    ArrayList<Pointsst> pointTableModels = new ArrayList<>();
    TextView placeHolder;
    LinearLayout linerLayout;
    public static PointTableFragment newInstance() {
        return new PointTableFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pint_table_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(PintTableViewModel.class);
        recyclerView = view.findViewById(R.id.pointTableRecyclerview);
        linerLayout = view.findViewById(R.id.linerLayout);
        placeHolder = view.findViewById(R.id.placeHolder);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("seriesid", getActivity().getIntent().getStringExtra("matchId"));
        mViewModel.getPontTable(stringStringHashMap).observeForever(new Observer<PointTableModel>() {
            @Override
            public void onChanged(PointTableModel pointTableModel) {
                if (pointTableModel.getPointsst().size() >= 1){
                    linerLayout.setVisibility(View.VISIBLE);
                    placeHolder.setVisibility(View.GONE);
                    Log.d("pointssize",""+pointTableModel.getPointsst().size());
                    for (int i = 0; i <pointTableModel.getPointsst().size() ; i++) {
                        pointTableModels.add(pointTableModel.getPointsst().get(i));
                    }
                    recyclerView.addItemDecoration(CommonFunction.itemDecoration(getContext()));
                    pointTableAdapter = new PointTableAdapter(pointTableModels);
                    recyclerView.setAdapter(pointTableAdapter);

                }else {
                    linerLayout.setVisibility(View.GONE);
                    placeHolder.setVisibility(View.VISIBLE);
                }

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}