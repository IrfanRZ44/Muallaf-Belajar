package com.exomatik.irfanrz.muallafbelajar.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exomatik.irfanrz.muallafbelajar.ModelData.DataKeimanan;
import com.exomatik.irfanrz.muallafbelajar.R;

import java.util.ArrayList;

/**
 * Created by IrfanRZ on 17/09/2018.
 */

public class RecyclerBimbingan extends RecyclerView.Adapter<RecyclerBimbingan.bidangViewHolder> {
    private ArrayList<DataKeimanan> dataList;
    private Context context;

    public RecyclerBimbingan(ArrayList<DataKeimanan> dataList) {
        this.dataList = dataList;
    }

    @Override
    public bidangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_kategori, parent, false);
        this.context = parent.getContext();
        return new bidangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(bidangViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class bidangViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;

        public bidangViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
