package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {
    //all the widgets from the StartPage activity
    private Button startButton;
    private Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //Initializing all the widgets from Start Page layout, where Java names correspond exactly
        //to XML ids of widgets
        startButton = (Button)findViewById(R.id.startButton);
        aboutButton = (Button) findViewById(R.id.aboutButton);

        //adding a listener to startButton which redirects user to the MainMenu activity
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, MainMenu.class);
                startActivity(intent);
                finish();
            }
        });

        //adding a listener to aboutButton which redirects user to the About activity
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, About.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
