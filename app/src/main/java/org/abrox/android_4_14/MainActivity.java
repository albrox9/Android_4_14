package org.abrox.android_4_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton rbLight;
    private RadioButton rbNormal;
    private RadioButton rbGraso;
    private CheckBox ch1;
    private CheckBox ch2;
    private CheckBox ch3;
    private CheckBox ch4;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarControles();

        configurarListeners();








        /*rg.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int sumaTotal = sumaChekBox(ch1,ch2,ch3,ch4);
                       sumarCalorias(checkedId, sumaTotal, tv);
                        }
                    }
             );*/
        }

    private void asignarControles() {

        this.rg = findViewById(R.id.radioGroup);

        this.rbLight = findViewById(R.id.rd1);
        this.rbNormal = findViewById(R.id.rd2);
        this.rbGraso = findViewById(R.id.rd3);

        this.ch1 = (CheckBox) findViewById(R.id.ch1);
        this.ch2 = (CheckBox) findViewById(R.id.ch2);
        this.ch3 = (CheckBox) findViewById(R.id.ch3);
        this.ch4 = (CheckBox) findViewById(R.id.ch4);

        this.tv = (TextView) findViewById(R.id.tv1);


    }

    private void configurarListeners() {

        this.rg.setOnCheckedChangeListener((rg, id)-> actualizar());


        this.ch1.setOnCheckedChangeListener((cb,b) -> actualizar());
        this.ch2.setOnCheckedChangeListener((cb,b) -> actualizar());
        this.ch3.setOnCheckedChangeListener((cb,b) -> actualizar());
        this.ch4.setOnCheckedChangeListener((cb,b) -> actualizar());

    }

    private void actualizar() {

        int calorias = 0;
        calorias += ch1.isChecked() ? 100 : 0;
        calorias += ch2.isChecked() ? 500 : 0;
        calorias += ch3.isChecked() ? 1500 : 0;
        calorias += ch4.isChecked() ? 2000 : 0;

        int min = 0;
        int max = 0;



        switch(rg.getCheckedRadioButtonId()){

            case R.id.rd1: min= 0; max =1000;  break;
            case R.id.rd2: min= 1000; max =2000; break;
            case R.id.rd3: min= 2000; max =1000000000;break;
        }

        String mensaje = (calorias > min && calorias < max) ? "OK" : "FATAL";

        mensaje += " te estas comiendo %1$d calorias ";
        mensaje = String.format(mensaje, calorias);

        this.tv.setText(mensaje);

    }

   /* private void sumarCalorias(int checkedId, int sumaTotal, TextView tv) {

        String message;


        switch (checkedId) {
            case R.id.rd1:
                Log.i("CASO1", "HOLAAAA SOY LIGHT");

                if (sumaTotal < 1000) {

                    message = getString(R.string.ok_message);
                    tv.setText(message);

                } else {
                    message = getString(R.string.notok_message);
                    tv.setText(message);
                }
                break;

            case R.id.rd2:
                Log.i("CASO1", "HOLAAAA SOY NORMAL");

                if (sumaTotal >= 1000 && sumaTotal < 2000) {
                    message = getString(R.string.ok_message);
                    tv.setText(message);

                } else {
                    message = getString(R.string.notok_message);
                    tv.setText(message);
                }

                break;

            case R.id.rd3:
                Log.i("CASO1", "HOLAAAA SOY GORDO");

                if (sumaTotal > 2000) {
                    message = getString(R.string.ok_message);
                    tv.setText(message);

                } else {
                    message = getString(R.string.notok_message);
                    tv.setText(message);
                }

                break;
        }
    }


    private int sumaChekBox(CheckBox ch1, CheckBox ch2, CheckBox ch3, CheckBox ch4) {

       int contador = 0;


        if (ch1.isChecked() == true){
            contador += 100;

        } else if (ch2.isChecked() == true){
            contador += 500;

        } else if(ch3.isChecked() == true){
            contador += 1500;

        }else if(ch4.isChecked() == true){
            contador += 2000;
        }

        return contador;

    }*/


}