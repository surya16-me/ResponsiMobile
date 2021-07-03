package com.sun.covidinfo.service;

import com.sun.covidinfo.model.kasus.KasusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidRepository {
    @GET("v1/rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getCovidDiscover();
}
