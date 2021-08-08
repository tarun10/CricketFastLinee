package com.learning.cricketfastline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricketfastline.model.news.NewsModelApi;
import com.learning.cricketfastline.remoteconnection.ApiServices;

import io.reactivex.observers.DisposableObserver;


public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progress_horizontal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.newsRecyclerView);
        progress_horizontal = view.findViewById(R.id.progress_horizontal);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        progress_horizontal.setVisibility(View.VISIBLE);
        ApiServices.getAllNews().subscribeWith(new DisposableObserver<NewsModelApi>() {
            @Override
            public void onNext(NewsModelApi newsModelApis) {
                progress_horizontal.setVisibility(View.GONE);
                if (newsModelApis != null) {
                    NewsAdapter adapter = new NewsAdapter(getContext(), newsModelApis.getArticles());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onError(Throwable e) {
e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });


        return view;
    }
}