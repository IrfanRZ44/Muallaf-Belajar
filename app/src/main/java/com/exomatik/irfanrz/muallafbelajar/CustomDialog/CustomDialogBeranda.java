package com.exomatik.irfanrz.muallafbelajar.CustomDialog;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.exomatik.irfanrz.muallafbelajar.ModelData.DataContent;
import com.exomatik.irfanrz.muallafbelajar.R;

/**
 * Created by IrfanRZ on 03/11/2018.
 */

public class CustomDialogBeranda extends DialogFragment {
    TextView textNama, textTitle;
    Button customDialog_Dismiss;
    ImageView imageView;
    public static DataContent dataContent;
    public static int posisiImgAnggota;

    public static CustomDialogBeranda newInstance() {
        return new CustomDialogBeranda();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.dialog_beranda, container, false);

        textNama = (TextView) dialogView.findViewById(R.id.nama);
        textTitle = (TextView) dialogView.findViewById(R.id.title);
        customDialog_Dismiss = (Button) dialogView.findViewById(R.id.dialogdismiss);

        textNama.setText(dataContent.text);
        textTitle.setText(dataContent.title);

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
