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

public class Haji extends Bersuci {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title.setText("Ketentuan Haji");
    }
    @Override
    public void setSpinner() {
        super.setSpinner();
        ArrayList<String> list = new ArrayList<String>();

        list.add(getResources().getString(R.string.haji1));
        list.add(getResources().getString(R.string.haji2));
        list.add(getResources().getString(R.string.haji3));

        ArrayAdapter<String> dataAngkatan = new ArrayAdapter<String>(Haji.this,
                R.layout.spinner_text, list);

        spinnerBersuci.setAdapter(dataAngkatan);
    }

    @Override
    public void setAdapter(int position) {
        super.setAdapter(position);
        ArrayList<String> hasilData = new ArrayList<String>();
        switch (position){
            case 0:
                hasilData.add(getResources().getString(R.string.ct_haji1));
                hasilData.add(getResources().getString(R.string.ct_haji2));
                hasilData.add(getResources().getString(R.string.ct_haji3));
                hasilData.add(getResources().getString(R.string.ct_haji4));
                hasilData.add(getResources().getString(R.string.ct_haji5));
                break;
            case 1:
                hasilData.add(getResources().getString(R.string.ct_haji6));
                hasilData.add(getResources().getString(R.string.ct_haji7));
                hasilData.add(getResources().getString(R.string.ct_haji8));
                hasilData.add(getResources().getString(R.string.ct_haji9));
                hasilData.add(getResources().getString(R.string.ct_haji10));
                hasilData.add(getResources().getString(R.string.ct_haji11));
                break;
            case 2:
                hasilData.add(getResources().getString(R.string.ct_haji12));
                hasilData.add(getResources().getString(R.string.ct_haji13));
                hasilData.add(getResources().getString(R.string.ct_haji14));
                hasilData.add(getResources().getString(R.string.ct_haji15));
                hasilData.add(getResources().getString(R.string.ct_haji16));
                hasilData.add(getResources().getString(R.string.ct_haji17));
                hasilData.add(getResources().getString(R.string.ct_haji18));
                hasilData.add(getResources().getString(R.string.ct_haji19));
                break;
        }

        RecyclerBersuci adapterAgenda = new RecyclerBersuci(hasilData);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rcBersuci.setLayoutManager(layoutAgenda);
        rcBersuci.setNestedScrollingEnabled(false);
        rcBersuci.setAdapter(adapterAgenda);
    }
}
