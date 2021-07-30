package com.example.kvizologapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kvizologapp.news_recyclerview.Adapter;
import com.example.kvizologapp.news_recyclerview.ItemArticle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private final int NUMBER_OF_ARTICLES = 20;
    private final String API_ACCESS_KEY = "?access_key=c0655750efff8ed6b53254f575f0549d";
    private final String BASE_URL = "http://api.mediastack.com/v1/news";
    //Attributes
    private final String LANGUAGE = "&sources=en";
    private final String NUM_OF_ARTICLES_ATTR = "&limit=";
    //Sort by latest date
    private final String SORT_TYPE = "&sort=published_desc";

    private String KEYWORD;
    private String KEYWORD_ATTR = "&keywords=";

    StringBuilder urlBuilder = new StringBuilder();
    RequestQueue queue;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ItemArticle> array = new ArrayList<ItemArticle>();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        // take a reference to RecyclerView
        recyclerView = findViewById(R.id.rv_recyclerView);
        // optimization
        recyclerView.setHasFixedSize(true);
        // set layout type LayoutManager-a
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // send Adapter items from the list
        mAdapter = new Adapter(array, new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemArticle item) {
                Intent intent = new Intent(NewsActivity.this, WebViewActivity.class);
                intent.putExtra("url",item.getUrl());
                startActivity(intent);
            }
        });

        //Get the name of the city we want news for
        KEYWORD = getIntent().getStringExtra("city_name");
        //Make an URL
        urlBuilder.append(BASE_URL);urlBuilder.append(API_ACCESS_KEY);urlBuilder.append(KEYWORD_ATTR);urlBuilder.append(KEYWORD);
        urlBuilder.append(LANGUAGE);urlBuilder.append(NUM_OF_ARTICLES_ATTR);urlBuilder.append(NUMBER_OF_ARTICLES);
        urlBuilder.append(SORT_TYPE);

        queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                urlBuilder.toString(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray articlesArray = response.getJSONArray("data");
                    //Check if there are articles loaded!
                    if(articlesArray.length()==0)
                        Toast.makeText(NewsActivity.this, R.string.empty_news_message, Toast.LENGTH_LONG).show();
                    else{
                        for(int i=0;i<articlesArray.length();i++){
                            JSONObject articleObject = articlesArray.getJSONObject(i);
                            ItemArticle listItem = new ItemArticle();
                            listItem.setTitle(articleObject.getString("title"));
                            listItem.setDescription(articleObject.getString("description"));
                            listItem.setDate(articleObject.getString("published_at"));
                            listItem.setImage_url(articleObject.getString("image"));
                            listItem.setUrl(articleObject.getString("url"));
                            array.add(listItem);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // connect RecyclerView with adapter
                recyclerView.setAdapter(mAdapter);
                //Dismiss progress dialog when data is loaded!
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsActivity.this, R.string.on_restapi_error_response, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
        //initialize the progress dialog and show it
        progressDialog = new ProgressDialog(NewsActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.progress_bar_title));
        progressDialog.show();
    }

}