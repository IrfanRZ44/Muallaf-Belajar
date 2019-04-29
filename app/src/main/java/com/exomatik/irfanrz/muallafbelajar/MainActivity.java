package com.exomatik.irfanrz.muallafbelajar;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.exomatik.irfanrz.muallafbelajar.Content.BimbinganIbadah;
import com.exomatik.irfanrz.muallafbelajar.Content.BimbinganKeimanan;
import com.exomatik.irfanrz.muallafbelajar.Content.BimbinganKeislaman;
import com.exomatik.irfanrz.muallafbelajar.Content.DoaSehari;
import com.exomatik.irfanrz.muallafbelajar.CustomDialog.CustomDialogBeranda;
import com.exomatik.irfanrz.muallafbelajar.ModelData.DataContent;

public class MainActivity extends AppCompatActivity {
    private LinearLayout rlBeranda, rlKeimanan, rlKeislaman, rlIbadah, rlDoa;
    private boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlBeranda = (LinearLayout) findViewById(R.id.rl_bersuci);
        rlDoa = (LinearLayout) findViewById(R.id.rl_doa);
        rlIbadah = (LinearLayout) findViewById(R.id.rl_ibadah);
        rlKeislaman = (LinearLayout) findViewById(R.id.rl_keislaman);
        rlKeimanan = (LinearLayout) findViewById(R.id.rl_keimanan);

        rlBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogBeranda.dataContent = new DataContent(getResources().getString(R.string.app_name)
                            , getResources().getString(R.string.content_beranda)
                );
                DialogFragment newFragment = CustomDialogBeranda
                        .newInstance();

                newFragment.setCancelable(false);

                newFragment.show(MainActivity.this.getFragmentManager(), "dialog");
            }
        });

        rlKeimanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BimbinganKeimanan.class);
                startActivity(intent);
                finish();
            }
        });

        rlKeislaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BimbinganKeislaman.class);
                startActivity(intent);
                finish();
            }
        });

        rlIbadah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BimbinganIbadah.class);
                startActivity(intent);
                finish();
            }
        });

        rlDoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoaSehari.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            minimizeApp();
            return;
        } else {
            Toast toast = Toast.makeText(MainActivity.this, "Tekan Cepat 2 Kali untuk Keluar", Toast.LENGTH_SHORT);
            toast.show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 2000);
        }
    }

    public void minimizeApp() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
