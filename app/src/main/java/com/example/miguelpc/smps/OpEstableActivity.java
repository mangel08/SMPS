package com.example.miguelpc.smps;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class OpEstableActivity extends AppCompatActivity {

    private static final String TAG = OpEstableActivity.class.getSimpleName();
    public String v = "";
    public String _C3;
    public EditText etCt, etRb, etC3;
    public Button btnCalcular;
    public TextView tvR1, tvRB, tvRA, tvC1, tvC2, tvC3, tvD1, tvR4, tvR5, tvC6, tvU3, tvFrecuencia, tvElemento;
    public LinearLayout linearLayout1;
    public FloatingActionButton fab;
    public double R1 = 1000;
    public double ra = 0;
    public double rb = 0;
    public double C3 = 0;
    public double frecuencia = 0;
    public double C1 = 45;
    public double C2 = 0.1;
    public double CT;
    public String D1 = "D1: Diodo de alta frecuencia";
    public String R4 = "R4: 100 Ω";
    public String R5 = "R5: 2000 Ω";
    public String C6 = "C6: ";
    public String U3 = "U3: Opto acoplador";
    public String Elemento = "TIMER 555";
    public DecimalFormat df = new DecimalFormat("#.00");
    public DecimalFormat df2 = new DecimalFormat("#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op_estable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //EditText del Fomulario
        etCt = (EditText) findViewById(R.id.ciclo_trabajo);
        etRb = (EditText) findViewById(R.id.rb);
        etC3 = (EditText) findViewById(R.id.c3);

        //LinearLayout

        linearLayout1 = (LinearLayout)findViewById(R.id.lLayout1);

        //TextView Listado
        tvR1 = (TextView)findViewById(R.id.tvR1);
        tvRA = (TextView)findViewById(R.id.tvRA);
        tvRB = (TextView)findViewById(R.id.tvRB);
        tvC1 = (TextView)findViewById(R.id.tvC1);
        tvC2 = (TextView)findViewById(R.id.tvC2);
        tvC3 = (TextView)findViewById(R.id.tvC3);
        tvD1 = (TextView)findViewById(R.id.tvD1);
        tvR4 = (TextView)findViewById(R.id.tvR4);
        tvR5 = (TextView)findViewById(R.id.tvR5);
        tvC6 = (TextView)findViewById(R.id.tvC6);
        tvU3 = (TextView)findViewById(R.id.tvU3);

        tvElemento = (TextView)findViewById(R.id.tvElemento);
        tvFrecuencia = (TextView)findViewById(R.id.tvFrecuencia);

        //FloatButton
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //Button para calcular
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aux_ct = etCt.getText().toString();
                String aux_rb = etRb.getText().toString();
                String aux_c3 =  etC3.getText().toString();

                if(!aux_ct.equals("") &&  !aux_rb.equals("") && !aux_c3.equals("")){



                    if(Double.parseDouble(aux_ct) <= 0 || Double.parseDouble(aux_ct) >= 1 ){

                        Toast.makeText(getApplicationContext(), "Ciclo de trabajo debe ser un valor mayor a 0 y menor a 1 (0.1 ... 0.9)", Toast.LENGTH_LONG).show();


                    }else{

                        rb = Double.parseDouble(aux_rb);
                        Log.e(TAG, "C3: " + String.valueOf(aux_c3));
                        aux_c3 = String.valueOf(Double.parseDouble(aux_c3));
                        Log.e(TAG, "C3: " + String.valueOf(aux_c3));
                        C3 = Double.parseDouble(aux_c3) / 1000000L;
                        Log.e(TAG, "C3: " + String.valueOf(C3));
                        _C3 = aux_c3;

                        CT = Double.parseDouble(aux_ct);

                        ra = CalcularRa(Double.parseDouble(aux_rb), Double.parseDouble(aux_ct));
                        frecuencia = CalcularFrecuencia(ra,Double.parseDouble(aux_rb), C3);

                        tvR1.setText("R1: " + df2.format(R1)+" Ω");
                        tvRA.setText("RA: "+ df2.format(ra) + " Ω");

                        tvRB.setText("RB: " + aux_rb + " Ω");
                        tvC1.setText("C1: " + C1 + " μF");
                        tvC2.setText("C2: " + C2 + " μF");
                        tvC3.setText("C3: " + aux_c3 + " μF");
                        tvD1.setText(D1);
                        tvR4.setText(R4);
                        tvR5.setText(R5);
                        tvC6.setText(C6);
                        tvU3.setText(U3);
                        tvElemento.setText("Elemento integrado: " + Elemento);
                        tvFrecuencia.setText("Frecuencia: " + df2.format(frecuencia) + " Hz");

                        linearLayout1.setVisibility(View.VISIBLE);
                        fab.setVisibility(View.VISIBLE);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
                }
            }
        });

        v = getIntent().getStringExtra("view");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PWMActivity.class);
                i.putExtra("view", v);
                i.putExtra("R1", df2.format(R1));
                i.putExtra("R4", R4);
                i.putExtra("R5", R5);
                i.putExtra("C", C6);
                i.putExtra("U3", U3);
                i.putExtra("D1", D1);
                i.putExtra("RA", df2.format(ra));
                i.putExtra("RB", String.valueOf(rb));
                i.putExtra("C1", String.valueOf(C1));
                i.putExtra("C2", String.valueOf(C2));
                i.putExtra("C3", _C3);
                i.putExtra("CT", String.valueOf(CT));
                i.putExtra("Elemento", Elemento);
                i.putExtra("F", df2.format(frecuencia));
                startActivity(i);
            }
        });
    }

    public Double CalcularFrecuencia(double ra, double rb, double c3){

        Log.e(TAG, "RA: " + String.valueOf(ra));
        Log.e(TAG, "RB: " + String.valueOf(rb));
        Log.e(TAG, "C3: " + String.valueOf(c3));

        double result = 1.44/((ra+2*rb)*c3);
        Log.e(TAG, "FRECUENCIA: " + String.valueOf(result));

        result = result * 1000;

        Log.e(TAG, "FRECUENCIA: " + String.valueOf(result));

        return result;
    }

    public Double CalcularRa(double rb, double ct){

        Log.e(TAG, "RB: " + String.valueOf(rb));
        Log.e(TAG, "CT: " + String.valueOf(ct));

        double result = (rb/(1-ct))-2*rb;

        Log.e(TAG, "RA: " + String.valueOf(result));

        return result;
    }
}
