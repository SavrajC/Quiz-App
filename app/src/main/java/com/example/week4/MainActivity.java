package com.example.week4;

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

    private SharedPreferences sharedPreferences;
//     int correctScoreSports;
//    int incorrectScoreSports;
//     int correctScoreMusic;
//     int incorrectScoreMusic;
//   int correctScoreGames;
//    int incorrectScoreGames;
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

        // Get the shared preferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int correctScoreSports = sharedPreferences.getInt(CORRECT_SCORE_SPORTS, 0);
        int incorrectScoreSports = sharedPreferences.getInt(INCORRECT_SCORE_SPORTS, 0);

        // Get the values for the sports quiz
//        correctScoreSports = sharedPreferences.getInt("correctScoreSports", 0);
//        incorrectScoreSports = sharedPreferences.getInt("incorrectScoreSports", 0);
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

        System.out.println(totalCorrect);
        System.out.println(totalIncorrect);

//        Log.d("MainActivity", "Correct score for sports quiz: " + correctScoreSports);
//        Log.d("MainActivity", "Incorrect score for sports quiz: " + incorrectScoreSports);
//
//        Log.d("MainActivity", "Correct score for music quiz: " + correctScoreMusic);
//        Log.d("MainActivity", "Incorrect score for music quiz: " + incorrectScoreMusic);
//
//        Log.d("MainActivity", "Correct score for games quiz: " + correctScoreGames);
//        Log.d("MainActivity", "Incorrect score for games quiz: " + incorrectScoreGames);
//
//        Log.d("MainActivity", "Sports quiz scores updated. Correct: " + correctScoreSports + ", Incorrect: " + incorrectScoreSports);
//
//        Log.d("MainActivity", "Music quiz scores updated. Correct: " + correctScoreMusic + ", Incorrect: " + incorrectScoreMusic);
//
//        Log.d("MainActivity", "Games quiz scores updated. Correct: " + correctScoreGames + ", Incorrect: " + incorrectScoreGames);


    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // Get the shared preferences
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//
//        // Get the values for the sports quiz
//        int correctScoreSports = sharedPreferences.getInt("correctScoreSports", 0);
//        int incorrectScoreSports = sharedPreferences.getInt("incorrectScoreSports", 0);
//
//        // Update the TextViews for the sports quiz
//        correctScoreSportsTextView.setText("Correct: " + correctScoreSports);
//        incorrectScoreSportsTextView.setText("Incorrect: " + incorrectScoreSports);
//
//        // Get the values for the music quiz
//        int correctScoreMusic = sharedPreferences.getInt("correctScoreMusic", 0);
//        int incorrectScoreMusic = sharedPreferences.getInt("incorrectScoreMusic", 0);
//
//        // Update the TextViews for the music quiz
//        correctScoreMusicTextView.setText("Correct: " + correctScoreMusic);
//        incorrectScoreMusicTextView.setText("Incorrect: " + incorrectScoreMusic);
//
//        // Get the values for the games quiz
//        correctScoreGames = sharedPreferences.getInt("correctScoreGames", 0);
//        incorrectScoreGames = sharedPreferences.getInt("incorrectScoreGames", 0);
//
//        // Update the TextViews for the games quiz
//        correctScoreGamesTextView.setText("Correct: " + correctScoreGames);
//        incorrectScoreGamesTextView.setText("Incorrect: " + incorrectScoreGames);
//    }
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




//public class MainActivity extends AppCompatActivity {
//
//    private static final String API_URL = "https://api.api-ninjas.com/v1/trivia?category=music";
//    private static final String TAG = MainActivity.class.getSimpleName();
//    private String apiKey = "sOQBi/wKyTym5k0D+5eFvw==ZwlFpMixDKV2ojnD";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        new RetrieveTriviaQuestionTask().execute(API_URL);
//    }
//
//    private class RetrieveTriviaQuestionTask extends AsyncTask<String, Void, List<TriviaQuestion>> {
//
//        @Override
//        protected List<TriviaQuestion> doInBackground(String... urls) {
//            try {
//                URL url = new URL(urls[0]);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestProperty("accept", "application/json");
//                connection.setRequestProperty("X-Api-Key", apiKey); // Add this line to set the API key in the request header
//                InputStream responseStream = connection.getInputStream();
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode root = mapper.readTree(responseStream);
//                List<TriviaQuestion> triviaQuestions = mapper.readValue(root.traverse(),
//                        mapper.getTypeFactory().constructCollectionType(List.class, TriviaQuestion.class));
//                return triviaQuestions;
//            } catch (IOException e) {
//                Log.e(TAG, "Error retrieving trivia question: " + e.getMessage());
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(List<TriviaQuestion> triviaQuestions) {
//            if (triviaQuestions != null && !triviaQuestions.isEmpty()) {
//                TriviaQuestion question = triviaQuestions.get(0);
//                Log.d(TAG, "Trivia question: " + question.getQuestion());
//            }
//        }
//    }
//}
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.ContextMenu;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.PopupMenu;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //registerForContextMenu(findViewById(R.id.txtHelloWorld));
//        registerForContextMenu(findViewById(R.id.txtGoodBye));
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_file, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        //Handle item selection
//        switch (item.getItemId()) {
//            case R.id.itAbout:
//                //perform any action;
//                Intent intent = new Intent(MainActivity.this, KPU.class);
//                startActivity(intent);
//                return true;
//            case R.id.itContact:
//                //perform any action;
//                intent = new Intent(MainActivity.this, UBC.class);
//                startActivity(intent);
//                return true;
//            case R.id.itHome:
//                //perform any action;
//                intent = new Intent(MainActivity.this, SFU.class);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    @Override
//    public void onCreateContextMenu(ContextMenu contextMenu, View view,
//                                    ContextMenu.ContextMenuInfo contextMenuInfo) {
//        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_file, contextMenu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        //Handle item selection
//        switch (item.getItemId()) {
//            case R.id.itAbout:
//                //perform any action;
//                Toast.makeText(this, "Cicked About Menu", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.itContact:
//                //perform any action;
//                Toast.makeText(this, "Cicked Contact Menu", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.itHome:
//                //perform any action;
//                Toast.makeText(this, "Cicked Home Menu", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    public void pop(View v) {
//        PopupMenu popup = new PopupMenu(this,v);
//        popup.setOnMenuItemClickListener(this);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_file,popup.getMenu());
//        popup.show();
//    }
//
//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        //Handle item selection
//        switch (item.getItemId()) {
//            case R.id.itAbout:
//                //perform any action;
//                Toast.makeText(this, "Cicked About Menu", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.itContact:
//                //perform any action;
//                Toast.makeText(this, "Cicked Contact Menu", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.itHome:
//                //perform any action;
//                Toast.makeText(this, "Cicked Home Menu", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
  // }
//}