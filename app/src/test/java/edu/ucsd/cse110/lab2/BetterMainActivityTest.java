package edu.ucsd.cse110.lab2;


import static org.junit.Assert.assertEquals;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equal_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {

            View myView_1 = (View) activity.findViewById(R.id.btn_one);
            myView_1.performClick();
            View myView_2 = (View) activity.findViewById(R.id.btn_plus);
            myView_2.performClick();
            View myView_3 = (View) activity.findViewById(R.id.btn_one);
            myView_3.performClick();
            View myView_4 = (View) activity.findViewById(R.id.btn_equals);
            myView_4.performClick();

            assertEquals("2",((TextView)activity.findViewById(R.id.display)).getText());

        });
    }
}
