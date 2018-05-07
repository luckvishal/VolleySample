package com.example.ebsadmin.volleysample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button retrofitParsingButton;
    public String requestBody;
    private ArrayList<News> LatestNewsArray;
    private LatestNewsPojo LatestDetail;
//instantiate adapter variable
     //private LatestNewsAdapter latestNewsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitParsingButton = findViewById(R.id.retrofit_parsing);

//Intialize adapter and pass array and context of this activity
        //latestNewsAdapter = new LatestNewsAdapter(LatestNewsArray,LatestNewsActivity.this);
        //latestNewsListView.setAdapter(latestNewsAdapter);

        retrofitParsingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyJsonParsing();
            }
        });
    }

    private void volleyJsonParsing() {

        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setMessage("Loading...");
        dialog.show();
        requestBody = "data=" + makeLatestNewsJsonRequest();
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST, AppConstants.API_Base_URL + AppConstants.GET_LATEST_NEWS_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                dialog.dismiss();
                try {
                    if(response.getString("Status").equals("1")){
//Use gson libtrary to parse json data
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        LatestDetail = gson.fromJson(String.valueOf(response), LatestNewsPojo.class);
                        if (!LatestDetail.getNews().isEmpty()){
//Here we get array list from json parsing add it into array list and notify the adapter
                            LatestNewsArray.addAll(LatestDetail.getNews()) ;
                            //latestNewsAdapter.notifyDataSetChanged();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"You have reached the end",Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("Tag", String.valueOf(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                NetworkResponse networkResponse = error.networkResponse;
                String errorMessage = "Unknown error";
                if (networkResponse == null) {
                    if (error.getClass().equals(TimeoutError.class)) {
                        errorMessage = "Request timeout";
                    } else if (error.getClass().equals(NoConnectionError.class)) {
                        errorMessage = "Failed to connect server";
                    }
                } else {
                    String result = new String(networkResponse.data);
                    try {
                        JSONObject response = new JSONObject(result);
                        String status = response.getString("status");
                        String message = response.getString("message");

                        Log.e("Error Status", status);
                        Log.e("Error Message", message);

                        if (networkResponse.statusCode == 404) {
                            errorMessage = "Resource not found";
                        } else if (networkResponse.statusCode == 401) {
                            errorMessage = message+" Please login again";
                        } else if (networkResponse.statusCode == 400) {
                            errorMessage = message+ " Check your inputs";
                        } else if (networkResponse.statusCode == 500) {
                            errorMessage = message+" Something is getting wrong";
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //Log.i("Error", errorMessage);
                Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }){
//here we set the parsing method
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
            @Override
            public byte[] getBody() {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }
        };

//Set time out for volley api calling
        jor.setRetryPolicy(new

                DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jor);

    }
//Method to create json object and send it to api to get the json data
    private JSONObject makeLatestNewsJsonRequest() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("ACCESS_TOKEN", "ajhgd7834934908_839973");
            jsonObject.put("KEY_PAGE_NUMBER", 10);
            jsonObject.put("KEY_NUMBER_OF_RECORDS_PER_PAGE", 1);
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
