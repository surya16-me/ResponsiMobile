package com.sun.covidinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sun.covidinfo.R;
import com.sun.covidinfo.model.kasus.ContentItem;

import java.util.ArrayList;

public class CovidDiscoverAdapter extends RecyclerView.Adapter<CovidDiscoverAdapter.ViewHolder> {

    private ArrayList<ContentItem> contentItems = new ArrayList<>();
    private Context context;

    public CovidDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ContentItem> items){
        contentItems.clear();
        contentItems.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CovidDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kasus, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CovidDiscoverAdapter.ViewHolder holder, int position) {
        holder.tanggal.setText(String.valueOf(contentItems.get(position).getTanggal()));
        holder.sembuh.setText(String.valueOf(contentItems.get(position).getConfirmationSelesai()));
        holder.mati.setText(String.valueOf(contentItems.get(position).getConfirmationMeninggal()));
        holder.konfir.setText(String.valueOf(contentItems.get(position).getConfirmationDiisolasi()));
    }

    @Override
    public int getItemCount() {
        return contentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, sembuh, mati, konfir;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tgl_harian_kasus);
            sembuh = itemView.findViewById(R.id.jml_sembuh);
            mati = itemView.findViewById(R.id.jml_mati);
            konfir = itemView.findViewById(R.id.jml_terkonfirmasi);
        }
    }
}
