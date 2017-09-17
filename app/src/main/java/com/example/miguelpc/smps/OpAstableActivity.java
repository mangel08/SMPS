package com.example.miguelpc.smps;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class OpAstableActivity extends AppCompatActivity {


    public static double trans = 1000000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op_astable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public double RA(double rb, double ct){

        double result = rb/((1-ct))-2*rb;

        return result;
    }

    public double Frecuencia(double ra, double rb, double c3){

        c3 = c3/trans;

        double result = 1.44/((ra+(2*rb))*c3);

        return result;
    }


}
