package com.sun.covidinfo.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.StackView;

import com.sun.covidinfo.R;
import com.sun.covidinfo.adapter.CovidDiscoverAdapter;
import com.sun.covidinfo.model.kasus.ContentItem;
import com.sun.covidinfo.view.viewmodel.CovidViewModel;

import java.util.ArrayList;


public class KasusCovid extends Fragment {

    private CovidDiscoverAdapter covidDiscoverAdapter;
    private RecyclerView rvCovidDiscover;
    private CovidViewModel covidViewModel;
    public KasusCovid() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        covidDiscoverAdapter = new CovidDiscoverAdapter(getContext());
        covidDiscoverAdapter.notifyDataSetChanged();

        rvCovidDiscover = view.findViewById(R.id.rv_covid_case);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        rvCovidDiscover.setLayoutManager(linearLayoutManager);

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        covidViewModel.setCovidDiscover();
        covidViewModel.getCovidDiscover().observe(getViewLifecycleOwner(), getCovidDiscover);

        rvCovidDiscover.setAdapter(covidDiscoverAdapter);


    }

    private Observer<ArrayList<ContentItem>> getCovidDiscover = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> contentItems) {
            if(contentItems != null){
                covidDiscoverAdapter.setData(contentItems);
            }
        }
    };
}