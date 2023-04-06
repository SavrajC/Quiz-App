package com.example.week4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private TextView correctScoreSportsTextView;
    private TextView incorrectScoreSportsTextView;
    private TextView correctScoreMusicTextView;
    private TextView incorrectScoreMusicTextView;
    private TextView correctScoreGamesTextView;
    private TextView incorrectScoreGamesTextView;
    private TextView txtTotalCorrect;
    private TextView txtTotalIncorrect;
    private TextView txtMessage;


    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "TriviaScores";
    private static final String CORRECT_SCORE_MUSIC = "correctScoreMusic";
    private static final String INCORRECT_SCORE_MUSIC = "incorrectScoreMusic";
    private static final String CORRECT_SCORE_SPORTS = "correctScoreSports";
    private static final String INCORRECT_SCORE_SPORTS = "incorrectScoreSports";
    private static final String CORRECT_SCORE_GAMES = "correctScoreGames";
    private static final String INCORRECT_SCORE_GAMES = "incorrectScoreGames";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correctScoreSportsTextView = findViewById(R.id.correct_score_sports);
        incorrectScoreSportsTextView = findViewById(R.id.incorrect_score_sports);
        correctScoreMusicTextView = findViewById(R.id.correct_score_music);
        incorrectScoreMusicTextView = findViewById(R.id.incorrect_score_music);
        correctScoreGamesTextView = findViewById(R.id.correct_score_games);
        incorrectScoreGamesTextView = findViewById(R.id.incorrect_score_games);
        txtTotalCorrect = findViewById(R.id.txtTotalCorrect);
        txtTotalIncorrect = findViewById(R.id.txtTotalIncorrect);
        txtMessage = findViewById(R.id.txtMessage);

        // Get the shared preferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int correctScoreSports = sharedPreferences.getInt(CORRECT_SCORE_SPORTS, 0);
        int incorrectScoreSports = sharedPreferences.getInt(INCORRECT_SCORE_SPORTS, 0);

        System.out.println(correctScoreSports);
        System.out.println(incorrectScoreSports);

        // Update the TextViews for the sports quiz
        correctScoreSportsTextView.setText("Correct: " + correctScoreSports);
        incorrectScoreSportsTextView.setText("Incorrect: " + incorrectScoreSports);

        // Get the values for the music quiz
        int correctScoreMusic = sharedPreferences.getInt("correctScoreMusic", 0);
        int incorrectScoreMusic = sharedPreferences.getInt("incorrectScoreMusic", 0);


        // Update the TextViews for the music quiz
        correctScoreMusicTextView.setText("Correct: " + correctScoreMusic);
        incorrectScoreMusicTextView.setText("Incorrect: " + incorrectScoreMusic);

        // Get the values for the games quiz
        int correctScoreGames = sharedPreferences.getInt("correctScoreGames", 0);
        int incorrectScoreGames = sharedPreferences.getInt("incorrectScoreGames", 0);

        // Update the TextViews for the games quiz
        correctScoreGamesTextView.setText("Correct: " + correctScoreGames);
        incorrectScoreGamesTextView.setText("Incorrect: " + incorrectScoreGames);

        int totalCorrect = correctScoreGames + correctScoreMusic + correctScoreSports;
        int totalIncorrect = incorrectScoreGames + incorrectScoreMusic + incorrectScoreSports;
        int total = totalCorrect + totalIncorrect;
        //double percentCorrect = (totalCorrect/total) * 100;
        int percentCorrect = (int) (((double) totalCorrect / (totalCorrect + totalIncorrect)) * 100);
        txtTotalCorrect.setText("Total Correct: " + totalCorrect);
        txtTotalIncorrect.setText("Total Incorrect: " + totalIncorrect);
        System.out.println("testing");
        System.out.println(percentCorrect);
        if(percentCorrect <= 15){
            txtMessage.setText("You Stink!");
        }else if(percentCorrect > 15 && percentCorrect <= 30){
            txtMessage.setText("Hit the books");
        }else if(percentCorrect > 30 && percentCorrect <= 50){
            txtMessage.setText("Your alright I guess...");
        }else if(percentCorrect > 50 && percentCorrect <= 75){
            txtMessage.setText("Maybe you are smarter than a 5th grader");
        }else if(percentCorrect > 75 && percentCorrect <= 90){
            txtMessage.setText("Get to who wants to be a Millionaire stat!");
        }else if(percentCorrect > 90 && percentCorrect <= 99){
            txtMessage.setText("We got a smarty pants over here");
        }else if(percentCorrect == 100){
            txtMessage.setText("Einstein is quaking in his boots");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.itMusic:
                //perform any action;
                Intent intent = new Intent(MainActivity.this, Music.class);
                startActivity(intent);
                return true;
            case R.id.itGame:
                //perform any action;
                intent = new Intent(MainActivity.this, Games.class);
                startActivity(intent);
                return true;
            case R.id.itSports:
                //perform any action;
                intent = new Intent(MainActivity.this, Sports.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
