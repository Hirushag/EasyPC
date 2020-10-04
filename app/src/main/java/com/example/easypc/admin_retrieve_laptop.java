package com.example.easypc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class admin_retrieve_laptop extends AppCompatActivity {

    DatabaseReference ref;
    ImageView text1;
    Button update,delete;
    private FirebaseRecyclerOptions<laptops> options;
    private FirebaseRecyclerAdapter<laptops, MyViewHolder>adapter;
    private RecyclerView recyclerView;
    public static List<laptops> laptops,keylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_retrieve_laptop);
        text1 = findViewById(R.id.Acard_image_formal);
        delete =findViewById(R.id.delete);
        update = findViewById(R.id.update_upload);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ref = FirebaseDatabase.getInstance().getReference("member");

        options = new FirebaseRecyclerOptions.Builder<laptops>().setQuery(ref,laptops.class).build();
        adapter= new FirebaseRecyclerAdapter<laptops, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final laptops model) {
                holder.textViewID.setText(""+model.getBrand());
                holder.getTextViewName.setText(""+model.getModel());
                holder.getTextViewName1.setText(""+model.getPrice());
                holder.getTextViewName2.setText(""+model.getDescription());
                final String model1 = model.getModel();
                final String price1= model.getPrice();
                final String description1= model.getDescription();
                holder.update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        laptops = new ArrayList<>();
                        laptops.add(model);

                        Intent intent = new Intent(admin_retrieve_laptop.this, update_laptops.class);
                        intent.putExtra("test",model1);
                        intent.putExtra("test2",price1);
                        intent.putExtra("test3",description1);
                        startActivity(intent);
                    }
                });

                Picasso.get().load(model.getImage()).into(holder.profilePic);
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.laptop_layout_ud,parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}