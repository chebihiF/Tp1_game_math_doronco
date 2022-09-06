package org.doronco.tp1_game_math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView nbr1, nbr2, score ;
    private Button res1, res2, res3 ;
    private int val1, val2 ;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = 1 + random.nextInt(100);
        val2 = 1 + random.nextInt(100);
    }

    @Override
    protected void onStart() {
        super.onStart();
        nbr1 = findViewById(R.id.nbr1);
        nbr2 = findViewById(R.id.nbr2);
        nbr1.setText(val1);
        nbr2.setText(val2);
    }
}