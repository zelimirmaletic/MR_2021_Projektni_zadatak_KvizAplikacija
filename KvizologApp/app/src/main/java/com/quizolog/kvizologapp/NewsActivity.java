package com.quizolog.kvizologapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quizolog.kvizologapp.news_recyclerview.Adapter;
import com.quizolog.kvizologapp.news_recyclerview.ItemArticle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

    private StringBuilder urlBuilder = new StringBuilder();
    private RequestQueue queue;
    private JSONArray articlesArray;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ItemArticle> array = new ArrayList<ItemArticle>();
    ProgressDialog progressDialog;
    private TextView tvTitle;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        tvTitle = findViewById(R.id.txvNewsTitle);
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
                if(isConnected()){
                    Intent intent = new Intent(NewsActivity.this, WebViewActivity.class);
                    intent.putExtra("url",item.getUrl());
                    startActivity(intent);
                }else{
                    Toast.makeText(NewsActivity.this, "There is no internet connection, please make sure to be connected to the Internet to se full article.", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Get the name of the city we want news for
        KEYWORD = getIntent().getStringExtra("city_name");

        if(isConnected()){
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
                        articlesArray = response.getJSONArray("data");
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
                    //If caching is enabled save JSON to a file for later use!
                    if("On".equals(readPreference("key_caching"))){
                        AsyncCacheNews cacher = new AsyncCacheNews();
                        cacher.execute();
                    }
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
        //Check if there is cached version
        else if(readFromFile(getBaseContext(),KEYWORD + ".json") != null){
            try {
                //Update title
                tvTitle.setText("Cached " + tvTitle.getText());
                //Read JSON from the local storage
                articlesArray = new JSONArray(readFromFile(getBaseContext(),KEYWORD + ".json"));
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
                // connect RecyclerView with adapter
                recyclerView.setAdapter(mAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this, "There is no connection to the internet nor the data was cached in the local storage!", Toast.LENGTH_LONG).show();
        }

    }

    //Cache news locally using AsyncTask
    private class AsyncCacheNews extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String current ="";
            //Save JSON data in the local storage
            writeToFile(articlesArray.toString(), getBaseContext());
            return current;
        }
    }

    private void writeToFile(String data,Context context) {
        try {
            //Check if there is a JSON file contence
            if(!data.isEmpty()) {
                String fileName = KEYWORD + ".json";
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
                outputStreamWriter.write(data);
                outputStreamWriter.close();
                //Log.e("Success", "File written! ");
            }
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context, String fileName) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            //Log.e("login activity", "File not found: " + e.toString());
            return null;
        } catch (IOException e) {
            //Log.e("login activity", "Can not read file: " + e.toString());
            return null;
        }
        //Log.e("JSON",ret);
        return ret;
    }

    public String readPreference(String key){
        SharedPreferences shPreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        String value = shPreferences.getString(key, "");
        return value;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }
}