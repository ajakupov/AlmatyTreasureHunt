package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView backFromAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        /*
        Initializing needed widgets from the About Page layout, where Java names correspond
        exactly to XML ids of widgets
        */
        backFromAbout = (TextView) findViewById(R.id.backFromAbout);

        //adding a listener to backFromAbout which redirects user to the LevelSelect activity
        backFromAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, StartPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
