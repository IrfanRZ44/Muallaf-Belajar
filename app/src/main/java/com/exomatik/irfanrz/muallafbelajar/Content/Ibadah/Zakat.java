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

public class Zakat extends Bersuci {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title.setText("Menunaikan Zakat");
    }

    @Override
    public void setSpinner() {
        super.setSpinner();
        ArrayList<String> list = new ArrayList<String>();

        list.add(getResources().getString(R.string.zakat1));
        list.add(getResources().getString(R.string.zakat2));

        ArrayAdapter<String> dataAngkatan = new ArrayAdapter<String>(Zakat.this,
                R.layout.spinner_text, list);

        spinnerBersuci.setAdapter(dataAngkatan);
    }

    @Override
    public void setAdapter(int position) {
        super.setAdapter(position);
        ArrayList<String> hasilData = new ArrayList<String>();
        switch (position){
            case 0:
                hasilData.add(getResources().getString(R.string.ct_zakat1));
                hasilData.add(getResources().getString(R.string.ct_zakat2));
                hasilData.add(getResources().getString(R.string.ct_zakat3));
                hasilData.add(getResources().getString(R.string.ct_zakat4));
                break;
            case 1:
                hasilData.add(getResources().getString(R.string.ct_zakat5));
                hasilData.add(getResources().getString(R.string.ct_zakat6));
                hasilData.add(getResources().getString(R.string.ct_zakat7));
                break;
        }

        RecyclerBersuci adapterAgenda = new RecyclerBersuci(hasilData);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rcBersuci.setLayoutManager(layoutAgenda);
        rcBersuci.setNestedScrollingEnabled(false);
        rcBersuci.setAdapter(adapterAgenda);
    }
}
