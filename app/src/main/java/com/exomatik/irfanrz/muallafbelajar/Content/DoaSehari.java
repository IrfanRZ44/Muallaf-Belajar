package com.exomatik.irfanrz.muallafbelajar.Content;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.exomatik.irfanrz.muallafbelajar.CustomDialog.CustomDialogDoa;
import com.exomatik.irfanrz.muallafbelajar.CustomDialog.CustomDialogKeimanan;
import com.exomatik.irfanrz.muallafbelajar.MainActivity;
import com.exomatik.irfanrz.muallafbelajar.ModelData.DataDoa;
import com.exomatik.irfanrz.muallafbelajar.R;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.ItemClickSupport;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBersuci;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBimbingan;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerDoa;

import java.util.ArrayList;

public class DoaSehari extends AppCompatActivity implements ItemClickSupport.OnItemClickListener {
    private ImageView back;
    private ArrayList<DataDoa> doa = new ArrayList<DataDoa>();
    private RecyclerView rcDoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_sehari);

        back = (ImageView) findViewById(R.id.back);
        rcDoa = (RecyclerView) findViewById(R.id.rc_doa);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoaSehari.this, MainActivity.class));
                finish();
            }
        });

        getDataDoa();
    }

    private void getDataDoa() {
        doa = new ArrayList<DataDoa>();
        doa.add(new DataDoa("Doa Keluar Rumah", R.drawable.doa_keluar_rumah));
        doa.add(new DataDoa("Doa Masuk Rumah", R.drawable.doa_masuk_rumah));
        doa.add(new DataDoa("Doa Makan", R.drawable.doa_makan));
        doa.add(new DataDoa("Doa Masuk WC", R.drawable.doa_masuk_wc));
        doa.add(new DataDoa("Doa Keluar WC", R.drawable.doa_keluar_wc));

        RecyclerDoa adapterAgenda = new RecyclerDoa(doa);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rcDoa.setLayoutManager(layoutAgenda);
        rcDoa.setNestedScrollingEnabled(false);
        rcDoa.setAdapter(adapterAgenda);

        ItemClickSupport.addTo(rcDoa)
                .setOnItemClickListener(this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(DoaSehari.this, MainActivity.class));
        finish();
    }

    @Override
    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        CustomDialogDoa.data = new DataDoa(doa.get(position).title, doa.get(position).imageResources);

        DialogFragment newFragment = CustomDialogDoa
                .newInstance();

        newFragment.setCancelable(false);

        newFragment.show(DoaSehari.this.getFragmentManager(), "dialog");
    }
}
