package com.example.easypc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder3 extends RecyclerView.ViewHolder {
    TextView textViewID,getTextViewName,getTextViewName1,getTextViewName2,getTextViewName3;
    ImageView profilePic;
    public MyViewHolder3(@NonNull View itemView) {
        super(itemView);
        textViewID=itemView.findViewById(R.id.AtextView1ID_forma30);
        getTextViewName=itemView.findViewById(R.id.AtextView1ID_formal31);
        getTextViewName1=itemView.findViewById(R.id.AtextView2ID_formal32);
        getTextViewName2=itemView.findViewById(R.id.AtextView2ID_forma33);
        getTextViewName3=itemView.findViewById(R.id.AtextView2ID_forma34);
        profilePic = itemView.findViewById(R.id.Acard_image_formal);


    }
}