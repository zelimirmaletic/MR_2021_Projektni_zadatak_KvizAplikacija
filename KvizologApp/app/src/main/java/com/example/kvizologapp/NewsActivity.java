package com.example.kvizologapp;

import android.os.Bundle;
import android.util.Log;
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
    private final int NUMBER_OF_ARTICLES = 10;
    private final String API_ACCESS_KEY = "?access_key=c0655750efff8ed6b53254f575f0549d";
    private final String BASE_URL = "http://api.mediastack.com/v1/news";
    //Attributes
    private final String LANGUAGE = "&sources=en";
    private final String NUM_OF_ARTICLES_ATTR = "&limit=";
    private final String SORT_TYPE = "&sort=popularity";

    private String KEYWORD;
    private String KEYWORD_ATTR = "&keywords=";

    StringBuilder urlBuilder = new StringBuilder();
    RequestQueue queue;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ItemArticle> array = new ArrayList<ItemArticle>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // uzmemo referencu na RecyclerView
        recyclerView = findViewById(R.id.rv_recyclerView);
        // optimizacija
        recyclerView.setHasFixedSize(true);
        // postavimo vrstu LayoutManager-a
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // proslijedimo Adapter-u podatke iz liste
        // mAdapter = new Adapter(array);
        mAdapter = new Adapter(array, new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemArticle item) {
                Toast.makeText(getApplicationContext(), "Kliknuli ste na: " + item.getTitle(), Toast.LENGTH_LONG).show();
            }
        });

        //Get the name of the city we want news for
        KEYWORD = getIntent().getStringExtra("keyword");
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(NewsActivity.this, "Finished getting items!", Toast.LENGTH_SHORT).show();
                // povezemo RecyclerView sa adapterom
                recyclerView.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", error.toString());
                Toast.makeText(NewsActivity.this, "GETTING NEWS ERROR OCCURED!!!", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);

    }
}