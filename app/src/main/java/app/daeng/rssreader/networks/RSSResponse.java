package app.daeng.rssreader.networks;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

import app.daeng.rssreader.interfaces.NetworkListener;

/**
 * Created by isfaaghyth on 18/2/17.
 */

public class RSSResponse {
    Context context;
    NetworkListener networkListener;
    HashMap<String, String> param;

    public RSSResponse(Context context, NetworkListener networkListener) {
        this.context = context;
        this.networkListener = networkListener;
    }

    public void RSSResponse(int method, String URL) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        RSSRequest stringRequest = new RSSRequest(param,
                method, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                networkListener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                networkListener.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public void exampleParam(String value) {
        param = new HashMap<>();
        param.put("key", value);
    }
}
