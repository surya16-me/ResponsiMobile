package com.sun.covidinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sun.covidinfo.R;
import com.sun.covidinfo.model.hospital.DataItem;

import java.util.ArrayList;

public class HospitalDiscoverAdapter extends RecyclerView.Adapter<HospitalDiscoverAdapter.ViewHolder>{

    private ArrayList<DataItem> dataItems = new ArrayList<>();
    private Context context;

    public HospitalDiscoverAdapter(Context context){
        this.context = context;

    }

    public void setData (ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public HospitalDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_hospital, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  HospitalDiscoverAdapter.ViewHolder holder, int position) {
        holder.hospital_name.setText(dataItems.get(position).getNama());
        holder.alamat.setText(dataItems.get(position).getAlamat());
        holder.btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rs = dataItems.get(position).getNama();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+rs));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hospital_name, alamat;
        Button btn_maps;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            hospital_name = itemView.findViewById(R.id.nama_RS);
            alamat = itemView.findViewById(R.id.alamat_lengkap);
            btn_maps = itemView.findViewById(R.id.btn_map);
        }
    }
}
