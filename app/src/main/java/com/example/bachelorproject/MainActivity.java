package com.example.bachelorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import dk.sdu.bachelorf15.domain.Truck;
import dk.sdu.bachelorf15.help.Commands;
import dk.sdu.bachelorf15.help.Helper;
import dk.sdu.bachelorf15.help.TruckObjects;

public class MainActivity extends ActionBarActivity implements OnClickListener
{
    private ImageButton btnTire, btnSteerWheel, btnCrane;
    private ImageView ivMain1, ivMain2, ivMain3, ivMain4;
    private ImageView ivMain5, ivMain6, ivMain7, ivMain8;

    // Variables to send to the DisplayCommandActivity
    // Keep track of which picture that is pressed to start the next activity (in onClick)
	public final static String EXTRA_IMAGEID = "com.example.bachelorproject.IMAGEREF";
    // Keep track of which image is pressed to know the index of the truck map
    public final static String EXTRA_INDEX = "com.example.bachelorproject.INDEX";

    // Index for the truck map and variable for the object
    private int index = 0;
    private TruckObjects truckObject;

    private Helper help = new Helper();

    // TODO REMOVE ONLY TO TEST TRUCK AND MAP
    private TextView txtView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// Initialize ImageButtons
		btnTire = (ImageButton) findViewById(R.id.ibtnTire);
		btnTire.setOnClickListener(this);
		btnSteerWheel = (ImageButton) findViewById(R.id.ibtnSteerWheel);
		btnSteerWheel.setOnClickListener(this);
		btnCrane = (ImageButton) findViewById(R.id.ibtnCrane);
		btnCrane.setOnClickListener(this);

		// Initialize ImageViews on the "Start Kran" main
		ivMain1 = (ImageView) findViewById(R.id.imageMain1);
		ivMain1.setOnClickListener(this);
		ivMain2 = (ImageView) findViewById(R.id.imageMain2);
		ivMain2.setOnClickListener(this);
		ivMain3 = (ImageView) findViewById(R.id.imageMain3);
		ivMain3.setOnClickListener(this);
		ivMain4 = (ImageView) findViewById(R.id.imageMain4);
		ivMain4.setOnClickListener(this);
		ivMain5 = (ImageView) findViewById(R.id.imageMain5);
		ivMain5.setOnClickListener(this);
		ivMain6 = (ImageView) findViewById(R.id.imageMain6);
		ivMain6.setOnClickListener(this);
		ivMain7 = (ImageView) findViewById(R.id.imageMain7);
		ivMain7.setOnClickListener(this);
		ivMain8 = (ImageView) findViewById(R.id.imageMain8);
		ivMain8.setOnClickListener(this);

        // TODO TEST TRUCK AND MAP
        txtView = (TextView) findViewById(R.id.textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		if (v.getId() == R.id.ibtnTire)
        {
            imageId = R.drawable.daek;
            truckObject = TruckObjects.TIRE;
        }
		else if (v.getId() == R.id.ibtnSteerWheel)
        {
            imageId = R.drawable.rat;
            truckObject = TruckObjects.STEERINGWHEEL;
        }
		else if (v.getId() == R.id.ibtnCrane)
        {
            imageId = R.drawable.kran;
            truckObject = TruckObjects.CRANE;
        }

		// Set selected image on the "Start kran" image
		if (v.getId() == R.id.ibtnTire || v.getId() == R.id.ibtnSteerWheel
				|| v.getId() == R.id.ibtnCrane)
		{
			if (ivMain1.getDrawable() == null)
			{
                help.setImageAndTag(ivMain1, imageId);
                // Set the index of the Truck map when you add a object
                index = 1;
                Truck.getInstance().addObject(index, truckObject);
			}
			else if (ivMain2.getDrawable() == null)
			{
                help.setImageAndTag(ivMain2, imageId);
                index = 2;
                Truck.getInstance().addObject(index, truckObject);
            }
			else if (ivMain3.getDrawable() == null)
			{
                help.setImageAndTag(ivMain3, imageId);
                index = 3;
                Truck.getInstance().addObject(index, truckObject);
			}
			else if (ivMain4.getDrawable() == null)
			{
                help.setImageAndTag(ivMain4, imageId);
                index = 4;
                Truck.getInstance().addObject(index, truckObject);
			}
			else if (ivMain5.getDrawable() == null)
			{
                help.setImageAndTag(ivMain5, imageId);
                index = 5;
                Truck.getInstance().addObject(index, truckObject);
			}
			else if (ivMain6.getDrawable() == null)
			{
                help.setImageAndTag(ivMain6, imageId);
                index = 6;
                Truck.getInstance().addObject(index, truckObject);
			}
			else if (ivMain7.getDrawable() == null)
			{
                help.setImageAndTag(ivMain7, imageId);
                index = 7;
                Truck.getInstance().addObject(index, truckObject);
			}
			else if (ivMain8.getDrawable() == null)
			{
                help.setImageAndTag(ivMain8, imageId);
                index = 8;
                Truck.getInstance().addObject(index, truckObject);
			}
		}
		// When clicking on an image on the "Start kran" image
		else
		{
			int imageRef = help.getImageId((ImageView) v);

            // Set the index of the Truck map, if you don't add a new object, but just change one instead
            switch (v.getId())
            {
                case R.id.imageMain1:
                    index = 1;
                    break;
                case R.id.imageMain2:
                    index = 2;
                    break;
                case R.id.imageMain3:
                    index = 3;
                    break;
                case R.id.imageMain4:
                    index = 4;
                    break;
                case R.id.imageMain5:
                    index = 5;
                    break;
                case R.id.imageMain6:
                    index = 6;
                    break;
                case R.id.imageMain7:
                    index = 7;
                    break;
                case R.id.imageMain8:
                    index = 8;
                    break;
            }

            // Set the truck object according to the image
            switch (imageRef)
            {
                case R.drawable.daek:
                    truckObject = TruckObjects.TIRE;
                    break;
                case R.drawable.rat:
                    truckObject = TruckObjects.STEERINGWHEEL;
                    break;
                case R.drawable.kran:
                    truckObject = TruckObjects.CRANE;
                    break;
            }


            Commands command1 = Truck.getInstance().getCommand(index, 1, truckObject);
            Commands command2 = Truck.getInstance().getCommand(index, 2, truckObject);
            Commands command3 = Truck.getInstance().getCommand(index, 3, truckObject);

			/*
			 * creates an intent which, when executed with startActivity, does
			 * two things:
			 * It starts a new activity of class DisplayCommandActivity
			 * (specified by the parameter)
			 * It passes imageId (= the user input) into the activity, tagged
			 * with the string content of EXTRA_IMAGEID
			 */
			Intent intent = new Intent(this, DisplayCommandActivity.class);
            // Send int for which images is pressed to DisplayCommandActivity
			intent.putExtra(EXTRA_IMAGEID, imageRef);
            // Send index for the truck map
            intent.putExtra(EXTRA_INDEX, index);
            // Send truck object pressed
            intent.putExtra("TruckObjects", truckObject);

            intent.putExtra("commandOne", command1);
            intent.putExtra("commandTwo", command2);
            intent.putExtra("commandThree", command3);

            startActivity(intent);
		}

        txtView.setText("TRUCK: " + Truck.getInstance().toString());
	}
}
