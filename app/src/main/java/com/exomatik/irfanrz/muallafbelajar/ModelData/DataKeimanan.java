package com.exomatik.irfanrz.muallafbelajar.ModelData;

import java.util.ArrayList;

/**
 * Created by IrfanRZ on 20/11/2018.
 */

public class DataKeimanan {
    public String title;
    public ArrayList<DataContent> content;

    public DataKeimanan() {
    }

    public DataKeimanan(String title, ArrayList<DataContent> content) {
        this.title = title;
        this.content = content;
    }
}
