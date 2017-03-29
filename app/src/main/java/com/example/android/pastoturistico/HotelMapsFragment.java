package com.example.android.pastoturistico;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelMapsFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap mMap;

    public HotelMapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_hotel_maps,container,false);

        mapView=(MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // HOTEL DEL PARQUE
        LatLng Hparque = new LatLng(1.204114, -77.268911);
        mMap.addMarker(new MarkerOptions().position(Hparque).title("Hotel del Parque").icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel)).
        snippet("Telefono: 7204585"));
        // HOTEL TORRES DEL BOSQUE
        LatLng Hbosque = new LatLng(1.229110, -77.288626);
        mMap.addMarker(new MarkerOptions().position(Hbosque).title("Hotel del Parque").icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel)).
                snippet("Celular: 3136850763"));

        //HOTEL FERNANDO PLAZA
        LatLng Hplaza = new LatLng(1.212928,-77.275929);
        mMap.addMarker(new MarkerOptions().position(Hplaza).title("Hotel Fernando plaza").icon(BitmapDescriptorFactory.fromResource(R.drawable.hotel)).
                snippet("Telefono: 7291432"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hplaza,14));

    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }

}
