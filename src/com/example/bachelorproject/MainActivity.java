package com.example.bachelorproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
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
	}
}
