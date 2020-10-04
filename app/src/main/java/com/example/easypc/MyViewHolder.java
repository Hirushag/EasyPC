package com.example.easypc;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textViewID,getTextViewName,getTextViewName1,getTextViewName2;
    ImageView profilePic;
    Button update;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewID=itemView.findViewById(R.id.AtextView1ID_formal);
        getTextViewName=itemView.findViewById(R.id.AtextView2ID_formal);
        getTextViewName1=itemView.findViewById(R.id.AtextView2ID_forma3);
        getTextViewName2=itemView.findViewById(R.id.AtextView2ID_forma4);
        profilePic = itemView.findViewById(R.id.Acard_image_formal);
        update = itemView.findViewById(R.id.update);

    }
}
