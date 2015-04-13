package com.example.bachelorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class DisplayCommandoActivity extends ActionBarActivity
{
	private ImageView ivObjectMain;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_display_commando);

		ivObjectMain = (ImageView) findViewById(R.id.imageObjectMain);

		/*
		 * It reads the value that was set for EXTRA_IMAGEID in the intent used
		 * to
		 * start the activity.
		 * Hence, imageID now contains the user-selected value
		 * (or DIFFICULTY_EASY, if the activity is started through a different
		 * intent which did not set KEY_DIFFICULTY).
		 */
		Intent intent = getIntent();
		int imageID = intent.getIntExtra(MainActivity.EXTRA_IMAGEID,
				R.drawable.startmain);

		if (imageID == R.drawable.daek) ivObjectMain
				.setImageResource(R.drawable.daekmain);
		else if (imageID == R.drawable.rat) ivObjectMain
				.setImageResource(R.drawable.ratmain);

		else if (imageID == R.drawable.kran) ivObjectMain
				.setImageResource(R.drawable.kranmain);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_commando, menu);
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
	
	
}
