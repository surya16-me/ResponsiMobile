package com.sun.covidinfo.service;

import com.sun.covidinfo.model.hospital.HospitalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HospitalRepository {
    @GET("v1/sebaran_v2/jabar/faskes")
    Call<HospitalResponse> getHospitalDiscover();


}
