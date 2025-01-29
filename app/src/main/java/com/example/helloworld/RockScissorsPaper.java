package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RockScissorsPaper extends AppCompatActivity {
    private final int GU = 0;
    private final int CHOKI = 1;
    private final int PA = 2;
    private int janken[] = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rock_scissors_paper);

        ImageButton guButton = (ImageButton) findViewById(R.id.gu);
        guButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janken[GU] = janken[GU] + 1;
                push_count();
            }
        });

        ImageButton chokiButton = (ImageButton) findViewById(R.id.choki);
        chokiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janken[CHOKI] = janken[CHOKI] + 1;
                push_count();
            }
        });

        ImageButton paButton = (ImageButton) findViewById(R.id.pa);
        paButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janken[PA] = janken[PA] + 1;
                push_count();
            }
        });
    }

    private void push_count() {
        TextView textView = (TextView) findViewById(R.id.janken);
        textView.setText(janken[GU] + "," + janken[CHOKI] + "," + janken[PA]);

        TextView gokei = (TextView) findViewById(R.id.gokei);
        gokei.setText("合計は" + total_push_count(janken) + "です");
    }
    
    private int total_push_count(int[] janken) {
        int sum = 0;
        for (int num:
             janken) {
            sum = sum + num;
        }
        return sum;
    }
}