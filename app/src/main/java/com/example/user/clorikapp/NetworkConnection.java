package com.example.user.clorikapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by User on 23-01-2017.
 */
public class NetworkConnection {

    private Context context;
    private boolean isNetworkConnected = false;

    NetworkConnection(Context context) {
        this.context = context;
    }

    public boolean checkNetworkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null){
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            isNetworkConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }

        return isNetworkConnected;
    }

}
