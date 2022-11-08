package org.abrox.android_4_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = new RadioGroup(this);
        CheckBox ch1 = (CheckBox) findViewById(R.id.ch1);
        CheckBox ch2 = (CheckBox) findViewById(R.id.ch2);
        CheckBox ch3 = (CheckBox) findViewById(R.id.ch3);
        CheckBox ch4 = (CheckBox) findViewById(R.id.ch4);

        TextView tv = (TextView) findViewById(R.id.tv1);



        rg.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int sumaTotal = sumaChekBox(ch1,ch2,ch3,ch4);
                       sumarCalorias(checkedId, sumaTotal, tv);
                        }
                    }
             );
        }

    private void sumarCalorias(int checkedId, int sumaTotal, TextView tv) {

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

    }


}