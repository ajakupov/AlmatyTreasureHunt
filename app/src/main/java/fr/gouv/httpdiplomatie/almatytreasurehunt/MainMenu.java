package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    //all the widgets from the MainMenu activity
    private Button playButton;
    private Button helpButton;
    private Button settingsButton;
    private Button scoreButton;
    private Button cityGuideButton;
    private TextView backToStartPageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Initializing all the widgets from Start Page layout, where Java names correspond exactly
        //to XML ids of widgets
        playButton = (Button)findViewById(R.id.playButton);
        helpButton = (Button)findViewById(R.id.helpButton);;
        settingsButton = (Button)findViewById(R.id.settingsButton);
        scoreButton = (Button)findViewById(R.id.scoreButton);
        cityGuideButton = (Button)findViewById(R.id.cityGuideButton);
        backToStartPageTextView = (TextView) findViewById(R.id.backToStartPageTextView);

        //adding a listener to playButton which redirects user to the LevelSelect activity
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, LevelSelect.class);
                startActivity(intent);
                finish();
            }
        });

        //adding a listener to backToStartPageTextView which redirects user to the LevelSelect activity
        backToStartPageTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, StartPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
