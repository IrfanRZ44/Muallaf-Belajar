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
import android.widget.ImageView;
import android.widget.TextView;

import com.exomatik.irfanrz.muallafbelajar.ModelData.DataContent;
import com.exomatik.irfanrz.muallafbelajar.ModelData.DataDoa;
import com.exomatik.irfanrz.muallafbelajar.R;
import com.exomatik.irfanrz.muallafbelajar.RecyclerView.RecyclerContent;

import java.util.ArrayList;

/**
 * Created by IrfanRZ on 03/11/2018.
 */

public class CustomDialogDoa extends DialogFragment {
    TextView textTitle;
    Button customDialog_Dismiss;
    ImageView imageDoa;
    public static DataDoa data;

    public static CustomDialogDoa newInstance() {
        return new CustomDialogDoa();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.dialog_doa, container, false);

        textTitle = (TextView) dialogView.findViewById(R.id.title);
        imageDoa = (ImageView) dialogView.findViewById(R.id.img_doa);
        customDialog_Dismiss = (Button) dialogView.findViewById(R.id.dialogdismiss);

        textTitle.setText(data.title);
        imageDoa.setImageResource(data.imageResources);

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
