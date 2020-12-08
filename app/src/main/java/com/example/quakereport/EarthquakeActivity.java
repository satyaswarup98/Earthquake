package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

            ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

            ListView earthquakeListView = (ListView) findViewById(R.id.list);
            EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);
            earthquakeListView.setAdapter(adapter);
        }

}