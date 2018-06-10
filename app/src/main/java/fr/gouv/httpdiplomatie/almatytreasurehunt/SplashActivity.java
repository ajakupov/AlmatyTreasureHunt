package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by eisti on 18/03/17.
 *
 * A simple Splash activity that shows an image while the application is loading
 */

public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The splash activity redirects to the StartPage activity
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
        finish();
    }
}
