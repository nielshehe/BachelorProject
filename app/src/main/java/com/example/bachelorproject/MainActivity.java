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

public class MainActivity extends ActionBarActivity implements OnClickListener
{
	public final static String EXTRA_IMAGEID = "com.example.bachelorproject.IMAGEREF";

	private ImageButton btnTire, btnSteerWheel, btnCrane;
	private ImageView ivMain1, ivMain2, ivMain3, ivMain4;
	private ImageView ivMain5, ivMain6, ivMain7, ivMain8;
    private Helper help = new Helper();

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
		if (v.getId() == R.id.ibtnTire) imageId = R.drawable.daek;
		else if (v.getId() == R.id.ibtnSteerWheel) imageId = R.drawable.rat;
		else if (v.getId() == R.id.ibtnCrane) imageId = R.drawable.kran;

		// Set selected image on the "Start kran" image
		if (v.getId() == R.id.ibtnTire || v.getId() == R.id.ibtnSteerWheel
				|| v.getId() == R.id.ibtnCrane)
		{
			if (ivMain1.getDrawable() == null)
			{
                help.setImageAndTag(ivMain1, imageId);
			}
			else if (ivMain2.getDrawable() == null)
			{
                help.setImageAndTag(ivMain2, imageId);
			}
			else if (ivMain3.getDrawable() == null)
			{
                help.setImageAndTag(ivMain3, imageId);
			}
			else if (ivMain4.getDrawable() == null)
			{
                help.setImageAndTag(ivMain4, imageId);
			}
			else if (ivMain5.getDrawable() == null)
			{
                help.setImageAndTag(ivMain5, imageId);
			}
			else if (ivMain6.getDrawable() == null)
			{
                help.setImageAndTag(ivMain6, imageId);
			}
			else if (ivMain7.getDrawable() == null)
			{
                help.setImageAndTag(ivMain7, imageId);
			}
			else if (ivMain8.getDrawable() == null)
			{
                help.setImageAndTag(ivMain8, imageId);
			}
		}
		// When clicking on an image on the "Start kran" image
		else
		{
			int imageRef = help.getImageId((ImageView) v);
			
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

			startActivity(intent);
		}
	}
}
