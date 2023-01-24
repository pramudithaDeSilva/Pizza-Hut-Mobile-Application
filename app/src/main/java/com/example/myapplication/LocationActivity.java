package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap gMap;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();

    ZoomControls zoomControls;

    LatLng galle = new LatLng(6.035128,  80.210529);
    LatLng matara = new LatLng(	5.948218, 80.535180);
    LatLng ambalangoda = new LatLng(6.239889,  80.053756);
    LatLng karapitiya = new LatLng(6.065726,  80.224237);
    LatLng hikkaduwa = new LatLng(6.135564,  80.100059);
    LatLng mount_lavinia = new LatLng(6.856526,  79.865301);
    LatLng bambalapitiya = new LatLng(6.893541,  79.854763);
    LatLng nuwara_eliya = new LatLng(6.960703,  80.767993);
    LatLng kandy = new LatLng(7.293556,  80.638551);
    LatLng bandarawela = new LatLng(6.830027,  80.996887);



    ArrayList<String> title = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapCen);
        Objects.requireNonNull(supportMapFragment).getMapAsync(this);


        arrayList.add(galle);
        arrayList.add(matara);
        arrayList.add(ambalangoda);
        arrayList.add(karapitiya);
        arrayList.add(hikkaduwa);
        arrayList.add(mount_lavinia);
        arrayList.add(bambalapitiya);
        arrayList.add(nuwara_eliya);
        arrayList.add(kandy);
        arrayList.add(bandarawela);



        title.add("Pizza Hut - Galle");
        title.add("Pizza Hut - Matara");
        title.add("Pizza Hut - Ambalangoda");
        title.add("Pizza Hut - Karapitiya");
        title.add("Pizza Hut - Hikkaduwa");
        title.add("Pizza Hut - Mount Lavinia");
        title.add("Pizza Hut - Bambalapitiya");
        title.add("Pizza Hut - Nuwara Eliya");
        title.add("Pizza Hut - Kandy");
        title.add("Pizza Hut - Bandarawela");


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        gMap = googleMap;

        for (int i = 0; i < arrayList.size(); i++) {

            for (int j = 0; j < title.size(); j++) {

                gMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(j))));

            }

            gMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }

        gMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String title = marker.getTitle();

                Intent intentMarker = new Intent(LocationActivity.this, MapDetails.class);
                intentMarker.putExtra("title", title);
                startActivity(intentMarker);


                return false;
            }
        });

    }
}