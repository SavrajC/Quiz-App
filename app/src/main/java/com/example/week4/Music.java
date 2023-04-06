package com.example.week4;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Music extends AppCompatActivity {
    private String apiKey = "sOQBi/wKyTym5k0D+5eFvw==ZwlFpMixDKV2ojnD";
    private static final String API_URL = "https://api.api-ninjas.com/v1/trivia?category=music&limit=10";
    private static final String TAG = Music.class.getSimpleName();
    private List<TriviaQuestion> triviaQuestions;
    private TextView questionTextView;
    private EditText answerEditText;
    private Button checkAnswerButton;
    private TextView correctnessTextView;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        questionTextView = findViewById(R.id.question_text_view);
        answerEditText = findViewById(R.id.answer_edit_text);
        checkAnswerButton = findViewById(R.id.check_answer_button);
        correctnessTextView = findViewById(R.id.correctness_text_view);

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        new RetrieveTriviaQuestionsTask().execute(API_URL);
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
            case R.id.itGame:
                //perform any action;
                Intent intent = new Intent(Music.this, Games.class);
                startActivity(intent);
                return true;
            case R.id.itMain:
                //perform any action;
                intent = new Intent(Music.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.itSports:
                //perform any action;
                intent = new Intent(Music.this, Sports.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayTriviaQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex >= triviaQuestions.size()) {
            currentQuestionIndex = 0;
        }
        TriviaQuestion triviaQuestion = triviaQuestions.get(currentQuestionIndex);
        questionTextView.setText(triviaQuestion.getQuestion());
        answerEditText.setText("");
    }




    private void checkAnswer() {
        String answer = answerEditText.getText().toString();
        TriviaQuestion triviaQuestion = triviaQuestions.get(currentQuestionIndex);

        if (answer.equalsIgnoreCase(triviaQuestion.getAnswer())) {
            correctnessTextView.setText("Correct!");
        } else {
            correctnessTextView.setText("Incorrect. The correct answer was: " + triviaQuestion.getAnswer());
        }

        // Call displayTriviaQuestion() again to show the next question
        displayTriviaQuestion();
    }



    private class RetrieveTriviaQuestionsTask extends AsyncTask<String, Void, List<TriviaQuestion>> {

        @Override
        protected List<TriviaQuestion> doInBackground(String... urls) {
            List<TriviaQuestion> triviaQuestions = new ArrayList<>();

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("accept", "application/json");
                connection.setRequestProperty("X-Api-Key", apiKey);
                InputStream responseStream = connection.getInputStream();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(responseStream);

                for (JsonNode questionNode : root) {
                    TriviaQuestion triviaQuestion = new TriviaQuestion();
                    triviaQuestion.setCategory(questionNode.path("category").asText());
                    triviaQuestion.setQuestion(questionNode.path("question").asText());
                    triviaQuestion.setAnswer(questionNode.path("answer").asText());
                    triviaQuestions.add(triviaQuestion);
                }

            } catch (IOException e) {
                Log.e(TAG, "Error retrieving trivia questions", e);
            }

            return triviaQuestions;
        }

        @Override
        protected void onPostExecute(List<TriviaQuestion> result) {
            triviaQuestions = result;
            checkAnswerButton.setEnabled(true);
            displayTriviaQuestion();
        }
    }
}