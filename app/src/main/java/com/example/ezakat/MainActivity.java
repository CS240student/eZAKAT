package com.example.ezakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuKeep:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);

                break;

            case R.id.menuWear:
                Intent intent1 = new Intent(this, ThirdActivity.class);
                startActivity(intent1);

                break;

            case R.id.menuAboutUs:
                Intent intent2 = new Intent(this, AboutUs.class);
                startActivity(intent2);

                break;

        }
        return true;
    }
}
