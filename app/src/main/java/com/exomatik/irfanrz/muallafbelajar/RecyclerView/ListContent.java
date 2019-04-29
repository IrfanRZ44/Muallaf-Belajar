package com.exomatik.irfanrz.muallafbelajar.RecyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.exomatik.irfanrz.muallafbelajar.ModelData.DataContent;
import com.exomatik.irfanrz.muallafbelajar.R;

import java.util.ArrayList;

/**
 * Created by IrfanRZ on 5/21/2018.
 */

public class ListContent extends BaseAdapter {
    private Context mContext;
    private ArrayList<DataContent> dataContent = new ArrayList<DataContent>();

    public ListContent(Context mContext, ArrayList<DataContent> dataUsers) {
        this.mContext = mContext;
        this.dataContent = dataUsers;
    }

    @Override
    public int getCount() {
        return dataContent.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_content, null);
        TextView listName = (TextView) v.findViewById(R.id.textSub);

        listName.setText("text");

        return v;
    }
}
