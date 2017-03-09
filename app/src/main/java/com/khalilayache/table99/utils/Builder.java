package com.khalilayache.table99.utils;

import android.content.Context;
import android.util.Log;

import com.khalilayache.table99.R;
import com.khalilayache.table99.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USUARIO
 * on 08/03/2017.
 */

public final class Builder {

    public static ArrayList<Person> getJSONInfo(Context context) {

        ArrayList<Person> personArrayList = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context));
            JSONArray jsonArray = obj.getJSONArray("persons");
            for(int i = 0; i < jsonArray.length(); i++){
                Person person =  new Person();
                JSONObject jsonItem = jsonArray.getJSONObject(i);

                String bio = null;
                String birthday = null;
                String id = null;
                String image = null;
                String name = null;

                //region check if has field
                if(jsonItem.has("bio")) {
                    bio = jsonItem.getString("bio");
                }

                if(jsonItem.has("birthday")){
                    birthday = jsonItem.getString("birthday");
                }

                if(jsonItem.has("id")){
                    id = jsonItem.getString("id");
                }

                if(jsonItem.has("image")){
                    image = jsonItem.getString("image");
                }

                if(jsonItem.has("name")){
                    name = jsonItem.getString("name");
                }
                //endregion

                //region insert info in Person
                if(bio != null){
                    person.setBio(bio);
                }else{
                    person.setBio(context.getString(R.string.error_not_available));
                }

                if(birthday != null){
                    person.setBirthday(birthday);
                }else{
                    person.setBirthday(context.getString(R.string.error_not_available));
                }

                if(id != null){
                    person.setId(id);
                }else{
                    person.setId(context.getString(R.string.error_no_id));
                }

                if(image != null){
                    person.setImage(image);
                }else{
                    person.setImage(context.getString(R.string.error_not_available));
                }

                if(name != null){
                    person.setName(name);
                }else {
                    person.setName(context.getString(R.string.error_not_available));
                }
                //endregion

                if((!checkIfPersonAlreadyExists(personArrayList, person)
                        || personArrayList.size() == 0)
                        && !person.getId().equals(context.getString(R.string.error_no_id)) )
                    personArrayList.add(person);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personArrayList;
    }

    private static String loadJSONFromAsset(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.person_info_list);
        Writer writer = new StringWriter();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String line = reader.readLine();
            while(line != null){
                writer.write(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return writer.toString();
    }

    private static boolean checkIfPersonAlreadyExists(ArrayList<Person> personArrayList, Person person){
        boolean alreadyExists = false;

        for(int i = 0; i < personArrayList.size();i++){
            Person p = personArrayList.get(i);
            if(p.getId().equals(person.getId())) {
                alreadyExists = true;
            }
        }
        return alreadyExists;
    }

}
