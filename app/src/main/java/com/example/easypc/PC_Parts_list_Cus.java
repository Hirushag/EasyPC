package com.example.easypc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PC_Parts_list_Cus extends ArrayAdapter {

    private Activity mContext;
    List<PC_MODEL> pcPartsList;

    public PC_Parts_list_Cus(Activity mContext, List<PC_MODEL> pcPartsList) {
        super(mContext, R.layout.list_pc_cus, pcPartsList);
        this.mContext = mContext;
        this.pcPartsList = pcPartsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();

        View listItems = inflater.inflate(R.layout.list_pc_cus, null, true);

        TextView partcus = listItems.findViewById(R.id.partcus);
        TextView brandcus = listItems.findViewById(R.id.brandcus);
        TextView modelcus = listItems.findViewById(R.id.modelcus);
        TextView pricecus = listItems.findViewById(R.id.pricecus);
        Button cart = listItems.findViewById(R.id.cart);



        final PC_MODEL insertPcPartsModel = pcPartsList.get(position);

        partcus.setText(insertPcPartsModel.getPart());
        brandcus.setText(insertPcPartsModel.getBrand());
        modelcus.setText(insertPcPartsModel.getModel());
        pricecus.setText(String.valueOf(insertPcPartsModel.getPrice()));

        return listItems;

    }



}
