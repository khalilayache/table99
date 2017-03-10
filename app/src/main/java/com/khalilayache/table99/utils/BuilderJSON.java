package com.khalilayache.table99.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khalilayache.table99.R;
import com.khalilayache.table99.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class BuilderJSON {

    public static ArrayList<Person> getJSONPersonInfo(Context context) {

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Person>>() {
        }.getType();
        ArrayList<Person> personArrayList = gson.fromJson(loadJSONFromAsset(context), type);

        return removeDuplicatePerson(personArrayList);
    }

    private static ArrayList<Person> removeDuplicatePerson(ArrayList<Person> personArrayList) {

        ArrayList<Person> personTempArrayList = new ArrayList<>();
        for (Person person : personArrayList) {
            boolean isDuplicated = false;
            for (Person tempPerson : personTempArrayList) {
                if (tempPerson.getName().equals(person.getName())) {
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) {
                personTempArrayList.add(person);
            }
        }

        return personTempArrayList;
    }

    private static String loadJSONFromAsset(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.person_info_list);
        Writer writer = new StringWriter();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return writer.toString();
    }

}
