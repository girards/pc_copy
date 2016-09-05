package com.petitchef.petitchef.API;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.petitchef.petitchef.ApplicationExt;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by girard_s on 11/05/2016 for PetitChef
 */
public class APIManager {
    private static APIManager instance = null;
    private String baseUrl = "http://powerci.org:8080/eip/api/";
    private RequestQueue requestQueue;
    private static Context context;

    private APIManager(Context context) {
        APIManager.context = context;
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
    }

    public static APIManager getInstance() {
        if (instance == null)
            instance = new APIManager(ApplicationExt.getContext());
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
    }

    //Utility

    private APIResponse createAPIResponse(JSONObject response)
    {
        return new APIResponse(response);
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
