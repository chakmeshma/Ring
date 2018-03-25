package com.chakmeshma.ring.data;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by amrosi on 3/24/2018.
 */

public class DataManager {
    private static String mainListRequestURL = "localhost/main_list_request.php";
    private static DataManager instance = null;
    public boolean networkAvailable = false;
    public boolean firstResponseUpdated = false;
    public JSONObject response;
    RequestQueue queue;

    public DataManager(Context context) {
        queue = Volley.newRequestQueue(context);

        Thread dataThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    JsonObjectRequest request = new JsonObjectRequest(JsonObjectRequest.Method.POST, mainListRequestURL, JsonRequest < >)
                }
            }
        });
    }

    public static void initInstance() {
        DataManager.instance = new DataManager();
    }

    public static DataManager getInstance() {
        return DataManager.instance;
    }
}
