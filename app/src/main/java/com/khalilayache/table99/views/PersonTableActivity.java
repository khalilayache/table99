package com.khalilayache.table99.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.khalilayache.table99.utils.BuilderJSON;
import com.khalilayache.table99.R;
import com.khalilayache.table99.adapters.PersonRecyclerAdapter;
import com.khalilayache.table99.models.Person;

import java.util.ArrayList;


public class PersonTableActivity extends AppCompatActivity {

    private static final String PERSON_LIST = "personList";

    private ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView personRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        populatePersonList(savedInstanceState);

        PersonRecyclerAdapter personListAdapter = new PersonRecyclerAdapter(this, personList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        personRecyclerView.setLayoutManager(layoutManager);
        personRecyclerView.setAdapter(personListAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putParcelableArrayList(PERSON_LIST, personList);

        super.onSaveInstanceState(savedInstanceState);
    }

    private void populatePersonList(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            personList = savedInstanceState.getParcelableArrayList(PERSON_LIST);
        } else {
            personList = BuilderJSON.getJSONPersonInfo(this);
        }
    }

}
