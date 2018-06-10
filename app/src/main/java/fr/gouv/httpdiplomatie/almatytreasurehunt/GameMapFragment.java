package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.app.Fragment;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.math.*;

/**
 * Created by eisti on 20/03/17.
 *
 * The main map is represented as a fragment of a navigation drawer activity
 */

public class GameMapFragment extends Fragment implements OnMapReadyCallback {
    private View gameMap;
    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // obtain the main map fragment from an inflatter object
        gameMap = inflater.inflate(R.layout.game_map, container, false);

        return gameMap;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment mapFragment = (MapFragment) getChildFragmentManager()
                .findFragmentById(R.id.treasure_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng allianceFrancaise = new LatLng(43.238200, 76.91361);

        mMap = googleMap;

        double distance = 0.0;



        mMap.getUiSettings().setCompassEnabled(false);
        // Add a marker in Almaty Alliance Francaise
        LatLng userPostion = new LatLng(((MapNavigationActivity) getActivity()).getUserLatitude(),
                ((MapNavigationActivity) getActivity()).getUserLongitude());

        //Calculating distance betwenn userLocation and allianceFrancaise
        Location userLocation = new Location("");
        userLocation.setLatitude(userPostion.latitude);
        userLocation.setLongitude(userPostion.longitude);

        Location destinationLocation = new Location("");
        destinationLocation.setLatitude(allianceFrancaise.latitude);
        destinationLocation.setLongitude(allianceFrancaise.longitude);

        distance = userLocation.distanceTo(destinationLocation);

        ((MapNavigationActivity) getActivity()).setUserDistance(distance);

        MarkerOptions marker = new MarkerOptions().position(userPostion).
                title("You are here " + distance + " m to your destination");
        mMap.addMarker(marker);

        //Setting Map type to normal
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Setting camera position and zoom
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(userPostion)
                .zoom(18)
                .tilt(67.5f)
                .bearing(314)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        if ((userPostion.equals(allianceFrancaise))) {

        }
    }
}
