package com.example.easypc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class user_retrieve_laptop extends AppCompatActivity {

    DatabaseReference ref;
    ImageView text1;
    private FirebaseRecyclerOptions<laptops> options;
    private FirebaseRecyclerAdapter<laptops, MyViewHolder>adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_retrieve_laptop);
        text1 = findViewById(R.id.Acard_image_formal);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ref = FirebaseDatabase.getInstance().getReference("member");

        options = new FirebaseRecyclerOptions.Builder<laptops>().setQuery(ref,laptops.class).build();
        adapter= new FirebaseRecyclerAdapter<laptops, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull laptops model) {
                holder.textViewID.setText(""+model.getBrand());
                holder.getTextViewName.setText(""+model.getModel());
                holder.getTextViewName1.setText(""+model.getPrice());
                holder.getTextViewName2.setText(""+model.getDescription());

                Picasso.get().load(model.getImage()).into(holder.profilePic);
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.laptop_layout,parent,false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}
