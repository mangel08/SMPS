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

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StepDownFinalActivity extends AppCompatActivity {

    //Variables Globales
    private static final String TAG = StepUpFinalActivity.class.getSimpleName();
    public TextView tvL1, tvC5, tvD2, tvRL, tvQ1, tvR11;
    public EditText  etVin, etVout, etRL, etCS;
    public Button btnCalcular;
    public double R6, SMPS, R10, R5, R9, R2, ra, rb, C1, C2, C3, C4, CT, f, Vin, Vout, Iout, C5, L1, CS;
    public int RL;
//    public String R11 = "1000 Ω";
    public String R1, R3, R4, R7, R8;
    public double Vptp = 0.25;
    public String Elemento, Elemento2, Elemento3, D1, v;
    public String Q1 = "Transistor MOSFET IRFZ44N";
    public String D2 = "diodo de alta frecuencia";
    public FloatingActionButton fab;
    public DecimalFormat df = new DecimalFormat("#.00");
    public DecimalFormat df3 = new DecimalFormat("#.00");
    public DecimalFormat df2 = new DecimalFormat("#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_down_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Float button
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //Button
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        //TextViews
        tvL1 = (TextView) findViewById(R.id.tvL1);
        tvC5 = (TextView) findViewById(R.id.tvC5);
        tvD2 = (TextView) findViewById(R.id.tvD2);
        tvRL = (TextView) findViewById(R.id.tvRL);
        tvQ1 = (TextView) findViewById(R.id.tvQ1);
        tvR11 = (TextView) findViewById(R.id.tvR11);

        //EditText
        etVin = (EditText) findViewById(R.id.etVin);
        etVout = (EditText) findViewById(R.id.etVout);
        etRL = (EditText) findViewById(R.id.etRL);
//        etCS = (EditText) findViewById(R.id.etCS);

        //Intents values
        v = getIntent().getStringExtra("view");
        R1 = getIntent().getStringExtra("R1");
        R2 = Double.parseDouble(getIntent().getStringExtra("R2"));
        R3 = getIntent().getStringExtra("R3");
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
        R7 = getIntent().getStringExtra("R7");
        R8 = getIntent().getStringExtra("R8");
        R4 =getIntent().getStringExtra("R4");
        R6 = Double.parseDouble(getIntent().getStringExtra("R6"));
        R10 = Double.parseDouble(getIntent().getStringExtra("R10"));
        D1 = getIntent().getStringExtra("D1");
        SMPS = Double.parseDouble(getIntent().getStringExtra("SMPS"));

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aux_vin = etVin.getText().toString();
                String aux_vout = etVout.getText().toString();
                String aux_rl = etRL.getText().toString();
//                String aux_cs = etCS.getText().toString();

                if (!aux_vin.equals("") && !aux_vout.equals("") && !aux_rl.equals("")) {
                    Vin = Double.parseDouble(aux_vin);
                    Vout = Double.parseDouble(aux_vout);
                    RL = Integer.parseInt(aux_rl);
//                    CS = Integer.parseInt(aux_cs);

                    Iout = CalcularIout(Vout,RL);
                    C5 = CalcularC5(Iout,CT,f,Vptp);
                    L1 = CalcularL1(Vin,Vout,CT,Iout,f,Vptp);

                    tvC5.setText(String.valueOf("C5: " + df.format(C5)+ " μF"));
                    tvL1.setText(String.valueOf("L1: 0" + df.format(L1) + "mh"));
                    tvQ1.setText(String.valueOf("Q1: " + Q1));
                    tvRL.setText(String.valueOf("RL: " +RL + " Ω"));
                    tvD2.setText(String.valueOf("D2: " +D2));
//                    tvR11.setText(String.valueOf("R11: " + R11 + " Ω"));

                    fab.setVisibility(View.VISIBLE);

                }
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ResultadosSDActivity.class);
                i.putExtra("view", v);
                i.putExtra("R1",  String.valueOf(R1));
                i.putExtra("R2",  String.valueOf(R2));
                i.putExtra("R3",  String.valueOf(R3));
                i.putExtra("RA",  String.valueOf(ra));
                i.putExtra("RB",  String.valueOf(rb));
                i.putExtra("C1",  String.valueOf(C1));
                i.putExtra("C2",  String.valueOf(C2));
                i.putExtra("C3",  String.valueOf(C3));
                i.putExtra("CT",  String.valueOf(CT));
                i.putExtra("R6", String.valueOf(R6));
                i.putExtra("R10", String.valueOf(R10));
//                i.putExtra("R11", String.valueOf(R11));
                i.putExtra("SMPS", String.valueOf(SMPS));
                i.putExtra("R5", String.valueOf(R5));
                i.putExtra("R9", String.valueOf(R9));
                i.putExtra("RL", String.valueOf(RL));
                i.putExtra("C4", String.valueOf(C4));
                i.putExtra("C5", df.format(C5));
                i.putExtra("Elemento", Elemento);
                i.putExtra("Elemento2", Elemento2);
                i.putExtra("Elemento3", Elemento3);
                i.putExtra("D1", String.valueOf(D1));
                i.putExtra("D2", String.valueOf(D2));
                i.putExtra("R7", String.valueOf(R7));
                i.putExtra("R8", String.valueOf(R8));
                i.putExtra("R4", String.valueOf(R4));
                i.putExtra("RL", String.valueOf(RL));
                i.putExtra("Q1", String.valueOf(Q1));
                i.putExtra("L1", df.format(L1));
                i.putExtra("F",  String.valueOf(f));
                startActivity(i);
            }
        });
    }

    public Double CalcularIout(double Vout, double RL){

        Log.e(TAG, "Vout: " + String.valueOf(Vout));
        Log.e(TAG, "RL: " + String.valueOf(RL));
        double result = Vout / RL;
        Log.e(TAG, "Iout: " + String.valueOf(result));

        return result;
    }

    public Double CalcularC5(double Iout, double ct, double f, double Vptp){

        Log.e(TAG, "Iout: " + String.valueOf(Iout));
        Log.e(TAG, "CT: " + String.valueOf(ct));
        Log.e(TAG, "F: " + String.valueOf(f));
        Log.e(TAG, "Vptp: " + String.valueOf(Vptp));
        double result = (Iout*ct)/(f*Vptp);
        Log.e(TAG, "C5: " + String.valueOf(result));

        result = result * 1000000;
        Log.e(TAG, "C5: " + String.valueOf(result));

        return result;

    }

    public Double CalcularL1(double Vin, double Vout, double ct, double Iout, double f, double Vptp){

        Log.e(TAG, "Iout: " + String.valueOf(Iout));
        Log.e(TAG, "CT: " + String.valueOf(ct));
        Log.e(TAG, "F: " + String.valueOf(f));
        Log.e(TAG, "Vptp: " + String.valueOf(Vptp));
        Log.e(TAG, "Vin: " + String.valueOf(Vin));
        Log.e(TAG, "Vout: " + String.valueOf(Vout));



        double result = ((Vin-Vout)*ct)/(2*Iout*(float)f);

        Log.e(TAG, "L1: " + String.valueOf(result));
        result = result * 1000;
        Log.e(TAG, "L1: " + String.valueOf(result));

        return result;
    }

}
