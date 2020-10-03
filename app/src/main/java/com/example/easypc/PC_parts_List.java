package com.example.easypc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class PC_parts_List extends ArrayAdapter {

    private Activity mContext;
    List<PC_MODEL> pcPartsList;

    public PC_parts_List(Activity mContext, List<PC_MODEL> pcPartsList) {
        super(mContext, R.layout.list_pc, pcPartsList);
        this.mContext = mContext;
        this.pcPartsList = pcPartsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();

        View listItems = inflater.inflate(R.layout.list_pc, null, true);

        TextView partread = listItems.findViewById(R.id.partread);
        TextView brandread = listItems.findViewById(R.id.brandread);
        TextView modelread = listItems.findViewById(R.id.modelread);
        TextView priceread = listItems.findViewById(R.id.priceread);


        final PC_MODEL insertPcPartsModel = pcPartsList.get(position);

        partread.setText(insertPcPartsModel.getPart());
        brandread.setText(insertPcPartsModel.getBrand());
        modelread.setText(insertPcPartsModel.getModel());
        priceread.setText(String.valueOf(insertPcPartsModel.getPrice()));



        return listItems;

    }
}
