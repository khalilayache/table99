package com.khalilayache.table99.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.khalilayache.table99.utils.Builder;
import com.khalilayache.table99.R;
import com.khalilayache.table99.adapters.PersonListAdapter;
import com.khalilayache.table99.model.Person;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {

    private static final String PERSON_LIST = "personList";
    private static final String PERSON_EXTRA = "person";

    private ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView personListView = (ListView) findViewById(R.id.listView);

        if(savedInstanceState != null){
            personList = savedInstanceState.getParcelableArrayList(PERSON_LIST);
        }else {
            personList = Builder.getJSONInfo(getApplicationContext());
        }

        PersonListAdapter personListAdapter = new PersonListAdapter(getApplicationContext(), personList);

        personListView.setAdapter(personListAdapter);
        personListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person) parent.getItemAtPosition(position);

                Intent intent = new Intent(TableActivity.this, DetailsActivity.class);
                intent.putExtra(PERSON_EXTRA,person);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putParcelableArrayList(PERSON_LIST, personList);

        super.onSaveInstanceState(savedInstanceState);
    }
}
