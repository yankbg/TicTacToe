package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class User extends AppCompatActivity {
    private EditText PLayerName1;
    private EditText PLayerName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        PLayerName1 = findViewById(R.id.editTextTextPersonName);
        PLayerName2 = findViewById(R.id.editTextTextPersonName2);


    }
    public void btnstart(View v){
        String namePlayer1 = PLayerName1.getText().toString().trim();
        String namePlayer2 = PLayerName2.getText().toString().trim();
        TextView warning = findViewById(R.id.textView5);
        if (namePlayer1.isEmpty() && namePlayer2.isEmpty()) {
            warning.setText("Both names are required!");
        } else if (namePlayer1.isEmpty()) {
            warning.setText("Player 1 name is missing!");
        } else if (namePlayer2.isEmpty()) {
            warning.setText("Player 2 name is missing!");
        } else {

            Intent intent = new Intent(this, Gamedisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[]{namePlayer1, namePlayer2});
            startActivity(intent);
        }
        warning.setVisibility(View.VISIBLE);

    }
}