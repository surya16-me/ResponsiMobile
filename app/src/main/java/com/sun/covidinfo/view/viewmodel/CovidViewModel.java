package com.sun.covidinfo.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sun.covidinfo.model.kasus.ContentItem;
import com.sun.covidinfo.model.kasus.KasusResponse;
import com.sun.covidinfo.service.ApiMain;
import com.sun.covidinfo.view.fragment.KasusCovid;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ContentItem>> listDiscoverCovid = new MutableLiveData<>();


    public void setCovidDiscover(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiCovid().getCovidDiscover().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse responseDiscover = response.body();
                if(responseDiscover != null && responseDiscover.getData().getContent() !=null){
                    ArrayList<ContentItem> covidDiscoverItems = responseDiscover.getData().getContent();
                    listDiscoverCovid.postValue(covidDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ContentItem>> getCovidDiscover(){
        return listDiscoverCovid;
    }
}
