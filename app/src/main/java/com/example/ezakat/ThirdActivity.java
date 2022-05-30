package com.example.ezakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    EditText weight1, current1;
    Button calculate1;
    TextView tgv1, zp1, tz1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        weight1 = (EditText) findViewById(R.id.inputWeight1);
        current1 = (EditText) findViewById(R.id.inputCurrent1);

        calculate1 = (Button) findViewById(R.id.buttonCalculate1);

        tgv1 = (TextView) findViewById(R.id.outputTotal1);
        zp1 = (TextView) findViewById(R.id.outputPayable1);
        tz1 = (TextView) findViewById(R.id.outputZakat1);

        calculate1.setOnClickListener(this);
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

        switch (view.getId()) {

            case R.id.buttonCalculate1:

                try {

                    String variableWeight1 = weight1.getText().toString();
                    String variableCurrent1 = current1.getText().toString();

                    double valueGold1 = Double.parseDouble(variableWeight1);
                    double valueCurrent1 = Double.parseDouble(variableCurrent1);
                    double totalGoldValue1 = valueGold1 * valueCurrent1;

                    double zakatPayable1 = (valueGold1 - 200) * valueCurrent1;

                    tgv1.setText("Total value of the gold: " +totalGoldValue1);

                   if(zakatPayable1 <= 0)
                    {
                        zakatPayable1 = 0;
                        zp1.setText("Zakat payable: " +zakatPayable1);
                        double totalZakat1 = 0.025 * zakatPayable1;
                        tz1.setText("Total zakat: " +totalZakat1);
                    }

                    else {
                        zp1.setText("Zakat payable: " +zakatPayable1);
                        double totalZakat1 = 0.025 * zakatPayable1;
                        tz1.setText("Total zakat: " +totalZakat1);

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