package com.khalilayache.table99.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khalilayache.table99.R;
import com.khalilayache.table99.models.Person;
import com.khalilayache.table99.views.PersonDetailsActivity;
import com.khalilayache.table99.views.holders.PersonRecyclerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonRecyclerAdapter extends RecyclerView.Adapter {

    private static final String PERSON_EXTRA = "person";

    private ArrayList<Person> personArrayList;
    private Context context;

    public PersonRecyclerAdapter(Context context, ArrayList<Person> personList) {
        this.personArrayList = personList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.person_list_item, parent, false);


        return new PersonRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        PersonRecyclerViewHolder viewHolder = (PersonRecyclerViewHolder) holder;

        final Person currentPerson = personArrayList.get(position);

        if(currentPerson.getName() != null)
            viewHolder.nameView.setText(currentPerson.getName());
        if(currentPerson.getBio() != null)
            viewHolder.bioView.setText(currentPerson.getBio());
        if(currentPerson.getBirthday() != null)
            viewHolder.birthdayView.setText(currentPerson.getBirthday());
        if(currentPerson.getImage() != null)
            Picasso.with(context)
                    .load(currentPerson.getImage())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                    .into(viewHolder.imageView);

        setClickListeners(viewHolder, currentPerson);



    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    private void setClickListeners(PersonRecyclerViewHolder viewHolder, Person currentPerson) {
        viewHolder.imageView.setOnClickListener(onItemClickListener(currentPerson));
        viewHolder.bioView.setOnClickListener(onItemClickListener(currentPerson));
        viewHolder.nameView.setOnClickListener(onItemClickListener(currentPerson));
        viewHolder.birthdayView.setOnClickListener(onItemClickListener(currentPerson));
    }

    private View.OnClickListener onItemClickListener(final Person currentPerson){

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonDetailsActivity.class);
                intent.putExtra(PERSON_EXTRA, currentPerson);
                context.startActivity(intent);
            }
        };

    }

}
