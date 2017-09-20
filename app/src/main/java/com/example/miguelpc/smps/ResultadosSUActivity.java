package com.example.miguelpc.smps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultadosSUActivity extends AppCompatActivity {

    private static final String TAG = ResultadosSUActivity.class.getSimpleName();
    public TextView tvRA ,tvRB ,tvR1 ,tvR2 ,tvR3 ,tvR4 ,tvR5 ,tvR6 ,tvR7 ,tvR8 ,tvR9 ,tvR10 ,tvR11 ,tvRL ,tvC1 ,tvC2 ,tvC3 ,tvC4 ,tvC5 ,tvL1, tvD1, tvD2;
    public String RA ,RB ,R1 ,R2 ,R3 ,R4 ,R5 ,R6 ,R7 ,R8 ,R9 ,R10 ,R11 ,RL ,C1 ,C2 ,C3 ,C4 ,C5 ,L1, D1, D2;
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_su);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TextViews
        tvRA = (TextView) findViewById(R.id.tvRA);
        tvRB = (TextView) findViewById(R.id.tvRB);
        tvR1 = (TextView) findViewById(R.id.tvR1);
        tvR2 = (TextView) findViewById(R.id.tvR2);
        tvR3 = (TextView) findViewById(R.id.tvR3);
        tvR4 = (TextView) findViewById(R.id.tvR4);
        tvR5 = (TextView) findViewById(R.id.tvR5);
        tvR6 = (TextView) findViewById(R.id.tvR6);
        tvR7 = (TextView) findViewById(R.id.tvR7);
        tvR8 = (TextView) findViewById(R.id.tvR8);
        tvR9 = (TextView) findViewById(R.id.tvR9);
        tvR10 = (TextView) findViewById(R.id.tvR10);
        tvR11 = (TextView) findViewById(R.id.tvR11);
        tvRL = (TextView) findViewById(R.id.tvRL);
        tvC1 = (TextView) findViewById(R.id.tvC1);
        tvC2 = (TextView) findViewById(R.id.tvC2);
        tvC3 = (TextView) findViewById(R.id.tvC3);
        tvC4 = (TextView) findViewById(R.id.tvC4);
        tvC5 = (TextView) findViewById(R.id.tvC5);
        tvL1 = (TextView) findViewById(R.id.tvL1);
        tvD1 = (TextView) findViewById(R.id.tvD1);
        tvD2 = (TextView) findViewById(R.id.tvD2);

        //Intents Values
        RA = getIntent().getStringExtra("RA");
        RB = getIntent().getStringExtra("RB");
        R1 = getIntent().getStringExtra("R1");
        R2 = getIntent().getStringExtra("R2");
        R3 = getIntent().getStringExtra("R3");
        R4 = getIntent().getStringExtra("R4");
        R5 = getIntent().getStringExtra("R5");
        R6 = getIntent().getStringExtra("R6");
        R7 = getIntent().getStringExtra("R7");
        R8 = getIntent().getStringExtra("R8");
        R9 = getIntent().getStringExtra("R9");
        R10 = getIntent().getStringExtra("R10");
        R11 = getIntent().getStringExtra("R11");
        RL = getIntent().getStringExtra("RL");
        C1 = getIntent().getStringExtra("C1");
        C2 = getIntent().getStringExtra("C2");
        C3 = getIntent().getStringExtra("C3");
        C4 = getIntent().getStringExtra("C4");
        C5 = getIntent().getStringExtra("C5");
        L1 = getIntent().getStringExtra("L1");
        D1 = getIntent().getStringExtra("D1");
        D2 = getIntent().getStringExtra("D2");

        Log.e(TAG, "RA: " + String.valueOf(RA));
        Log.e(TAG, "RB: " + String.valueOf(RB));
        Log.e(TAG, "R1: " + String.valueOf(R1));
        Log.e(TAG, "R2: " + String.valueOf(R2));
        Log.e(TAG, "R3: " + String.valueOf(R3));
        Log.e(TAG, "R4: " + String.valueOf(R4));
        Log.e(TAG, "R5: " + String.valueOf(R5));
        Log.e(TAG, "R6: " + String.valueOf(R6));
        Log.e(TAG, "R7: " + String.valueOf(R7));
        Log.e(TAG, "R8: " + String.valueOf(R8));
        Log.e(TAG, "R9: " + String.valueOf(R9));
        Log.e(TAG, "R10: " + String.valueOf(R10));
        Log.e(TAG, "R11: " + String.valueOf(R11));
        Log.e(TAG, "RL: " + String.valueOf(RL));
        Log.e(TAG, "C1: " + String.valueOf(C1));
        Log.e(TAG, "C2: " + String.valueOf(C2));
        Log.e(TAG, "C3: " + String.valueOf(C3));
        Log.e(TAG, "C4: " + String.valueOf(C4));
        Log.e(TAG, "C5: " + String.valueOf(C5));
        Log.e(TAG, "L1: " + String.valueOf(L1));
        Log.e(TAG, "D1: " + String.valueOf(D1));
        Log.e(TAG, "D2: " + String.valueOf(D2));


        tvRA.setText("RA: " +  String.valueOf(RA));
        tvRB.setText("RB: " +  String.valueOf(RB));
        tvR1.setText("R1: " +  String.valueOf(R1));
        tvR2.setText("R2: " +  String.valueOf(R2));
        tvR3.setText("R3: " +  String.valueOf(R3));
        tvR4.setText("R4: " +  String.valueOf(R4));
        tvR5.setText("R5: " +  String.valueOf(R5));
        tvR6.setText("R6: " +  String.valueOf(R6));
        tvR7.setText("R7: " +  String.valueOf(R7));
        tvR8.setText("R8: " +  String.valueOf(R8));
        tvR9.setText("R9: " +  String.valueOf(R9));
        tvR10.setText("R10: " +  String.valueOf(R10));
        tvR11.setText("R11: " +  String.valueOf(R11));
        tvRL.setText("RL: " +  String.valueOf(RL));
        tvC1.setText("C1: " +  String.valueOf(C1));
        tvC2.setText("C2: " +  String.valueOf(C2));
        tvC3.setText("C3: " +  String.valueOf(C3));
        tvC4.setText("C4: " +  String.valueOf(C4));
        tvC5.setText("C5: " +  String.valueOf(C5));
        tvL1.setText("L1: " +  String.valueOf(L1));
        tvD1.setText("D1: " +  String.valueOf(D1));
        tvD2.setText("D2: " +  String.valueOf(D2));

        //Float Button
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
