package com.khalilayache.table99.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.khalilayache.table99.R;
import com.khalilayache.table99.model.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by USUARIO
 * on 08/03/2017.
 */

public class PersonListAdapter extends ArrayAdapter<Person>{

    public PersonListAdapter(Context context, List<Person> personList){
        super(context,0,personList);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,@NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.person_list_item,parent,false);
        }

        final Person currentPerson = getItem(position);

        if(currentPerson != null) {

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);
            Picasso.with(getContext())
                    .load(currentPerson.getImage())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imageView);

            TextView nameView = (TextView) listItemView.findViewById(R.id.nameView);
            nameView.setText(currentPerson.getName());

            TextView birthdayView = (TextView) listItemView.findViewById(R.id.birthdayView);
            if (currentPerson.getBirthday() != null) {
                birthdayView.setText(currentPerson.getBirthday());
            } else {
                birthdayView.setText(birthdayView.getContext().getString(R.string.error_not_available));
            }

            TextView bioView = (TextView) listItemView.findViewById(R.id.bioView);
            bioView.setText(currentPerson.getBio());
        }

        return listItemView;
    }
}
