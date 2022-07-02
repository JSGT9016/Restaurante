package com.example.reto1juanosorio.vista.locations;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;

import com.example.reto1juanosorio.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.reto1juanosorio.databinding.ActivityPalatinoBinding;

public class PalatinoActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    private ActivityPalatinoBinding binding;
    private FusedLocationProviderClient mLocationClient;
    private final LatLng sucursalUnicentro = new LatLng(4.7021472,-74.0422462);
    private final LatLng sucursalPortal80 = new LatLng(4.7096709,-74.1135828);
    private final LatLng sucursalPalatino = new LatLng(4.7156018,-74.0314751);
    private final LatLng sucursalSantaFe = new LatLng(4.7626029,-74.0484574);
    private final LatLng sucursalTitanPlaza = new LatLng(4.694708,-74.0883767);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(Html.fromHtml("<font color='#FFFFFF'>Mapa Sucursales </font>"));
        ab.setSubtitle(Html.fromHtml("<font color='#FFFFFF'>La Comilona </font>"));
        ab.setIcon(R.mipmap.restaurant_icon);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ColorDrawable color = new ColorDrawable(Color.parseColor("#000000"));
        ab.setBackgroundDrawable(color);

        binding = ActivityPalatinoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initMap();

        mLocationClient = new FusedLocationProviderClient(this);

        getCurrentLocation();

    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation(){
        mLocationClient.getLastLocation().addOnCompleteListener(task ->{
            if(task.isSuccessful()){
                Location location = task.getResult();
                goToLocation(location.getLatitude(), location.getLongitude());
            }
        });
    }

    private void initMap(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void goToLocation(double latitude, double longitude) {

        LatLng latLng = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Donde estoy.").icon(bitMapFromVector(getApplicationContext(), R.drawable.ic_baseline_expand_circle_down_24)));

        mMap.addMarker(new MarkerOptions().position(sucursalUnicentro).title("Sucursal Unicentro").icon(bitMapFromVector(PalatinoActivity.this, R.drawable.ic_baseline_restaurant_24)));
        mMap.addMarker(new MarkerOptions().position(sucursalPortal80).title("Sucursal Portal 80").icon(bitMapFromVector(PalatinoActivity.this, R.drawable.ic_baseline_restaurant_24)));
        mMap.addMarker(new MarkerOptions().position(sucursalPalatino).title("Sucursal Palatino").icon(bitMapFromVector(PalatinoActivity.this, R.drawable.ic_baseline_restaurant_24)));
        mMap.addMarker(new MarkerOptions().position(sucursalSantaFe).title("Sucursal Santa Fe").icon(bitMapFromVector(PalatinoActivity.this, R.drawable.ic_baseline_restaurant_24)));
        mMap.addMarker(new MarkerOptions().position(sucursalTitanPlaza).title("Sucursal Titan Plaza").icon(bitMapFromVector(PalatinoActivity.this, R.drawable.ic_baseline_restaurant_24)));

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(sucursalPalatino, 50);
        mMap.moveCamera(cameraUpdate);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    private BitmapDescriptor bitMapFromVector(Context context, int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap =Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}