package com.example.mockitoexampleproject.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mockitoexampleproject.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Result result = JUnitCore.runClasses(MathApplicationTester.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());*/

    }
}