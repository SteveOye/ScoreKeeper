package com.example.android.americafootballscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText home;
    EditText away;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = findViewById(R.id.homeTeam);
        away= findViewById(R.id.awayTeam);
        button = findViewById(R.id.start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the inputted text and saves it in the string variable homeTeam and awayTeam
                String homeTeam = home.getText().toString();
                String awayTeam = away.getText().toString();
                //validate the form to ensure the User Input the details before proceeding
                if(homeTeam.length()==0){
                    home.setError("Please Enter the Home team");
                }else if( awayTeam.length() == 0){
                    away.setError("Please Enter the Away team");
                }else {
                    Intent returnIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    returnIntent.putExtra("home", homeTeam);
                    returnIntent.putExtra("away", awayTeam);
                    startActivity(returnIntent);
                }
            }
        });
    }
}
