package com.example.miguelpc.smps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AmplificadorDifActivity extends AppCompatActivity {

    private static final String TAG = AmplificadorDifActivity.class.getSimpleName();
    public String Elemento3 = "LM741CN";
    public String D1 = "Zener 4,7 V";
    public double R7 = 2000;
    public double R8 = 10000;
    public double R4 = 1500;
    public double AMP = 10.9;
    public TextView tvD1, tvR4, tvR5, tvR6, tvR7, tvR8, tvR9, tvR10, tvElemento3;
    public Button btnCalcular;
    public EditText etSMPS, etR6, etR10;
    public double R6, SMPS, R10, R5, R9, R1, R2, ra, rb, C1, C2, C3, C4, CT, f;
    public String Elemento, Elemento2;

    public FloatingActionButton fab;
    public String v = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amplificador_dif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //EditText
        etSMPS = (EditText)findViewById(R.id.etSMPS);
        etR6 = (EditText)findViewById(R.id.etR6);
        etR10 = (EditText)findViewById(R.id.etR10);

        //TextViews
        tvD1 = (TextView)findViewById(R.id.tvD1);
        tvR4 = (TextView)findViewById(R.id.tvR4);
        tvR5 = (TextView)findViewById(R.id.tvR5);
        tvR6 = (TextView)findViewById(R.id.tvR6);
        tvR7 = (TextView)findViewById(R.id.tvR7);
        tvR8 = (TextView)findViewById(R.id.tvR8);
        tvR9 = (TextView)findViewById(R.id.tvR9);
        tvR10 = (TextView)findViewById(R.id.tvR10);
        tvElemento3 = (TextView)findViewById(R.id.tvElemento3);

        //BUTTON
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        //FLOAT BUTTON
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //variables intent
        v = getIntent().getStringExtra("view");
        R1 = Double.parseDouble(getIntent().getStringExtra("R1"));
        R2 = Double.parseDouble(getIntent().getStringExtra("R2"));
        ra = Double.parseDouble(getIntent().getStringExtra("RA"));
        rb = Double.parseDouble(getIntent().getStringExtra("RB"));
        Elemento = getIntent().getStringExtra("Elemento");
        Elemento2 = getIntent().getStringExtra("Elemento2");
        C1 = Double.parseDouble(getIntent().getStringExtra("C1"));
        C2 = Double.parseDouble(getIntent().getStringExtra("C2"));
        C3 = Double.parseDouble(getIntent().getStringExtra("C3"));
        C4 = Double.parseDouble(getIntent().getStringExtra("C4"));
        CT = Double.parseDouble(getIntent().getStringExtra("CT"));
        f = Double.parseDouble(getIntent().getStringExtra("F"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux_r6 = etR6.getText().toString();
                String aux_smps = etSMPS.getText().toString();
                String aux_r10 = etR10.getText().toString();

                if(!aux_r6.equals("") &&  !aux_smps.equals("") && !aux_r10.equals("")) {

                    R6 = Double.parseDouble(aux_r6)* 1000;
                    R10 = Double.parseDouble(aux_r10)* 1000;
                    SMPS = Double.parseDouble(aux_smps);

                    R5 = CalcularR5(SMPS,R6);
                    R9 = CalcularR9(AMP,R10);

                    tvD1.setText("D1: " + D1);
                    tvR4.setText("R4: " + R4 + "Ohm");
                    tvR5.setText("R5: " + String.valueOf(R5));
                    tvR6.setText("R6: " + String.valueOf(R6));
                    tvR7.setText("R7: " + R7 + "Ohm");
                    tvR8.setText("R8: " + R8 + "Ohm");
                    tvR9.setText("R9: " + String.valueOf(R9));
                    tvR10.setText("R10: " + String.valueOf(R10));
                    tvElemento3.setText("Elemento integrado: " + Elemento3);

                    fab.setVisibility(View.VISIBLE);

                }else{
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(v.equals("SD")){
                    Intent i = new Intent(getApplicationContext(), StepDownFinalActivity.class);
                    i.putExtra("view", v);
                    i.putExtra("R1",  String.valueOf(R1));
                    i.putExtra("R2",  String.valueOf(R2));
                    i.putExtra("RA",  String.valueOf(ra));
                    i.putExtra("RB",  String.valueOf(rb));
                    i.putExtra("C1",  String.valueOf(C1));
                    i.putExtra("C2",  String.valueOf(C2));
                    i.putExtra("C3",  String.valueOf(C3));
                    i.putExtra("CT",  String.valueOf(CT));
                    i.putExtra("R6", String.valueOf(R6));
                    i.putExtra("R10", String.valueOf(R10));
                    i.putExtra("SMPS", String.valueOf(SMPS));
                    i.putExtra("R5", String.valueOf(R5));
                    i.putExtra("R9", String.valueOf(R9));
                    i.putExtra("C4", String.valueOf(C4));
                    i.putExtra("Elemento", Elemento);
                    i.putExtra("Elemento2", Elemento2);
                    i.putExtra("Elemento3", Elemento3);
                    i.putExtra("D1", String.valueOf(D1));
                    i.putExtra("R7", String.valueOf(R7));
                    i.putExtra("R8", String.valueOf(R8));
                    i.putExtra("R4", String.valueOf(R4));
                    i.putExtra("F",  String.valueOf(f));
                    startActivity(i);
                }
                else if(v.equals("SU")){
                    Intent i = new Intent(getApplicationContext(), StepUpFinalActivity.class);
                    i.putExtra("view", v);
                    i.putExtra("R1",  String.valueOf(R1));
                    i.putExtra("R2",  String.valueOf(R2));
                    i.putExtra("RA",  String.valueOf(ra));
                    i.putExtra("RB",  String.valueOf(rb));
                    i.putExtra("C1",  String.valueOf(C1));
                    i.putExtra("C2",  String.valueOf(C2));
                    i.putExtra("C3",  String.valueOf(C3));
                    i.putExtra("CT",  String.valueOf(CT));
                    i.putExtra("R6", String.valueOf(R6));
                    i.putExtra("R10", String.valueOf(R10));
                    i.putExtra("SMPS", String.valueOf(SMPS));
                    i.putExtra("R5", String.valueOf(R5));
                    i.putExtra("R9", String.valueOf(R9));
                    i.putExtra("C4", String.valueOf(C4));
                    i.putExtra("Elemento", Elemento);
                    i.putExtra("Elemento2", Elemento2);
                    i.putExtra("Elemento3", Elemento3);
                    i.putExtra("D1", String.valueOf(D1));
                    i.putExtra("R7", String.valueOf(R7));
                    i.putExtra("R8", String.valueOf(R8));
                    i.putExtra("R4", String.valueOf(R4));
                    i.putExtra("F",  String.valueOf(f));
                    startActivity(i);
                }


            }
        });
    }

    public double CalcularR5(double SMPS, double R6){

        Log.e(TAG, "SMPS: " + String.valueOf(SMPS));
        Log.e(TAG, "R6: " + String.valueOf(R6));


        double result = ((SMPS/6.5)-1)*R6;

        Log.e(TAG, "R5: " + String.valueOf(result));

        return result / 1000;
    }

    public double CalcularR9(double AMP, double R10){

        Log.e(TAG, "AMP: " + String.valueOf(AMP));
        Log.e(TAG, "R10: " + String.valueOf(R10));

        double result = ((AMP/3.5)-1)*R10;

        Log.e(TAG, "R9: " + String.valueOf(result));

        return result / 1000;
    }

}
