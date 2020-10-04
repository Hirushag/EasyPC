package com.example.easypc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder2 extends RecyclerView.ViewHolder {
    TextView textViewID,getTextViewName,getTextViewName1,getTextViewName2,getTextViewName3;
    ImageView profilePic;
    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);
        textViewID=itemView.findViewById(R.id.AtextView1ID_forma20);
        getTextViewName=itemView.findViewById(R.id.AtextView1ID_formal21);
        getTextViewName1=itemView.findViewById(R.id.AtextView2ID_formal22);
        getTextViewName2=itemView.findViewById(R.id.AtextView2ID_forma23);
        getTextViewName3=itemView.findViewById(R.id.AtextView2ID_forma24);
        profilePic = itemView.findViewById(R.id.Acard_image_formal);


    }
}