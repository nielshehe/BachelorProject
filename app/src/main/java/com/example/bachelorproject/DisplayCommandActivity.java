package com.example.bachelorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import dk.sdu.bachelorf15.domain.Truck;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.Helper;
import dk.sdu.bachelorf15.help.TruckObjects;

public class DisplayCommandActivity extends ActionBarActivity implements View.OnClickListener
{
    private int mapIndex;

	private ImageView ivObjectMain;
    private ImageView ivCommandoMain1, ivCommandoMain2, ivCommandoMain3;
    private ImageButton btnCommando1, btnCommando2, btnCommando3, btnCommando4;

    private Helper help = new Helper();
    private TruckObjects truckObject;
    private Commands command;

    // TODO REMOVE ONLY TO TEST TRUCK MAP
    private TextView txtView1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_display_commando);

		// Set the activity to only fill half the screen
		WindowManager.LayoutParams params = getWindow().getAttributes();
		params.x = (getWindowManager().getDefaultDisplay().getWidth()) / 2;
		params.width = getWindowManager().getDefaultDisplay().getWidth() / 2;
		this.getWindow().setAttributes(params);

        // Initialize components and set click listener
		ivObjectMain = (ImageView) findViewById(R.id.imageObjectMain);
        ivCommandoMain1 = (ImageView) findViewById(R.id.imageCommandoMain1);
        ivCommandoMain1.setOnClickListener(this);
        ivCommandoMain2 = (ImageView) findViewById(R.id.imageCommandoMain2);
        ivCommandoMain2.setOnClickListener(this);
        ivCommandoMain3 = (ImageView) findViewById(R.id.imageCommandoMain3);
        ivCommandoMain3.setOnClickListener(this);

        btnCommando1 = (ImageButton) findViewById(R.id.imagebtnCommando1);
        btnCommando1.setOnClickListener(this);
        btnCommando2 = (ImageButton) findViewById(R.id.imagebtnCommando2);
        btnCommando2.setOnClickListener(this);
        btnCommando3 = (ImageButton) findViewById(R.id.imagebtnCommando3);
        btnCommando3.setOnClickListener(this);
        btnCommando4 = (ImageButton) findViewById(R.id.imagebtnCommando4);
        btnCommando4.setOnClickListener(this);

		/*
		 * It reads the value that was set for EXTRA_IMAGEID in the intent used
		 * to start the activity.
		 * Hence, imageID now contains the user-selected value
		 * (or the R.drawable.startmain if the activity is started through
		 * a different intent which did not set EXTRA_IMAGEID)
		 */
		Intent intent = getIntent();
		int imageRef = intent.getIntExtra(MainActivity.EXTRA_IMAGEID,
				R.drawable.startmain);
        mapIndex = intent.getIntExtra(MainActivity.EXTRA_INDEX, 1);

		if (imageRef == R.drawable.daek)
        {
            help.setImageAndTag(ivObjectMain, R.drawable.daekmain);
            btnCommando1.setImageResource(R.drawable.daekop);
            btnCommando2.setImageResource(R.drawable.daekned);
            truckObject = TruckObjects.TIRE;
        }
		else if (imageRef == R.drawable.rat)
        {
            help.setImageAndTag(ivObjectMain, R.drawable.ratmain);
            btnCommando1.setImageResource(R.drawable.ratvenstre);
            btnCommando2.setImageResource(R.drawable.rathoejre);
            truckObject = TruckObjects.STEERINGWHEEL;
        }
		else if (imageRef == R.drawable.kran)
        {
            help.setImageAndTag(ivObjectMain, R.drawable.kranmain);
            btnCommando1.setImageResource(R.drawable.kranvenstre);
            btnCommando2.setImageResource(R.drawable.kranop);
            btnCommando3.setImageResource(R.drawable.kranned);
            btnCommando4.setImageResource(R.drawable.kranhoejre);
            truckObject = TruckObjects.CRANE;
        }

        // TODO REMOVE ONLY TO TEST TRUCK MAP
        txtView1 = (TextView) findViewById(R.id.textView2);
        txtView1.setText("INDEX: " + mapIndex);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.display_commando, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) { return true; }
		return super.onOptionsItemSelected(item);
	}

    @Override
    public void onClick(View v)
    {
        // Get image ID for the selected button
        int imageId = 0;

        if (help.getImageId(ivObjectMain) == R.drawable.daekmain)
        {
            if (v.getId() == R.id.imagebtnCommando1)
            {
                imageId = R.drawable.daekop;
                command = Commands.TIRE_MOVE_FORWARD;
            }
            else if (v.getId() == R.id.imagebtnCommando2)
            {
                imageId = R.drawable.daekned;
                command = Commands.TIRE_MOVE_BACKWARD;
            }
        }
        else if (help.getImageId(ivObjectMain) == R.drawable.ratmain)
        {
            if (v.getId() == R.id.imagebtnCommando1)
            {
                imageId = R.drawable.ratvenstre;
                command = Commands.STEER_TURN_LEFT;
            }
            else if (v.getId() == R.id.imagebtnCommando2)
            {
                imageId = R.drawable.rathoejre;
                command = Commands.STEER_TURN_RIGHT;
            }
        }
        else if (help.getImageId(ivObjectMain) == R.drawable.kranmain)
        {
            if (v.getId() == R.id.imagebtnCommando1)
            {
                imageId = R.drawable.kranvenstre;
                command = Commands.CRANE_TURN_LEFT;
            }
            else if (v.getId() == R.id.imagebtnCommando2)
            {
                imageId = R.drawable.kranop;
                command = Commands.CRANE_BOX_PICKUP;
            }
            else if (v.getId() == R.id.imagebtnCommando3)
            {
                imageId = R.drawable.kranned;
                command = Commands.CRANE_BOX_PUTDOWN;
            }
            else if (v.getId() == R.id.imagebtnCommando4)
            {
                imageId = R.drawable.kranhoejre;
                command = Commands.CRANE_TURN_RIGHT;
            }
        }

        // Set selected image on the map for the objects Tire, Steeringwheel and Crane
        if (v.getId() == R.id.imagebtnCommando1 || v.getId() == R.id.imagebtnCommando2
                || v.getId() == R.id.imagebtnCommando3 || v.getId() == R.id.imagebtnCommando4)
        {
            if (ivCommandoMain1.getDrawable() == null)
            {
                help.setImageAndTag(ivCommandoMain1, imageId);
                Truck.getInstance().addCommand(mapIndex, 1 , truckObject, command);
            }
            else if (ivCommandoMain2.getDrawable() == null)
            {
                help.setImageAndTag(ivCommandoMain2, imageId);
                Truck.getInstance().addCommand(mapIndex, 2,  truckObject, command);
            }
            else if (ivCommandoMain3.getDrawable() == null)
            {
                help.setImageAndTag(ivCommandoMain3, imageId);
                Truck.getInstance().addCommand(mapIndex, 3, truckObject, command);
            }
        }
        txtView1.setText("TRUCKOBJECT: " + truckObject + " COMMAND: " + command);
    }
}