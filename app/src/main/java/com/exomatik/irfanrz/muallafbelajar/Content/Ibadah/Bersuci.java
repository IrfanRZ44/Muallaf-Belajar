package com.exomatik.irfanrz.muallafbelajar.Content.Ibadah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.exomatik.irfanrz.muallafbelajar.Content.BimbinganIbadah;
import com.exomatik.irfanrz.muallafbelajar.R;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBersuci;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBimbingan;

import java.util.ArrayList;

public class Bersuci extends AppCompatActivity {
    private ImageView back;
    public Spinner spinnerBersuci;
    public RecyclerView rcBersuci;
    public TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bersuci);

        back = (ImageView) findViewById(R.id.back);
        spinnerBersuci = (Spinner) findViewById(R.id.spinner_bersuci);
        rcBersuci = (RecyclerView) findViewById(R.id.rc_bersuci);
        title = (TextView) findViewById(R.id.title);

        title.setText("Ketentuan Bersuci");
        setSpinner();
        setAdapter(0);

        spinnerBersuci.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setAdapter(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Bersuci.this, BimbinganIbadah.class));
                finish();
            }
        });
    }

    public void setSpinner() {
        ArrayList<String> list = new ArrayList<String>();

        list.add(getResources().getString(R.string.bersuci1));
        list.add(getResources().getString(R.string.bersuci2));

        ArrayAdapter<String> dataAngkatan = new ArrayAdapter<String>(Bersuci.this,
                R.layout.spinner_text, list);

        spinnerBersuci.setAdapter(dataAngkatan);
    }

    public void setAdapter(int position) {
        ArrayList<String> hasilData = new ArrayList<String>();
        switch (position){
            case 0:
                hasilData.add(getResources().getString(R.string.ct_suci1));
                hasilData.add(getResources().getString(R.string.ct_suci2));
                hasilData.add(getResources().getString(R.string.ct_suci3));
                hasilData.add(getResources().getString(R.string.ct_suci4));
                break;
            case 1:
                hasilData.add(getResources().getString(R.string.ct_suci5));
                hasilData.add(getResources().getString(R.string.ct_suci6));
                break;
        }

        RecyclerBersuci adapterAgenda = new RecyclerBersuci(hasilData);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rcBersuci.setLayoutManager(layoutAgenda);
        rcBersuci.setNestedScrollingEnabled(false);
        rcBersuci.setAdapter(adapterAgenda);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Bersuci.this, BimbinganIbadah.class));
        finish();
    }
}
