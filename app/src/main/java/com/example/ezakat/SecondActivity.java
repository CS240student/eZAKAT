package com.example.ezakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    EditText weight, current;
    Button calculate;
    TextView tgv, zp, tz;
    float SPweight, SPcurrent;

    SharedPreferences sp;
    SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        weight = (EditText) findViewById(R.id.inputWeight);
        current = (EditText) findViewById(R.id.inputCurrent);

        calculate = (Button) findViewById(R.id.buttonCalculate);

        tgv = (TextView) findViewById(R.id.outputTotal);
        zp = (TextView) findViewById(R.id.outputPayable);
        tz = (TextView) findViewById(R.id.outputZakat);

        calculate.setOnClickListener(this);

        SPweight = 0;
        SPcurrent = 0;
        sp = this.getSharedPreferences("WEIGHT", Context.MODE_PRIVATE);
        sp1 = this.getSharedPreferences("CURRENT", Context.MODE_PRIVATE);

        SPweight = sp.getFloat("WEIGHT", 0.0F);
        SPcurrent = sp.getFloat("CURRENT", 0.0F);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuHome:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                break;
        }
        return true;
    }


    public void onClick(View view) {

        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat("WEIGHT", SPweight);
        editor.apply();

        SharedPreferences.Editor editor1 = sp1.edit();
        editor1.putFloat("CURRENT", SPcurrent);
        editor1.apply();

        switch (view.getId()) {

            case R.id.buttonCalculate:

                try {

                String variableWeight = weight.getText().toString();
                String variableCurrent = current.getText().toString();

                double valueGold = Double.parseDouble(variableWeight);
                double valueCurrent = Double.parseDouble(variableCurrent);

                double totalGoldValue = valueGold * valueCurrent;
                tgv.setText("Total value of the gold: " + totalGoldValue);

                double zakatPayable = (valueGold - 85) * valueCurrent;

                    if(zakatPayable <= 0)
                    {
                        zakatPayable = 0;
                        zp.setText("Zakat payable:" +zakatPayable);
                        double totalZakat1 = 0.025 * zakatPayable;
                        tz.setText("Total zakat: " +totalZakat1);
                    }

                    else {
                        zp.setText("Zakat payable:" +zakatPayable);
                        double totalZakat1 = 0.025 * zakatPayable;
                        tz.setText("Total zakat: " +totalZakat1);

                    }

                } catch (NumberFormatException nfe) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();

                } catch (Exception exp) {
                    Toast.makeText(this, "Unknown Exception", Toast.LENGTH_SHORT).show();

                    Log.d("Exception", exp.getMessage());
                }

                break;

        }


    }

}