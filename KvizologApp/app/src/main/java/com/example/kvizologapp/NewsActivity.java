package com.example.kvizologapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewsActivity extends AppCompatActivity {
    private final int NUMBER_OF_ARTICLES = 10;
    private final String API_ACCESS_KEY = "?access_key=c0655750efff8ed6b53254f575f0549d";
    private final String BASE_URL = "http://api.mediastack.com/v1/news";
    //Attributes
    private final String LANGUAGE = "&sources=en";
    private final String NUM_OF_ARTICLES_ATTR = "&limit=";
    private final String SORT_TYPE = "&sort=popularity";

    //Intent getExtra(name of city)...
    private String KEYWORD = "moscow";
    private String KEYWORD_ATTR = "&keywords=";

    StringBuilder urlBuilder = new StringBuilder();
    TextView txvNews;
    RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //Make an URL
        urlBuilder.append(BASE_URL);urlBuilder.append(API_ACCESS_KEY);urlBuilder.append(KEYWORD_ATTR);urlBuilder.append(KEYWORD);
        urlBuilder.append(LANGUAGE);urlBuilder.append(NUM_OF_ARTICLES_ATTR);urlBuilder.append(NUMBER_OF_ARTICLES);
        urlBuilder.append(SORT_TYPE);



        txvNews = findViewById(R.id.txvNews);
        queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                urlBuilder.toString(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray articlesArray = response.getJSONArray("data");
                    for(int i=0;i<5;i++){
                        JSONObject articleObject = articlesArray.getJSONObject(i);
                        txvNews.append("Title: " + articleObject.getString("title")+"\n");
                        txvNews.append("Description: " + articleObject.getString("description")+"\n\n");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
                Toast.makeText(NewsActivity.this, "ERROR OCCURED!!!", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(jsonObjectRequest);

    }


    //c0655750efff8ed6b53254f575f0549d  API KEY NEWS API

}