package com.khalilayache.table99.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person implements Parcelable {

    private String birthday;
    private String image;
    private String name;
    private String bio;
    private String id;

    public Person() {
    }

    protected Person(Parcel in) {
        birthday = in.readString();
        image = in.readString();
        name = in.readString();
        bio = in.readString();
        id = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getBirthday() {
        return convertDateISOToString(this.birthday);
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String convertDateISOToString(String dateISO){
        String stringDate = null;
        try {
            SimpleDateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            Date date = isoDateFormat.parse(dateISO);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            stringDate = dateFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            stringDate = null;
        }

        return stringDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(birthday);
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(bio);
        dest.writeString(id);
    }
}
