package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class imageActivity extends AppCompatActivity {
    private boolean isLion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);

        ImageView animal = (ImageView) findViewById(R.id.animal);
        Button changeImageBtn = (Button) findViewById(R.id.changeImageBtn);
        changeImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLion) {
                    animal.setImageResource(R.drawable.giraffe);
                } else {
                    animal.setImageResource(R.drawable.lion);
                }
                isLion = !isLion;
            }
        });
    }
}