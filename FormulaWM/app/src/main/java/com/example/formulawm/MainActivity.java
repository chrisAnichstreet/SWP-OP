package com.example.formulawm;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue myRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("ON CREATE!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myRequestQueue = Volley.newRequestQueue(this);




        //ListView item_listview = findViewById(R.layout.list_view_item);


        FloatingActionButton fab = findViewById(R.id.refresh);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aktualisiere ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                fetchdata(view);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fetchdata(View view)
    {
        StringRequest request = new StringRequest("https://ergast.com/api/f1/current/driverStandings.json", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject json = new JSONObject(response);
                    prozess_data(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("Im Error");
                System.out.println(error.getMessage());
            }
        });

        myRequestQueue.add(request);


    }

    private void prozess_data(JSONObject json) throws JSONException {
        JSONObject jSeason = json.getJSONObject("MRData").getJSONObject("StandingsTable");
        int season = jSeason.getInt("season");
        System.out.println("Seasons: "+season);
        JSONArray driversstanding = json.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists").getJSONObject(0).getJSONArray("DriverStandings");

        ArrayAdapter<List> adapter = new ArrayAdapter<List>(this, R.layout.list_view_item, R.id.textView, new ArrayList<List>());
        ListView driver_lv =  findViewById(R.id.driver_lv);
        driver_lv.setAdapter(adapter);
        System.out.println("------------------------------------Prozess Daata-----------------------------");

        for(int i =0; i< driversstanding.length(); i++)
        {

            List<String> listdata = new ArrayList<>();
            listdata.add(driversstanding.getJSONObject(i).get("position").toString());
            listdata.add(driversstanding.getJSONObject(i).getJSONObject("Driver").get("givenName").toString());
            listdata.add(driversstanding.getJSONObject(i).getJSONObject("Driver").get("familyName").toString());
            listdata.add(driversstanding.getJSONObject(i).getJSONArray("Constructors").getJSONObject(0).get("constructorId").toString());
            adapter.addAll(listdata);
        }

    }
}
