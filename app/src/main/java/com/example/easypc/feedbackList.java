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

public class feedbackList extends ArrayAdapter <FeedBackClass> {

    private Activity context;
    private List<FeedBackClass> feedbackList;

    public feedbackList(Activity context, List<FeedBackClass> feedbackList){
        super(context, R.layout.activity_feedback_list,feedbackList);
        this.context = context;
        this.feedbackList = feedbackList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.activity_feedback_list, null, true);

        TextView textViewBrand = (TextView) listViewItem.findViewById(R.id.textViewBrand);
        TextView textViewType = (TextView) listViewItem.findViewById(R.id.textViewType);
        TextView textViewDescription = (TextView) listViewItem.findViewById(R.id.textViewDescription);

        FeedBackClass feedback = feedbackList.get(position);

        textViewBrand.setText(feedback.getBrand());
        textViewDescription.setText(feedback.getDescription());
        textViewType.setText(feedback.getType());

        return listViewItem;


    }
}
