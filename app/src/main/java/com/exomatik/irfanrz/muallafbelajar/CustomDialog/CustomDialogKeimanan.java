package com.exomatik.irfanrz.muallafbelajar.CustomDialog;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.exomatik.irfanrz.muallafbelajar.ModelData.DataContent;
import com.exomatik.irfanrz.muallafbelajar.R;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.ListContent;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerBimbingan;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerContent;

import java.util.ArrayList;

/**
 * Created by IrfanRZ on 03/11/2018.
 */

public class CustomDialogKeimanan extends DialogFragment {
    TextView textTitle;
    Button customDialog_Dismiss;
    public static ArrayList<DataContent> data = new ArrayList<DataContent>();
    public static int posisi;
    RecyclerView listContent;

    public static CustomDialogKeimanan newInstance() {
        return new CustomDialogKeimanan();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.dialog_keimanan, container, false);

        textTitle = (TextView) dialogView.findViewById(R.id.title);
        customDialog_Dismiss = (Button) dialogView.findViewById(R.id.dialogdismiss);
        listContent = (RecyclerView) dialogView.findViewById(R.id.rc_content);

        textTitle.setText(data.get(posisi).title);

        RecyclerContent adapterAgenda = new RecyclerContent(data);
        RecyclerView.LayoutManager layoutAgenda = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        listContent.setLayoutManager(layoutAgenda);
        listContent.setNestedScrollingEnabled(false);
        listContent.setAdapter(adapterAgenda);

        customDialog_Dismiss.setOnClickListener(customDialog_DismissOnClickListener);

        return dialogView;
    }


    private Button.OnClickListener customDialog_DismissOnClickListener
            = new Button.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            dismiss();
        }
    };

}
