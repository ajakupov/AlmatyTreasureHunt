package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        mMap.getUiSettings().setCompassEnabled(false);
        // Add a marker in Almaty
        LatLng almaty = new LatLng(43.238949, 76.889709);
        MarkerOptions marker = new MarkerOptions().position(almaty).
                title("You are here");
        mMap.addMarker(marker);

        //Setting Map type to normal
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Setting camera position and zoom
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(almaty)
                .zoom(18)
                .tilt(67.5f)
                .bearing(314)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
