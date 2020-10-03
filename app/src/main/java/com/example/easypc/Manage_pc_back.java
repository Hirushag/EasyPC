package com.example.easypc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Manage_pc_back extends AppCompatActivity {

    ListView PClist;
    List<PC_MODEL> pcList;

    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_pc_back);

        PClist = findViewById(R.id.list);

        pcList = new ArrayList<>();
        reff = FirebaseDatabase.getInstance().getReference("PC_PARTS");


        reff.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pcList.clear();

                for (DataSnapshot PCSnap : snapshot.getChildren()) {

                    PC_MODEL insertPcPartsModel = PCSnap.getValue(PC_MODEL.class);
                    pcList.add(insertPcPartsModel);

                }

                PC_parts_List list = new PC_parts_List(Manage_pc_back.this, pcList);
                PClist.setAdapter(list);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        PClist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                PC_MODEL updateModel = pcList.get(i);
                showUpdatePC(updateModel.getId(),updateModel.getPart(),updateModel.getBrand(),updateModel.getModel(),updateModel.getPrice());

                return false;
            }
        });
    }

    private void showUpdatePC(final String id,String parts, String brand, String model, String price ){

         final AlertDialog.Builder updateDisplay = new AlertDialog.Builder(this);
        LayoutInflater inflater =getLayoutInflater();
        final View updateDisplayView = inflater.inflate(R.layout.update_pc,null);
        updateDisplay.setView(updateDisplayView);

        final Spinner partUpdate = updateDisplayView.findViewById(R.id.updataSpin);
        final EditText brandUpdate = updateDisplayView.findViewById(R.id.updateBrand);
        final EditText modelUpdate = updateDisplayView.findViewById(R.id.updateModel);
        final EditText priceUpdate = updateDisplayView.findViewById(R.id.updatePrice);

        final Button buttonUpdate = updateDisplayView.findViewById(R.id.updateButton);

        final AlertDialog alertDialog = updateDisplay.create();
        alertDialog.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String part = partUpdate.getSelectedItem().toString();
                String brand = brandUpdate.getText().toString().trim();
                String model = modelUpdate.getText().toString().trim();
                String price=  priceUpdate.getText().toString();

                updatePC(id,part,brand,model,price);
                alertDialog.dismiss();

            }
        });

    }

    private boolean updatePC(String id,String part ,String brand ,String model ,String price){


       DatabaseReference Dreff = FirebaseDatabase.getInstance().getReference("PC_PARTS").child(id);
        PC_MODEL UpdatePC = new PC_MODEL(id,part,brand,model,price);
        Dreff.setValue(UpdatePC);

        Toast.makeText(this,"Updated!",Toast.LENGTH_LONG).show();
        return true;

    }
}