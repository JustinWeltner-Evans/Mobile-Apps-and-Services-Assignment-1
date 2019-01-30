package com.codepath.examples.basicsnakegame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;

public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        EditText editText = findViewById(R.id.username);
        editText.addTextChangedListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                HighScoreList.currUsername = c.toString();
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
            }

        });

        //HighScoreList.currUsername = editText.getText().toString();
        configureButtons();
    }

    /**
     * Allows the player to restart the game after getting game over and view
     * high score list.
     */
    private void configureButtons() {
        Button playAgain = (Button) findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOverActivity.this, SnakeGameActivity.class));
            }
        });

        Button viewScores = (Button) findViewById(R.id.scoreList);
        viewScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOverActivity.this, HighScoreListActivity.class));
            }
        });

    }
}
