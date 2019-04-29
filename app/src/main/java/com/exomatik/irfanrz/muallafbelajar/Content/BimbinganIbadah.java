package com.exomatik.irfanrz.muallafbelajar.Content;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.exomatik.irfanrz.muallafbelajar.Content.Ibadah.Bersuci;
import com.exomatik.irfanrz.muallafbelajar.Content.Ibadah.Haji;
import com.exomatik.irfanrz.muallafbelajar.Content.Ibadah.Puasa;
import com.exomatik.irfanrz.muallafbelajar.Content.Ibadah.Shalat;
import com.exomatik.irfanrz.muallafbelajar.Content.Ibadah.Zakat;
import com.exomatik.irfanrz.muallafbelajar.MainActivity;
import com.exomatik.irfanrz.muallafbelajar.R;

public class BimbinganIbadah extends AppCompatActivity {
    private ImageView back;
    private LinearLayout lnBersuci, lnZakat, lnPuasa, lnShalat, lnHaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimbingan_ibadah);

        back = (ImageView) findViewById(R.id.back);

        lnBersuci = (LinearLayout)findViewById(R.id.rl_bersuci);
        lnZakat = (LinearLayout)findViewById(R.id.rl_zakat);
        lnPuasa = (LinearLayout) findViewById(R.id.rl_puasa);
        lnHaji = (LinearLayout) findViewById(R.id.rl_haji);
        lnShalat = (LinearLayout) findViewById(R.id.rl_sholat);

        lnBersuci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganIbadah.this, Bersuci.class));
                finish();
            }
        });

        lnZakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganIbadah.this, Zakat.class));
                finish();
            }
        });

        lnShalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganIbadah.this, Shalat.class));
                finish();
            }
        });

        lnPuasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganIbadah.this, Puasa.class));
                finish();
            }
        });

        lnHaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganIbadah.this, Haji.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganIbadah.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BimbinganIbadah.this, MainActivity.class));
        finish();
    }
}
