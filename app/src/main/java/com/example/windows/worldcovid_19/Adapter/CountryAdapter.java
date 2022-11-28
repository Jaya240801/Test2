package com.example.windows.worldcovid_19.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows.worldcovid_19.Function;
import com.example.windows.worldcovid_19.GetterSetter.CountryDataGetter;
import com.example.windows.worldcovid_19.GetterSetter.WorldDataGetter;
import com.example.windows.worldcovid_19.R;


import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    Context context;
    List<WorldDataGetter> objects;

    public CountryAdapter(Context context, List<WorldDataGetter> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.t1.setText(objects.get(i).getCountryRegion());
        viewHolder.t2.setText(Function.removeE(objects.get(i).getConfirmed()));
        viewHolder.t4.setText(Function.removeE(objects.get(i).getDeaths()));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.country1);
            t2 = itemView.findViewById(R.id.infectView);
            t3 = itemView.findViewById(R.id.recoveredView);
            t4 = itemView.findViewById(R.id.deathView);
        }
    }
}
