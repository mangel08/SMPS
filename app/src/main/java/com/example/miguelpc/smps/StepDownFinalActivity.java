package com.example.miguelpc.smps;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StepDownFinalActivity extends AppCompatActivity {

    public TextView tvL1, tvC5, tvD2, tvRL, tvQ1;
    public EditText etVin, etVout, etRL;
    public Button btnCalcular;
    public double R6, SMPS, R10, R4, R5, R7, R8, R9, R1, R2, ra, rb, C1, C2, C3, C4, CT, f;
    public String Elemento, Elemento2, Elemento3, D1, v;
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_down_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Button
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        //FloatButton
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //Intents values
        v = getIntent().getStringExtra("view");
        R1 = Double.parseDouble(getIntent().getStringExtra("R1"));
        R2 = Double.parseDouble(getIntent().getStringExtra("R2"));
        ra = Double.parseDouble(getIntent().getStringExtra("RA"));
        rb = Double.parseDouble(getIntent().getStringExtra("RB"));
        Elemento = getIntent().getStringExtra("Elemento");
        Elemento2 = getIntent().getStringExtra("Elemento2");
        Elemento3 = getIntent().getStringExtra("Elemento3");
        C1 = Double.parseDouble(getIntent().getStringExtra("C1"));
        C2 = Double.parseDouble(getIntent().getStringExtra("C2"));
        C3 = Double.parseDouble(getIntent().getStringExtra("C3"));
        C4 = Double.parseDouble(getIntent().getStringExtra("C4"));
        CT = Double.parseDouble(getIntent().getStringExtra("CT"));
        f = Double.parseDouble(getIntent().getStringExtra("F"));
        R5 = Double.parseDouble(getIntent().getStringExtra("R5"));
        R9 = Double.parseDouble(getIntent().getStringExtra("R9"));
        R7 = Double.parseDouble(getIntent().getStringExtra("R7"));
        R8 = Double.parseDouble(getIntent().getStringExtra("R8"));
        R4 = Double.parseDouble(getIntent().getStringExtra("R4"));
        R6 = Double.parseDouble(getIntent().getStringExtra("R6"));
        R10 = Double.parseDouble(getIntent().getStringExtra("R10"));
        D1 = getIntent().getStringExtra("D1");
        SMPS = Double.parseDouble(getIntent().getStringExtra("SMPS"));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
