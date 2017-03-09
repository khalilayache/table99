package com.khalilayache.table99.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.khalilayache.table99.R;
import com.khalilayache.table99.model.Person;
import com.squareup.picasso.Picasso;

/**
 * Created by USUARIO
 * on 08/03/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    private static final String PERSON_EXTRA = "person";

    private Person person;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        person = null;
        if (getIntent().hasExtra(PERSON_EXTRA)){
            person = getIntent().getParcelableExtra(PERSON_EXTRA);
        }

        if(savedInstanceState != null  && person == null){
            person = savedInstanceState.getParcelable(PERSON_EXTRA);
        }

        TextView nameView = (TextView) findViewById(R.id.nameView);
        TextView birthdayView = (TextView) findViewById(R.id.birthdayView);
        TextView bioView = (TextView) findViewById(R.id.bioView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        nameView.setText( getString(R.string.name) + ": "+ person.getName());
        birthdayView.setText( getString(R.string.birthday) + ": "+ person.getBirthday());
        bioView.setText( getString(R.string.bio) + ": "+ person.getBio());
        Picasso.with(imageView.getContext())
                .load(person.getImage())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(imageView);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable(PERSON_EXTRA, person);

        super.onSaveInstanceState(savedInstanceState);
    }

}
