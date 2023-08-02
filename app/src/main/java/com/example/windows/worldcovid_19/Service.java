package com.example.windows.worldcovid_19;

import com.example.windows.worldcovid_19.GetterSetter.CountryDataGetter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("countries.json")
    Call<List<CountryDataGetter>> getDatas();
}
