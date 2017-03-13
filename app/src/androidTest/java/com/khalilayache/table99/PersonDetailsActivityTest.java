package com.khalilayache.table99;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.khalilayache.table99.views.PersonDetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class PersonDetailsActivityTest {

    @Rule
    public ActivityTestRule<PersonDetailsActivity>
            activityRule =  new ActivityTestRule<>(PersonDetailsActivity.class,false,true);


    @Test
    public void whenActivityIsLaunched_shouldDisplayInitialState(){
        onView(withId(R.id.imageView)).check(matches(isDisplayed()));
        onView(withId(R.id.nameView)).check(matches(isDisplayed()));
        onView(withId(R.id.birthdayView)).check(matches(isDisplayed()));
        onView(withId(R.id.bioView)).check(matches(isDisplayed()));
    }
}
