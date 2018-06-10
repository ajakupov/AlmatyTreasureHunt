package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Activity that represents the main game window
 * The main screen is a map
 * The navigation drawer is the pop menu with all the game options
 */
public class MapNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static double userLongitude = 76.950849;
    public static double userLatitude = 43.243083;
    public static double userDistance;

    public void setUserDistance(double distance) {
        userDistance = distance;
    }

    public static double getUserDistance() {
        return userDistance;
    }

    public double getUserLongitude () {
        return userLongitude;
    }

    public double getUserLatitude () {
        return userLatitude;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {
            boolean enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if (!enabled) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            } else  {
                try {
                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    userLongitude = location.getLongitude();
                    Toast.makeText(getApplicationContext(), ""+location.getLongitude(),
                            Toast.LENGTH_LONG).show();
                    userLatitude = location.getLatitude();
                } catch (SecurityException se) {
                    Toast.makeText(getApplicationContext(), "The application needs your position" +
                                    "to work properly",
                            Toast.LENGTH_LONG).show();
                }
            }


        } else {
            Toast.makeText(getApplicationContext(), "The application needs your position" +
                            "to work properly",
                    Toast.LENGTH_LONG).show();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapNavigationActivity.this,
                        LevelSelect.class);
                startActivity(intent);
                finish();
            }
        });

        //Fragment manager to navigate between different fragments declared in the draer activity
        FragmentManager fragmentManager = getFragmentManager();

        //The main map will be shown by default
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, new GameMapFragment()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Fragment manager to navigate between different fragments declared in the draer activity
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_game_map) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new GameMapFragment()).commit();
        } else if (id == R.id.nav_tips_tricks) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new TipTrickFragment()).commit();
        } else if (id == R.id.nav_progress) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ProgressFragment()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
