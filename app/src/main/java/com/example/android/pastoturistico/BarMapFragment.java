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
public class BarMapFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public BarMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_bar_map,container,false);

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

        // CAPITAN NIRVANA
        LatLng Bnirvana = new LatLng(1.216717, -77.279001);
        mMap.addMarker(new MarkerOptions().position(Bnirvana).title("Capitan Nirvana").icon(BitmapDescriptorFactory.fromResource(R.drawable.beer)).
                snippet("Telefono: 7294120"));
        // COYOTE UGLLY
        LatLng Bugly = new LatLng(1.218880, -77.280691);
        mMap.addMarker(new MarkerOptions().position(Bugly).title("Coyote Ugly").icon(BitmapDescriptorFactory.fromResource(R.drawable.beer)).
                snippet("Celular: 3004068004"));

        //TERRAZA LA MERCED
        LatLng Bmerced = new LatLng(1.217550,-77.288828);
        mMap.addMarker(new MarkerOptions().position(Bmerced).title("Terraza Bar la Merced").icon(BitmapDescriptorFactory.fromResource(R.drawable.beer)).
                snippet("Celular: 3104229354 "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bmerced,14));

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
