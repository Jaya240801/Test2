package com.example.windows.worldcovid_19;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows.worldcovid_19.Adapter.CountryAdapter;
import com.example.windows.worldcovid_19.GetterSetter.CountryDataGetter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tInfect, tRecovered, tDeath;
    ProgressDialog dialog;
    RecyclerView list;
    List<CountryDataGetter> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().hide();
        tInfect = findViewById(R.id.totalInfected);

        list = findViewById(R.id.rvCountry);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new CountryAdapter(this, listData));

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.show();


        //getData();
        //getData();
    }

    public void getData(){
        Call<List<CountryDataGetter>> call = Api.service().getDatas();
        call.enqueue(new Callback<List<CountryDataGetter>>() {
            @Override
            public void onResponse(Call<List<CountryDataGetter>> call, Response<List<CountryDataGetter>> response) {
                tInfect.setText(Function.removeE(response.body().get(0).getConfirmed()));
                tDeath.setText(Function.removeE(response.body().get(0).getDeaths()));
                dialog.cancel();
            }

            @Override
            public void onFailure(Call<List<CountryDataGetter>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }

//    public void getDataCountry(){
//        Call<List<WorldDataGetter>> call = Api.service().getDatas();
//        call.enqueue(new Callback<List<WorldDataGetter>>() {
//            @Override
//            public void onResponse(Call<List<WorldDataGetter>> call, Response<List<WorldDataGetter>> response) {
//                list.setAdapter(new CountryAdapter(MainActivity.this, response.body()));
//                dialog.cancel();
//            }
//
//            @Override
//            public void onFailure(Call<List<WorldDataGetter>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                dialog.cancel();
//            }
//        });
//    }
}
