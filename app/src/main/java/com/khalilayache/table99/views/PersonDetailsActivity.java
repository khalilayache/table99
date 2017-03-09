package com.khalilayache.table99.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.khalilayache.table99.R;
import com.khalilayache.table99.models.Person;
import com.squareup.picasso.Picasso;

public class PersonDetailsActivity extends AppCompatActivity {

    private static final String PERSON_EXTRA = "person";

    private Person person;

    private TextView nameView;
    private TextView birthdayView;
    private TextView bioView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        person = null;
        if (getIntent().hasExtra(PERSON_EXTRA)) {
            person = getIntent().getParcelableExtra(PERSON_EXTRA);
        }

        if (savedInstanceState != null && person == null) {
            person = savedInstanceState.getParcelable(PERSON_EXTRA);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        nameView = (TextView) findViewById(R.id.nameView);
        birthdayView = (TextView) findViewById(R.id.birthdayView);
        bioView = (TextView) findViewById(R.id.bioView);
        imageView = (ImageView) findViewById(R.id.imageView);

        fillViewFields();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable(PERSON_EXTRA, person);

        super.onSaveInstanceState(savedInstanceState);
    }

    private void fillViewFields() {
        if (person.getName() != null)
            nameView.setText(getString(R.string.name) + ": " + person.getName());
        else
            nameView.setText(getString(R.string.name) + ": " + getString(R.string.error_not_available));

        if (person.getBirthday() != null)
            birthdayView.setText(getString(R.string.birthday) + ": " + person.getBirthday());
        else
            birthdayView.setText(getString(R.string.birthday) + ": " + getString(R.string.error_not_available));

        if (person.getBio() != null)
            bioView.setText(getString(R.string.bio) + ": " + person.getBio());
        else
            bioView.setText(getString(R.string.bio) + ": " + getString(R.string.error_not_available));

        Picasso.with(imageView.getContext())
                .load(person.getImage())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(imageView);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            if (person.getName() != null)
                getSupportActionBar().setTitle(person.getName());
            else
                getSupportActionBar().setTitle(getString(R.string.error_not_available));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
