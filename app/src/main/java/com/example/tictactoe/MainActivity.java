package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Game game;
    TextView statusText;
    ArrayList<Button> board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

        statusText = findViewById(R.id.textStatus);

        board = new ArrayList<>();
        board.add(findViewById(R.id.tile0));
        board.add(findViewById(R.id.tile1));
        board.add(findViewById(R.id.tile2));
        board.add(findViewById(R.id.tile3));
        board.add(findViewById(R.id.tile4));
        board.add(findViewById(R.id.tile5));
        board.add(findViewById(R.id.tile6));
        board.add(findViewById(R.id.tile7));
        board.add(findViewById(R.id.tile8));
    }

    public void toggleTile(View v) {
        Character player = game.player;
        Button button = (Button) v;
        button.setText(game.player.toString());
        int position = Integer.parseInt(v.getContentDescription().toString());
        game.registerTurn(position);
        v.setEnabled(false);
        Character result = game.getWinner();
        if (result == null)
            statusText.setText("It's X's turn.".replace("X", game.player.toString()));
        else if (result.equals('t'))
            statusText.setText("The match is a tie.");
        else {
            statusText.setText(player.toString().concat(" wins!"));
            for (Button b : board)
                b.setEnabled(false);
        }
   }

    public void reset(View v) {
        game = new Game();
        for (Button b : board) {
            b.setText("");
            b.setEnabled(true);
        }
        statusText.setText("x starts.");
    }
}