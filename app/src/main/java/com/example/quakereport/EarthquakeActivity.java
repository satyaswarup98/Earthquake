package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
    ListView earthquakeListView;
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2020-01-01&endtime=2020-01-05&minmagnitude=2.9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
           earthquakeListView = (ListView) findViewById(R.id.list);

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute();
        }

    private void updateUi(ArrayList<Earthquake> earthquake) {
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquake);
        earthquakeListView.setAdapter(adapter);
    }

    private class EarthquakeAsyncTask extends AsyncTask<URL, Void, ArrayList<Earthquake>> {

        @Override
        protected ArrayList<Earthquake> doInBackground(URL... urls) {
            return QueryUtils.fetchEarthquakeData(USGS_REQUEST_URL);
        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> earthquake) {
            if (earthquake == null) {
                return;
            }
            updateUi(earthquake);
        }

    }


}