package com.example.kvizologapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.kvizologapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker marker;
    private String CITY_NAME ="";
    private String IMG="";
    private double LAT=0.0;
    private double LNG=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get data from extra
        CITY_NAME = getIntent().getStringExtra("city_name");
        IMG = getIntent().getStringExtra("img");
        LAT = getIntent().getDoubleExtra("lat",0.0);
        LNG = getIntent().getDoubleExtra("lng",0.0);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng position = new LatLng(LAT, LNG);
        //marker.setPosition(sydney);
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
        mMap.addMarker(new MarkerOptions().position(position).title(CITY_NAME));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
    }

    private class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        private View view;
        public CustomInfoWindowAdapter() {
            view = getLayoutInflater().inflate(R.layout.maps_info_card,null);
        }
        @Override
        public View getInfoContents(Marker marker) {
            if (MapsActivity.this.marker != null
                    && MapsActivity.this.marker.isInfoWindowShown()) {
                MapsActivity.this.marker.hideInfoWindow();
                MapsActivity.this.marker.showInfoWindow();
            }
            return null;
        }

        @Override
        public View getInfoWindow(final Marker marker) {
            MapsActivity.this.marker = marker;
            TextView name = (TextView) view.findViewById(R.id.tv_title);
            ImageView image = (ImageView) view.findViewById(R.id.iv_image);
            /* LOAD IMAGES FROM THE INTERNET
            Picasso.with(MapsActivity.this)
                    .load(IMG_URL)
                    .error(R.mipmap.ic_launcher) // will be displayed if the image cannot be loaded
                    .into(image);
             */

            //Set image
            image.setImageResource(getResources().getIdentifier(IMG,"drawable",MapsActivity.this.getPackageName()));
            //Set card title AKA City name
            name.setText(CITY_NAME);
            //getInfoContents(marker);
            return view;
        }
    }

}