package com.example.user.clorikapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by User on 16-01-2017.
 */
public class SingleTon {

    private static SingleTon singleTon;
    private RequestQueue requestQueue;
    private static Context context;
    private ImageLoader imageLoader;

    public SingleTon(Context context){
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){

        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public static synchronized SingleTon getInstance(Context context){
        if (singleTon == null){
            singleTon = new SingleTon(context);
        }

        return singleTon;
    }

    public void addToRequestQueue(Request request)
    {
        requestQueue.add(request);
    }
}
