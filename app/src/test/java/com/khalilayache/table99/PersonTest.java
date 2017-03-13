package com.khalilayache.table99;

import com.khalilayache.table99.models.Person;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PersonTest {

    private Person person = new Person();

    @Test
    public void dateConvertDateTest(){

        person.setBirthday("1990-03-29T00:00:00Z");
        assertEquals("29/03/1990",person.getBirthday());

    }

    @Test
    public void dateConvertEmptyDateTest(){

        person.setBirthday("");
        assertEquals(null,person.getBirthday());
    }

    @Test
    public void dateConvertNullDateTest(){

        person.setBirthday(null);
        assertEquals(null,person.getBirthday());
    }
}
