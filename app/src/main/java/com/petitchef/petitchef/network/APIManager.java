package com.petitchef.petitchef.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.petitchef.petitchef.App;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by girard_s on 11/05/2016 for PetitChef
 */
public class APIManager {
    private static APIManager instance = null;
    private String baseUrl = "http://api.petitchef.me/";
    private RequestQueue requestQueue;
    private static Context context;

    private APIManager(Context context) {
        APIManager.context = context;
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
    }

    public static APIManager getInstance() {
        if (instance == null)
            instance = new APIManager(App.getContext());
        return instance;
    }

    public void login(String username, String password, final APIListener<Boolean> handler) {
        String finalRequest = baseUrl + "user/login/" + username + "/" + password;

        mJsonObjectRequest jsObjRequest = new mJsonObjectRequest(Request.Method.GET, finalRequest, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                handler.onResult(true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handler.onResult(false);
            }
        });
        requestQueue.add(jsObjRequest);
    }

    //Utility

    private APIResponse createAPIResponse(JSONObject response)
    {
        return new APIResponse(response);
    }

    public void register(String username, String password, String mail, final APIListener<Boolean> handler) {
        String finalRequest = baseUrl + "user/register";

        Map<String,String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        params.put("email", mail);

        mJsonObjectRequest jsObjRequest = new mJsonObjectRequest(Request.Method.POST, finalRequest, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                handler.onResult(true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handler.onResult(false);
            }
        });
        requestQueue.add(jsObjRequest);
    }

    private class APIResponse {
        public String status;
        public JSONObject data;
        public String errorMessage;

        APIResponse(JSONObject json) {
            //
        }
    }
}
