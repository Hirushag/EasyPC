package com.example.easypc;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.ArrayList;
import java.util.List;


public class insert_pc_parts extends AppCompatActivity {

    private EditText brand, model, price;
    private Spinner spin;
    private Button submit, choose;
    private ImageView image;
    private StorageReference storeReff;
    private Uri imagePath;
    private StorageTask uploadTask;


    DatabaseReference reff;
    insert_pc_parts_model insertPcPartsModel;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pc_parts);

        Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();

        spin = (Spinner) findViewById(R.id.spin);
        brand = (EditText) findViewById(R.id.brand);
        model = (EditText) findViewById(R.id.model);
        price = (EditText) findViewById(R.id.price);
        submit = (Button) findViewById(R.id.submit);
        image = (ImageView) findViewById(R.id.addimage);
        choose = (Button) findViewById(R.id.choose);
        storeReff = FirebaseStorage.getInstance().getReference("Images");

        insertPcPartsModel = new insert_pc_parts_model();
        reff = FirebaseDatabase.getInstance().getReference().child("PC_PARTS");


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        choose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String InsertPart = spin.getSelectedItem().toString().trim();
                String InsertBrand = brand.getText().toString().trim();
                String InsertModel = model.getText().toString().trim();
                float InsertPrice = Float.parseFloat(price.getText().toString().trim());
                String InsertImage = System.currentTimeMillis()+ "." +getExtension(imagePath);

                insertPcPartsModel.setPart(InsertPart);
                insertPcPartsModel.setBrand(InsertBrand);
                insertPcPartsModel.setModel(InsertModel);
                insertPcPartsModel.setPrice(InsertPrice);
                insertPcPartsModel.setImageID(InsertImage);
                reff.child(String.valueOf(maxid + 1)).setValue(insertPcPartsModel);

                StorageReference ref = storeReff.child(InsertImage);
                uploadTask = ref.putFile(imagePath);

                Intent intent = new Intent(insert_pc_parts.this,manage_pc.class);
                startActivity(intent);

                Toast.makeText(insert_pc_parts.this, "Data insert Success!", Toast.LENGTH_LONG).show();
            }
        });

    }

    //Upload Image
    public void chooseImage() {

        Intent intent = new Intent();
        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

                imagePath = data.getData();
                image.setImageURI(imagePath);
            }
        }

        private String getExtension(Uri uri){
            ContentResolver cr = getContentResolver();
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
        }


    }
