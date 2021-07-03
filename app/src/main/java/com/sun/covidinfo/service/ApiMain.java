package com.sun.covidinfo.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public CovidRepository getApiCovid(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidRepository.class);
    }
    public HospitalRepository getApiHospital(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HospitalRepository.class);
    }
}
