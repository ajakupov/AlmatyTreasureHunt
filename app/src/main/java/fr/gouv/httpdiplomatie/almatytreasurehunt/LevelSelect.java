package fr.gouv.httpdiplomatie.almatytreasurehunt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import model.Difficulty;
import model.Level;

public class LevelSelect extends AppCompatActivity {
    //ArrayList of the type model.Level containing all the levels
    //should be public to obtain level from other views
    public ArrayList<Level> levels;
    //Array Adapter to initialize View List
    private ArrayAdapter<String> arrayAdapter;
    private ListView levelListView;
    private TextView backFromLevelSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        //Initializing all the widgets from  the LevelSelect layout, where Java names correspond
        // exactly to XML ids of widgets
        levelListView = (ListView) findViewById(R.id.levelListView);
        backFromLevelSelect = (TextView) findViewById(R.id.backFromLevelSelect);

        //Redirecting back to main StartPage
        backFromLevelSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelSelect.this, StartPage.class);
                startActivity(intent);
                finish();
            }
        });

        // Initializing levels list
        levels = new ArrayList<Level>();
        //populating levels list
        //First Level
        levels.add(new Level("A Mysterious Tower", Difficulty.Easy, false, "It is an international " +
                "organization that aims to promote French language and culture around the world. " +
                "Created in Paris on 21 July 1883. Its primary concern is teaching French as a " +
                "second language and is headquartered in Paris.In 2014, this organisation has 850" +
                " centers in 137 countries, on five continents.\nYour goal is to find its center " +
                "in Almaty\nGood Luck!"));
        //Randomly initializing all the other levels
        for (int i = 2; i < 8; i++) {
            levels.add(new Level("Level "+i, Difficulty.Hard,
                    true, "Please unlock this level before going further"));
        }

        ArrayList<String> temp = new ArrayList<String>();

        for (Level level: levels) {
            temp.add(level.getLevelName());
        }

        arrayAdapter = new ArrayAdapter<String>(LevelSelect.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, temp);
        levelListView.setAdapter(arrayAdapter);

        levelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Creating alert dialog that activate on each item click and redirects to the
                // MainMap
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LevelSelect.this);


                builder1.setMessage("Diificulty : " +levels.get(position).
                        getDifficulty().toString()+"\n"
                        + levels.get(position).getDescription());
                builder1.setCancelable(true);

                if (!levels.get(position).isLocked()) {
                    builder1.setPositiveButton(
                            "Play",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    //Redirect the user to the game map
                                    Intent intent = new Intent(LevelSelect.this,
                                            MapNavigationActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                }

                builder1.setNegativeButton(
                        "Back",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }
}
