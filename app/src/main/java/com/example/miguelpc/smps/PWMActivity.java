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

public class PWMActivity extends AppCompatActivity {

    private static final String TAG = PWMActivity.class.getSimpleName();
    public EditText etC4;
    public double R2, clockperiod;
    public double C4, f, ra, rb, C1, C2, C3, R1, CT;
    public String R3 = "1000 Ω";
    public TextView tvR2, tvR3, tvC4, tvElemento;
    public Button btnCalcular;
    public String Elemento = "";
    public String Elemento2 = "TIMER 555";
    public FloatingActionButton fab;
    public String v = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        f = Double.parseDouble(getIntent().getStringExtra("F"));
        R1 = Double.parseDouble(getIntent().getStringExtra("R1"));
        ra = Double.parseDouble(getIntent().getStringExtra("RA"));
        Elemento = getIntent().getStringExtra("Elemento");
        rb = Double.parseDouble(getIntent().getStringExtra("RB"));
        C1 = Double.parseDouble(getIntent().getStringExtra("C1"));
        C2 = Double.parseDouble(getIntent().getStringExtra("C2"));
        C3 = Double.parseDouble(getIntent().getStringExtra("C3"));
        CT = Double.parseDouble(getIntent().getStringExtra("CT"));
        v = getIntent().getStringExtra("view");

        //Editext del formulario
        etC4 = (EditText) findViewById(R.id.etC4);

        //TextViews del Listado
        tvR2 = (TextView) findViewById(R.id.tvR2);
        tvR3 = (TextView) findViewById(R.id.tvR3);
        tvC4 = (TextView) findViewById(R.id.tvC4);
        tvElemento = (TextView) findViewById(R.id.tvElemento);

        //Buutton
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        //FloatButton
        fab = (FloatingActionButton) findViewById(R.id.fab);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux_c4 = etC4.getText().toString();

                if(!aux_c4.equals("")){

                    aux_c4 = String.valueOf(Double.parseDouble(aux_c4) / 1000000L);
                    clockperiod = ClockPeriod(f);
                    R2 = CalcularR2(Double.parseDouble(aux_c4), clockperiod);
                    C4 = Double.parseDouble(aux_c4);
                    tvR2.setText("R2: " + R2 + " Ω");
                    tvR3.setText("R3: " + R3);
                    tvC4.setText("C4: " + String.valueOf(C4) + " μF");
                    tvElemento.setText("Elemento integrado: " + Elemento2);

                    fab.setVisibility(View.VISIBLE);

                }else{
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
                }
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AmplificadorDifActivity.class);
                i.putExtra("view", v);
                i.putExtra("R1", String.valueOf(R1));
                i.putExtra("R2", String.valueOf(R2));
                i.putExtra("R3", String.valueOf(R3));
                i.putExtra("RA", String.valueOf(ra));
                i.putExtra("RB", String.valueOf(rb));
                i.putExtra("C1", String.valueOf(C1));
                i.putExtra("C2", String.valueOf(C2));
                i.putExtra("C3", String.valueOf(C3));
                i.putExtra("C4", String.valueOf(C4));
                i.putExtra("CT", String.valueOf(CT));
                i.putExtra("Elemento", Elemento);
                i.putExtra("Elemento2", Elemento2);
                i.putExtra("F", String.valueOf(f));
                startActivity(i);
            }
        });

    }

    public double ClockPeriod(double f){
        Log.e(TAG, "F: " + String.valueOf(f));
        double result = 1/f;

        Log.e(TAG, "F: " + String.valueOf(f));
        Log.e(TAG, "CLOCK: " + String.valueOf(result));

        return result;
    }

    public double CalcularR2(double c4, double clockperiod){

        Log.e(TAG, "C4: " + String.valueOf(c4));
        Log.e(TAG, "CLOCK: " + String.valueOf(clockperiod));

        double result = ((0.25)*clockperiod)/c4;

        result = result * 1000;

        Log.e(TAG, "R2: " + String.valueOf(result));

        return result;
    }
}
