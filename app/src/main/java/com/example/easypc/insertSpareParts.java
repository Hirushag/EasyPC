package com.example.easypc;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class insertSpareParts extends AppCompatActivity {

    EditText part,price,model,brand,description;
    Button submit,choose;
    DatabaseReference reff;
    spareparts spareMem;
    ImageView img;
    StorageReference StorageRef;
    long maxid;
    public Uri imguri;
    private StorageTask uploadTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_spare_parts);
        StorageRef = FirebaseStorage.getInstance().getReference("images");
        model = findViewById(R.id.formal_addm);
        part = findViewById(R.id.formal_addpa);
        price = findViewById(R.id.formal_addp);
        brand = findViewById(R.id.formal_addb);
        description = findViewById(R.id.formal_addd);
        submit = findViewById(R.id.formal_submit);
        spareMem =new spareparts();
        choose = findViewById(R.id.formal_submit2);
        img = findViewById(R.id.formal_addimg);
        reff = FirebaseDatabase.getInstance().getReference().child("member3");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spareMem.setPrice(price.getText().toString());
                spareMem.setPart(part.getText().toString());
                spareMem.setModel(model.getText().toString());
                spareMem.setBrand(brand.getText().toString());
                spareMem.setDescription(description.getText().toString());
                reff.child(brand.getText().toString()).setValue(spareMem);
                Toast.makeText(insertSpareParts.this,"Spare part added successfully",Toast.LENGTH_LONG).show();
                Fileupload();

                Intent intent = new Intent(insertSpareParts.this, manage_spare_parts.class);
                startActivity(intent);
            }
        });


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

    }

    private String getExtention(Uri uri){

        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void Fileupload(){

        StorageReference Ref = StorageRef.child(System.currentTimeMillis()+"."+getExtention(imguri));
        Ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(insertSpareParts.this,"Image upload successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {

                    }
                });

    }
    private void Filechooser(){

        Intent intent =new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK&&data!=null&&data.getData()!=null){

            imguri = data.getData();
            img.setImageURI(imguri);
        }
    }

    public void home(View view) {

        ImageView image = findViewById(R.id.logo);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(insertSpareParts.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
