package com.example.user.clorikapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 13-07-2016.
 */
public class FragmentB extends Fragment implements View.OnClickListener {

    private ImageView imageView;
    private TextView textView;
    private Button buttonDefaultImage, buttonRandomImage;
    private String default_image_url = "https://cdn.pixabay.com/photo/2015/04/22/12/02/butterfly-734654_960_720.jpg";
    private String random_image_url = "http://lorempixel.com/640/480/";

    private NetworkConnection networkConnection;
    private boolean isInternetConnected = false;
    private RelativeLayout relativeLayout_2;
    private CoordinatorLayout rootLayout;

    RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        textView = (TextView) getActivity().findViewById(R.id.textView_user);
        buttonDefaultImage = (Button) getActivity().findViewById(R.id.button_show_default_image);
        buttonRandomImage = (Button) getActivity().findViewById(R.id.button_show_random_image);
        relativeLayout_2 = (RelativeLayout) getActivity().findViewById(R.id.relative_layout_2);
        rootLayout = (CoordinatorLayout) getActivity().findViewById(R.id.coordinatorLayout);

        buttonDefaultImage.setOnClickListener(this);
        buttonRandomImage.setOnClickListener(this);

        networkConnection = new NetworkConnection(getActivity());
    }

    @Override
    public void onClick(View v) {

        isInternetConnected = networkConnection.checkNetworkConnection();
        if (isInternetConnected) {

            switch (v.getId()) {
                case R.id.button_show_default_image:
                    imageRequest(default_image_url);
                    break;

                case R.id.button_show_random_image:
                    imageRequest(random_image_url);
                    break;
            }
        } else
            //Toast.makeText(getActivity().getApplicationContext(), "Please Check Network Connection", Toast.LENGTH_LONG).show();
            Snackbar.make(rootLayout, "Please Check Network Connection", Snackbar.LENGTH_LONG).show();
    }

    private void imageRequest(final String image_url) {

        ImageRequest defaultImageRequest = new ImageRequest(image_url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        relativeLayout_2.setVisibility(View.VISIBLE);
                        imageView.setImageBitmap(response);
                        textView.setText("Load Image From : \n" + image_url );
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.ARGB_8888,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        imageView.setBackgroundColor(Color.parseColor("#ff0000"));
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                });
        SingleTon.getInstance(getActivity().getApplicationContext()).addToRequestQueue(defaultImageRequest);
    }
}
