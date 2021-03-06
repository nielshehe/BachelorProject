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

public class MainActivity extends ActionBarActivity implements OnClickListener
{
	public final static String EXTRA_IMAGEID = "com.example.bachelorproject.IMAGEREF";

	private ImageButton btnTire, btnSteerWheel, btnCrane;
	private ImageView ivMain1, ivMain2, ivMain3, ivMain4;
	private ImageView ivMain5, ivMain6, ivMain7, ivMain8;

	ImageButton btnPlay;
	ImageView imgCar;
	ImageView imgField;
	ImageButton btnIcon;
	
	int numberOfTiles = 5;
	double halfTileSize;
	
	double[] fieldArrX = new double[numberOfTiles];
	double[] fieldArrY = new double[numberOfTiles];
	
	float xDir;
	
	// TESTING //

	int helperX = 0;
	int helperY = 0;
	
	// ------- //
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		// setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main_view);

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
		
		xDir = 50f;
		
		imgCar = (ImageView) findViewById(R.id.imageCar);
		
		imgField = (ImageView) findViewById(R.id.imageField);
		
		btnPlay = (ImageButton) findViewById(R.id.btnPlay);
		btnPlay.setOnClickListener(this);
		
		btnIcon = (ImageButton) findViewById(R.id.btnIcon);
		btnIcon.setOnClickListener(new OnClickListener() 
		{
			@Override
            public void onClick(View view) 
			{
				System.out.println("Button Icon Clicked");
				imgCar.setRotation(imgCar.getRotation() + 90);
				
				if(imgCar.getRotation() == 360)
				System.out.println(imgCar.getRotation());
            }
 
        });

	}
	
	 public void onWindowFocusChanged(boolean hasFocus) 
	 {	  
		  super.onWindowFocusChanged(hasFocus);
		  
		  initFieldArray();
	 }

	private void initFieldArray() {
		halfTileSize = imgField.getWidth() / numberOfTiles / 2;
		
		double startX = imgField.getLeft();
		double startY = imgField.getTop();
		double tempHalfTileSize = halfTileSize;
		
		for (int n = 0; n < numberOfTiles; n++)
		{
			fieldArrX[n] = startX + tempHalfTileSize;
			fieldArrY[n] = startY + tempHalfTileSize;

			tempHalfTileSize += halfTileSize * 2;
		}
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
			Log.i("MainActivity", "------ IMAGEID BUTTONS: " + imageId);

			if (ivMain1.getDrawable() == null)
			{
				ivMain1.setImageResource(imageId);
	public void onClick(View v) {
		imgCar.setX((float) (fieldArrX[helperX]) - imgCar.getWidth()/2);
		imgCar.setY((float) (fieldArrY[helperY]) - imgCar.getHeight()/2);
		
		if(helperX < 4) 
		{
			helperX++;
		}
		else 
		{
			helperX = 0;
			
			if(helperY < 4)
			helperY++;
			
			else helperY = 0;
		}
				ivMain1.setTag(imageId);
			}
			else if (ivMain2.getDrawable() == null)
			{
				ivMain2.setImageResource(imageId);
				ivMain2.setTag(imageId);
			}
			else if (ivMain3.getDrawable() == null)
			{
				ivMain3.setImageResource(imageId);
				ivMain3.setTag(imageId);
			}
			else if (ivMain4.getDrawable() == null)
			{
				ivMain4.setImageResource(imageId);
				ivMain4.setTag(imageId);
			}
			else if (ivMain5.getDrawable() == null)
			{
				ivMain5.setImageResource(imageId);
				ivMain5.setTag(imageId);
			}
			else if (ivMain6.getDrawable() == null)
			{
				ivMain6.setImageResource(imageId);
				ivMain6.setTag(imageId);
			}
			else if (ivMain7.getDrawable() == null)
			{
				ivMain7.setImageResource(imageId);
				ivMain7.setTag(imageId);
			}
			else if (ivMain8.getDrawable() == null)
			{
				ivMain8.setImageResource(imageId);
				ivMain8.setTag(imageId);
			}
		}
		// When clicking on an image on the "Start kran" image
		else
		{
			int imageRef = getImageViewId((ImageView) v);
			Log.i("MainActivity", "------ IMAGEID IMAGES: " + imageRef);
			
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

	// Method to get the image from the ImageView
	public int getImageViewId(ImageView v)
	{
		return (Integer) v.getTag();
	}
}
