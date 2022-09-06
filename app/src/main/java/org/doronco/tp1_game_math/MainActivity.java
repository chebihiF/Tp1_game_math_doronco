package org.doronco.tp1_game_math;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nbr1, nbr2, score ;
    private Button res1, res2, res3 ;
    private int val1, val2 ;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("testtest","start onStop method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // init views
        score = findViewById(R.id.score);
        nbr1 = findViewById(R.id.nbr1);
        nbr2 = findViewById(R.id.nbr2);
        res1 = findViewById(R.id.res1);
        res2 = findViewById(R.id.res2);
        res3 = findViewById(R.id.res3);

        // add onclick event to buttons
        res1.setOnClickListener(this);
        res2.setOnClickListener(this);
        res3.setOnClickListener(this);

        initGame();
    }

    public void initGame()
    {
        val1 = 1 + random.nextInt(100);
        val2 = 1 + random.nextInt(100);
        int r = random.nextInt(3);
        nbr1.setText(val1+"");
        nbr2.setText(val2+"");
        if(r==0){
            res1.setText((val1+val2)+"");
            res2.setText(String.valueOf(1 + random.nextInt(200)));
            res3.setText(String.valueOf(1 + random.nextInt(200)));
        }else if(r==1){
            res2.setText((val1+val2)+"");
            res1.setText(String.valueOf(1 + random.nextInt(200)));
            res3.setText(String.valueOf(1 + random.nextInt(200)));
        }else
        {
            res3.setText((val1+val2)+"");
            res1.setText(String.valueOf(1 + random.nextInt(200)));
            res2.setText(String.valueOf(1 + random.nextInt(200)));
        }
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v ;
        int score_value = Integer.parseInt(score.getText().toString());
        if(Integer.parseInt(button.getText().toString()) == val1+val2)
            score.setText(String.valueOf(score_value = score_value +1));
        else
            score.setText(String.valueOf(score_value = score_value -1));
        if(score_value > 0)
            score.setTextColor(Color.rgb(0,255,0));
        else if(score_value < 0)
            score.setTextColor(Color.rgb(255,0,0));
        initGame();
    }
}