package com.exomatik.irfanrz.muallafbelajar.Content;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.exomatik.irfanrz.muallafbelajar.CustomDialog.CustomDialogKeimanan;
import com.exomatik.irfanrz.muallafbelajar.MainActivity;
import com.exomatik.irfanrz.muallafbelajar.ModelData.DataContent;
import com.exomatik.irfanrz.muallafbelajar.ModelData.DataKeimanan;
import com.exomatik.irfanrz.muallafbelajar.R;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.ItemClickSupport;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBimbingan;

import java.util.ArrayList;

public class BimbinganKeimanan extends AppCompatActivity implements ItemClickSupport.OnItemClickListener  {
    private ImageView back;
    private RecyclerView rc_iman;
    private ArrayList<DataKeimanan> dataKeimanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimbingan_keimanan);

        back = (ImageView) findViewById(R.id.back);
        rc_iman = (RecyclerView) findViewById(R.id.rc_iman);

        getDataKeimanan();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganKeimanan.this, MainActivity.class));
                finish();
            }
        });
    }

    private void getDataKeimanan(){
        String title1 = getResources().getString(R.string.keimanan1);
        String title2 = getResources().getString(R.string.keimanan2);
        String title3 = getResources().getString(R.string.keimanan3);
        String title4 = getResources().getString(R.string.keimanan4);
        String title5 = getResources().getString(R.string.keimanan5);
        String title6 = getResources().getString(R.string.keimanan6);

        dataKeimanan = new ArrayList<DataKeimanan>();
        dataKeimanan.add(new DataKeimanan(title1, getContent(title1, 1)));
        dataKeimanan.add(new DataKeimanan(title2, getContent(title2, 2)));
        dataKeimanan.add(new DataKeimanan(title3, getContent(title3, 3)));
        dataKeimanan.add(new DataKeimanan(title4, getContent(title4, 4)));
        dataKeimanan.add(new DataKeimanan(title5, getContent(title5, 5)));
        dataKeimanan.add(new DataKeimanan(title6, getContent(title6,6)));

        setAdapterRC(dataKeimanan);
    }

    private ArrayList<DataContent> getContent(String title, int kontent){
        ArrayList<DataContent> content = new ArrayList<DataContent>();

        switch (kontent){
            case 1:
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman1)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman2)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman3)));
                break;
            case 2:
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman4)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman5)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman6)));
                break;
            case 3:
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman7)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman8)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman9)));
                break;
            case 4:
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman10)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman11)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman12)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman13)));
                break;
            case 5:
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman14)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman15)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman16)));
                break;
            case 6:
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman17)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman18)));
                content.add(new DataContent(title, getResources().getString(R.string.ct_iman19)));
                break;
        }

        return content;
    }

    private void setAdapterRC(ArrayList<DataKeimanan> hasilData){
        RecyclerBimbingan adapterAgenda = new RecyclerBimbingan(hasilData);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rc_iman.setLayoutManager(layoutAgenda);
        rc_iman.setNestedScrollingEnabled(false);
        rc_iman.setAdapter(adapterAgenda);

        ItemClickSupport.addTo(rc_iman)
                .setOnItemClickListener(this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BimbinganKeimanan.this, MainActivity.class));
        finish();
    }

    @Override
    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
        CustomDialogKeimanan.data = new ArrayList<DataContent>();
        for (int a = 0; a < dataKeimanan.get(position).content.size(); a++){
            CustomDialogKeimanan.data.add(new DataContent(dataKeimanan.get(position).content.get(a).title
                    , dataKeimanan.get(position).content.get(a).text));
            CustomDialogKeimanan.posisi = a;
        }
        DialogFragment newFragment = CustomDialogKeimanan
                .newInstance();

        newFragment.setCancelable(false);

        newFragment.show(BimbinganKeimanan.this.getFragmentManager(), "dialog");
    }
}
