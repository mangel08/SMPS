package com.example.miguelpc.smps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvStepDown;
    TextView tvStepUp;
    ImageView imgA;
    ImageView imgB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgA = (ImageView)findViewById(R.id.imagen_a);
        imgB = (ImageView)findViewById(R.id.imagen_b);
        tvStepDown = (TextView)findViewById(R.id.tvStep_down);
        tvStepUp = (TextView)findViewById(R.id.tvStep_up);

        //FUNCIONES CLICKLISTERNER STEP DOWN
        //REDIRECCIÓN AL ACTIVITY StepUpActivity
        imgA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StepDownActivity.class);
                startActivity(intent);

            }
        });

        tvStepDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StepDownActivity.class);
                startActivity(intent);

            }
        });

        //FUNCIONES CLICKLISTER STEP UP
        //REDIRECCIÓN AL ACTIVITY StepUpActivity
        imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StepUpActivity.class);
                startActivity(intent);

            }
        });

        tvStepUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StepUpActivity.class);
                startActivity(intent);

            }
        });

    }
}
