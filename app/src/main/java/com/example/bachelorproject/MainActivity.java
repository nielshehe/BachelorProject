package com.example.bachelorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import dk.sdu.bachelorf15.domain.TruckController;
import dk.sdu.bachelorf15.help.Helper;
import dk.sdu.bachelorf15.help.TruckObjects;

public class MainActivity extends ActionBarActivity implements OnClickListener
{
	public final static String EXTRA_IMAGEID = "com.example.bachelorproject.IMAGEREF";
    public final static String EXTRA_INDEX = "com.example.bachelorproject.INDEX";

	private ImageButton btnTire, btnSteerWheel, btnCrane;
	private ImageView ivMain1, ivMain2, ivMain3, ivMain4;
	private ImageView ivMain5, ivMain6, ivMain7, ivMain8;
    private Helper help = new Helper();

    private TruckObjects truckObject;

    // TODO TEST TRUCK AND MAP
    private TextView txtView;
    private int index = 0;

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

        // Create a new Truck
        TruckController.getInstance();

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
                TruckController.getInstance().addObject(index, truckObject);
			}
			else if (ivMain2.getDrawable() == null)
			{
                help.setImageAndTag(ivMain2, imageId);
                index = 2;
                TruckController.getInstance().addObject(index, truckObject);
            }
			else if (ivMain3.getDrawable() == null)
			{
                help.setImageAndTag(ivMain3, imageId);
                index = 3;
                TruckController.getInstance().addObject(index, truckObject);
			}
			else if (ivMain4.getDrawable() == null)
			{
                help.setImageAndTag(ivMain4, imageId);
                index = 4;
                TruckController.getInstance().addObject(index, truckObject);
			}
			else if (ivMain5.getDrawable() == null)
			{
                help.setImageAndTag(ivMain5, imageId);
                index = 5;
                TruckController.getInstance().addObject(index, truckObject);
			}
			else if (ivMain6.getDrawable() == null)
			{
                help.setImageAndTag(ivMain6, imageId);
                index = 6;
                TruckController.getInstance().addObject(index, truckObject);
			}
			else if (ivMain7.getDrawable() == null)
			{
                help.setImageAndTag(ivMain7, imageId);
                index = 7;
                TruckController.getInstance().addObject(index, truckObject);
			}
			else if (ivMain8.getDrawable() == null)
			{
                help.setImageAndTag(ivMain8, imageId);
                index = 8;
                TruckController.getInstance().addObject(index, truckObject);
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

			/*
			 * creates an intent which, when executed with startActivity, does
			 * two things:
			 * It starts a new activity of class DisplayCommandoActivity
			 * (specified by the parameter)
			 * It passes imageId (= the user input) into the activity, tagged
			 * with the string content of EXTRA_IMAGEID
			 */
			Intent intent = new Intent(this, DisplayCommandoActivity.class);
			intent.putExtra(EXTRA_IMAGEID, imageRef);
            intent.putExtra(EXTRA_INDEX, index);

			startActivity(intent);
		}
        txtView.setText("TRUCK: " + TruckController.getInstance().toString());
	}
}
