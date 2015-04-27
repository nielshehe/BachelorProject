package com.example.bachelorproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import dk.sdu.bachelorf15.domain.Truck;


public class MainLevelActivity extends ActionBarActivity implements View.OnClickListener
{
    public final static String DRIVING_IMAGE = "com.example.bachelorproject.DRIVINGIMAGEREF";
    public final static String CAR_START_X = "com.example.bachelorproject.CARPOSX";
    public final static String CAR_START_Y = "com.example.bachelorproject.CARPOSY";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_level);

        ImageButton btnLevel1 = (ImageButton) findViewById(R.id.btnLevel1);
        btnLevel1.setOnClickListener(this);
        ImageButton btnLevel2 = (ImageButton) findViewById(R.id.btnLevel2);
        btnLevel2.setOnClickListener(this);
        ImageButton btnLevel3 = (ImageButton) findViewById(R.id.btnLevel3);
        btnLevel3.setOnClickListener(this);
        ImageButton btnLevel4 = (ImageButton) findViewById(R.id.btnLevel4);
        btnLevel4.setOnClickListener(this);
        ImageButton btnLevel5 = (ImageButton) findViewById(R.id.btnLevel5);
        btnLevel5.setOnClickListener(this);
        ImageButton btnLevel6 = (ImageButton) findViewById(R.id.btnLevel6);
        btnLevel6.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_level, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        int drivingImageRef = 0;
        int carPosX = 0;
        int carPosY = 0;

        switch (v.getId())
        {
            case R.id.btnLevel1:
                drivingImageRef = R.drawable.drivinglevelone;
                carPosX = 1;
                carPosY = 1;
                break;
            case R.id.btnLevel2:
                drivingImageRef = R.drawable.drivingleveltwo;
                carPosX = 4;
                carPosY = 0;
                break;
            case R.id.btnLevel3:
                drivingImageRef = R.drawable.drivinglevelthree;
                carPosX = 3;
                carPosY = 3;
                break;
            case R.id.btnLevel4:
                drivingImageRef = R.drawable.drivinglevelfour;
                carPosX = 3;
                carPosY = 3;
                break;
            case R.id.btnLevel5:
                drivingImageRef = R.drawable.drivinglevelfive;
                carPosX = 1;
                carPosY = 4;
                break;
            case R.id.btnLevel6:
                drivingImageRef = R.drawable.drivinglevelsix;
                carPosX = 0;
                carPosY = 1;
                break;
        }

        Intent intent = new Intent(this, MainActivity.class);

        // Send background image for the driving field, start position  of the car
        intent.putExtra(DRIVING_IMAGE, drivingImageRef);
        intent.putExtra(CAR_START_X, carPosX);
        intent.putExtra(CAR_START_Y, carPosY);

        startActivity(intent);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Truck.getInstance().clearCommands();
    }
}
