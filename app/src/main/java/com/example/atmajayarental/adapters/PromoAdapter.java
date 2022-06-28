package com.example.atmajayarental.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atmajayarental.HomeActivity;
import com.example.atmajayarental.R;
import com.example.atmajayarental.databinding.ItemPromoBinding;
import com.example.atmajayarental.models.Promo;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder> {

    private ArrayList<Promo> promoList;
    private Context context;

    public PromoAdapter(ArrayList<Promo> promoList, Context context){
        this.promoList = promoList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_promo,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoAdapter.MyViewHolder holder, int position) {
        holder.tvNama.setText(promoList.get(position).getKode_promo());
        holder.tvNpm.setText(promoList.get(position).getKeterangan());
        holder.tvInfo.setText(promoList.get(position).getStatus_promo());
    }

    @Override
    public int getItemCount() {
        return promoList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvNpm, tvInfo;
        CardView cvMahasiswa;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNpm = itemView.findViewById(R.id.tv_npm);
            tvNama = itemView.findViewById(R.id.tv_title);
            tvInfo = itemView.findViewById(R.id.tv_info);
            cvMahasiswa = itemView.findViewById(R.id.cv_mahasiswa);

        }
  }

}
