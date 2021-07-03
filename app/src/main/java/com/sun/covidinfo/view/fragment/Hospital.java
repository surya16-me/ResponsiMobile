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

import com.sun.covidinfo.R;
import com.sun.covidinfo.adapter.HospitalDiscoverAdapter;
import com.sun.covidinfo.model.hospital.DataItem;
import com.sun.covidinfo.view.viewmodel.HospitalViewModel;

import java.util.ArrayList;

public class Hospital extends Fragment {

    private HospitalDiscoverAdapter hospitalDiscoverAdapter;
    private RecyclerView rvHospital;
    private HospitalViewModel hospitalViewModel;

    public Hospital() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hospitalDiscoverAdapter = new HospitalDiscoverAdapter(getContext());
        hospitalDiscoverAdapter.notifyDataSetChanged();

        rvHospital = view.findViewById(R.id.rv_hospital);

        rvHospital.setLayoutManager(new LinearLayoutManager(getContext()));

        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        hospitalViewModel.setHospitalDiscover();
        hospitalViewModel.getHospitalDiscover().observe(getViewLifecycleOwner(), getHospitalDiscover);

        rvHospital.setAdapter(hospitalDiscoverAdapter);
    }
    private Observer<ArrayList<DataItem>> getHospitalDiscover = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if(dataItems != null){
                hospitalDiscoverAdapter.setData(dataItems);
            }
        }
    };
}