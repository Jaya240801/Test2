package com.example.windows.worldcovid_19;

import com.example.windows.worldcovid_19.GetterSetter.CountryDataGetter;
import com.example.windows.worldcovid_19.GetterSetter.WorldDataGetter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("confirmed")
    Call<WorldDataGetter> getData();

    @GET("confirmed")
    Call<List<WorldDataGetter>> getDatas();
}
