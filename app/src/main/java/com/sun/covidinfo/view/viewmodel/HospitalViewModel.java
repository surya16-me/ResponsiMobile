package com.sun.covidinfo.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sun.covidinfo.model.hospital.DataItem;
import com.sun.covidinfo.model.hospital.HospitalResponse;
import com.sun.covidinfo.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<DataItem>> listDiscoverHospital = new MutableLiveData<>();

    public void setHospitalDiscover(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiHospital().getHospitalDiscover().enqueue(new Callback<HospitalResponse>() {
            @Override
            public void onResponse(Call<HospitalResponse> call, Response<HospitalResponse> response) {
                HospitalResponse responseDiscover = response.body();
                if(responseDiscover != null && responseDiscover.getData() !=null){
                    ArrayList<DataItem> hospitalItems = responseDiscover.getData();
                    listDiscoverHospital.postValue(hospitalItems);
                }
            }

            @Override
            public void onFailure(Call<HospitalResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<DataItem>> getHospitalDiscover(){
        return listDiscoverHospital;
    }
}
