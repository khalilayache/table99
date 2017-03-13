package com.khalilayache.table99.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khalilayache.table99.R;

public class PersonRecyclerViewHolder extends RecyclerView.ViewHolder {

    public final ImageView imageView;
    public final TextView nameView;
    public final TextView birthdayView;
    public final TextView bioView;

    public PersonRecyclerViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        nameView = (TextView) itemView.findViewById(R.id.nameView);
        birthdayView = (TextView) itemView.findViewById(R.id.birthdayView);
        bioView = (TextView) itemView.findViewById(R.id.bioView);
    }
}
