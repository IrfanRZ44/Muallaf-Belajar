package com.exomatik.irfanrz.muallafbelajar.Content.Ibadah;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.exomatik.irfanrz.muallafbelajar.R;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBersuci;

import java.util.ArrayList;

/**
 * Created by IrfanRZ on 20/11/2018.
 */

public class Shalat extends Bersuci {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title.setText("Melaksanakan Shalat");
    }

    @Override
    public void setSpinner() {
        super.setSpinner();
        ArrayList<String> list = new ArrayList<String>();

        list.add(getResources().getString(R.string.shalat1));
        list.add(getResources().getString(R.string.shalat2));

        ArrayAdapter<String> dataAngkatan = new ArrayAdapter<String>(Shalat.this,
                R.layout.spinner_text, list);

        spinnerBersuci.setAdapter(dataAngkatan);
    }

    @Override
    public void setAdapter(int position) {
        super.setAdapter(position);
        ArrayList<String> hasilData = new ArrayList<String>();
        switch (position){
            case 0:
                hasilData.add(getResources().getString(R.string.ct_shalat1));
                hasilData.add(getResources().getString(R.string.ct_shalat2));
                hasilData.add(getResources().getString(R.string.ct_shalat3));
                hasilData.add(getResources().getString(R.string.ct_shalat4));
                hasilData.add(getResources().getString(R.string.ct_shalat5));

                break;
            case 1:
                hasilData.add(getResources().getString(R.string.ct_shalat6));
                hasilData.add(getResources().getString(R.string.ct_shalat7));
                hasilData.add(getResources().getString(R.string.ct_shalat8));
                hasilData.add(getResources().getString(R.string.ct_shalat9));
                hasilData.add(getResources().getString(R.string.ct_shalat10));
                hasilData.add(getResources().getString(R.string.ct_shalat11));
                hasilData.add(getResources().getString(R.string.ct_shalat12));
                hasilData.add(getResources().getString(R.string.ct_shalat13));
                hasilData.add(getResources().getString(R.string.ct_shalat14));
                hasilData.add(getResources().getString(R.string.ct_shalat15));
                break;
        }

        RecyclerBersuci adapterAgenda = new RecyclerBersuci(hasilData);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rcBersuci.setLayoutManager(layoutAgenda);
        rcBersuci.setNestedScrollingEnabled(false);
        rcBersuci.setAdapter(adapterAgenda);
    }
}
