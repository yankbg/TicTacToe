package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Gamedisplay extends AppCompatActivity {

    private int playerTurn = 1;
    boolean iswinner = true;
    int [] [] gameboard;
    Button Play_again;
    Button homebtn;
    TextView textView;
    String [] PlayerName;
    int player1Moves;
    int player2Moves;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamedisplay);
        gameboard = new int[3][3];
        setGameboard();
        Play_again = findViewById(R.id.button4);
        homebtn = findViewById(R.id.button3);

        Play_again.setVisibility(View.GONE);
        homebtn.setVisibility(View.GONE);
        PlayerName = getIntent().getStringArrayExtra("PLAYER_NAMES");
        textView = findViewById(R.id.textView6);
        if (PlayerName != null && PlayerName.length >= 2) {
            textView.setText(PlayerName[0] + "'s turn");
        }

    }
    public void Homescreen(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void playAgain(View v){
        Intent i = new Intent(this, Gamedisplay.class);
        startActivity(i);
        playerTurn = 1;
        player1Moves = player2Moves = 0;
        iswinner = true;
        textView.setText(PlayerName[0] + "'s turn");
    }
    public void setGameboard(){
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                gameboard [r] [c] = 0;
            }
        }
    }
    public int [][] getGameboard(){
     return gameboard;
    }
    public boolean Winnercheck(){
        for (int r = 0; r < 3; r++){
            if (gameboard[r][0] == gameboard[r][1] && gameboard[r][0] == gameboard[r][2] &&
                    gameboard[r][0] != 0){
                iswinner = false;
                Play_again.setVisibility(View.VISIBLE);
                homebtn.setVisibility(View.VISIBLE);
                int PLayerName = (playerTurn == 1)? 1: 0;
                textView.setText(PlayerName[PLayerName] + " Won!!!");
                return iswinner;

            }
        }
        for (int c = 0; c < 3; c++){
            if (gameboard[0][c] == gameboard[1][c] && gameboard[0][c] == gameboard[2][c] &&
                    gameboard[0][c] != 0){
                iswinner = false;
                Play_again.setVisibility(View.VISIBLE);
                homebtn.setVisibility(View.VISIBLE);
                int PLayerName = (playerTurn == 1)? 1: 0;
                textView.setText(PlayerName[PLayerName] + " Won!!!");
                return iswinner;

            }
        }
        if (gameboard[0][0] == gameboard[1][1] && gameboard[0][0] == gameboard[2][2] &&
                gameboard[0][0] != 0){
            iswinner = false;
            Play_again.setVisibility(View.VISIBLE);
            homebtn.setVisibility(View.VISIBLE);
            int PLayerName = (playerTurn == 1)? 1: 0;
            textView.setText(PlayerName[PLayerName] + " Won!!!");
            return iswinner;

        }
        if (gameboard[2][0] == gameboard[1][1] && gameboard[2][0] == gameboard[0][2] &&
                gameboard[0][2] != 0){
            iswinner = false;
            Play_again.setVisibility(View.VISIBLE);
            homebtn.setVisibility(View.VISIBLE);
            int PLayerName = (playerTurn == 1)? 1: 0;
            textView.setText(PlayerName[PLayerName] + " Won!!!");
            return iswinner;
        }
        else{
            iswinner = true;
            Play_again.setVisibility(View.GONE);
            homebtn.setVisibility(View.GONE);
            return iswinner;
        }
    }

    public void playgame(View v){
        ImageView imageView = (ImageView) v;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setCropToPadding(true);

        String contentDesc = imageView.getContentDescription().toString();
        String[] parts = contentDesc.split(",");
        int row = Integer.parseInt(parts[0])-1;
        int col = Integer.parseInt(parts[1])-1;


        if (gameboard[row][col] == 0 && iswinner) {
            gameboard[row][col] = playerTurn;


            if(playerTurn == 1){

                imageView.setImageResource(R.drawable.ximg);
                playerTurn = 2;
                player1Moves ++;
                textView.setText(PlayerName[1] + "'s turn");

            }
            else{
                imageView.setImageResource(R.drawable.oimg);
                playerTurn = 1;
                player2Moves ++;
                textView.setText(PlayerName[0] + "'s turn");
            }
            if(!Winnercheck()){
                return;
            }
            int emptyCells = 9 - (player1Moves + player2Moves);
            if (emptyCells == 0) {
                Play_again.setVisibility(View.VISIBLE);
                homebtn.setVisibility(View.VISIBLE);

                textView.setText("Game is a draw ");
            }


        }


    }

}

