package com.example.week4;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
//        menuSpinner = findViewById(R.id.menu_spinner);
//        goButton = findViewById(R.id.go_button);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Games", "Music", "Sports"});
//        menuSpinner.setAdapter(adapter);
//        goButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String selectedActivity = (String) menuSpinner.getSelectedItem();
//                Intent intent;
//                switch (selectedActivity) {
//                    case "Games":
//                        intent = new Intent(MainActivity.this, Games.class);
//                        startActivity(intent);
//                        break;
//                    case "Music":
//                        intent = new Intent(MainActivity.this, Music.class);
//                        startActivity(intent);
//                        break;
//                    case "Sports":
//                        intent = new Intent(MainActivity.this, Sports.class);
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });
//    }


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