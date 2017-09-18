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
import android.widget.Toast;

public class PWMActivity extends AppCompatActivity {

    public EditText etC4;
    public double R2, clockperiod;
    public double C4;
    public TextView tvR2, tvR3, tvC4, tvElemento;
    public Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux_c4 = etC4.getText().toString();

                if(!aux_c4.equals("")){

                    aux_c4 = String.valueOf(Double.parseDouble(aux_c3) / 1000000L);
                    double f = getIntent().getStringExtra("F");

                    clockperiod = ClockPeriod();
                    frecuencia = CalcularFrecuencia(ra,Double.parseDouble(aux_rb),Double.parseDouble(aux_c3));

                    tvR1.setText("R1: " + R1 +" Ohm");
                    tvRA.setText("RA: " + String.valueOf(ra));
                    tvRB.setText("RB: " + aux_rb);
                    tvC1.setText("C1: " + C1 + " Micro Faradios");
                    tvC2.setText("C2: " + C2 + " Micro Faradios");
                    tvC3.setText("C3: " + aux_c3);
                    tvElemento.setText("Elemento integrado: " + Elemento);
                    tvFrecuencia.setText("Frecuencia: " + frecuencia);

                    linearLayout1.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
                }
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public Double ClockPeriod(double f){

        double result = 1/f;

        return result;
    }

    public Double CalcularR2(double c4, double clockperiod){

        double result = ((1/4)*clockperiod)/c4;

        return result;
    }
}
