package com.dimedrol.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SplashScreenActivity extends AppCompatActivity {

    JSONArray a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        String url = "https://raw.githubusercontent.com/wesleywerner/ancienttech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json";
        String url_img = "https://raw.githubusercontent.com/wesleywerner/ancienttech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("");
                    for (int i = 1; i < jsonArray.length(); i++) { //i = 1?
                        JSONObject tech = jsonArray.getJSONObject(i);
                        String graphic = tech.getString("graphic");
                        String name = tech.getString("name");
                        //String helptext = tech.getString("helptext");
                    }
                    a = jsonArray;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RecyclerView r = findViewById(R.id.recycler);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
