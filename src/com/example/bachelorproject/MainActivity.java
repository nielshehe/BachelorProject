package com.example.bachelorproject;

import android.support.v7.app.ActionBarActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity implements OnClickListener
{
	private ImageButton btnTire, btnSteerWheel, btnCrane;
	private ImageView ivMain, ivMain1, ivMain2, ivMain3, ivMain4;
	private ImageView ivMain5, ivMain6, ivMain7, ivMain8;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// Sets theme and layout for activity
		setTheme(android.R.style.Theme_Light_NoTitleBar_Fullscreen);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		// setContentView(R.layout.activity_main);
		setContentView(R.layout.activity_main_view);

		btnTire = (ImageButton) findViewById(R.id.ibtnTire);
		btnTire.setOnClickListener(this);
		btnSteerWheel = (ImageButton) findViewById(R.id.ibtnSteerWheel);
		btnSteerWheel.setOnClickListener(this);
		btnCrane = (ImageButton) findViewById(R.id.ibtnCrane);
		btnCrane.setOnClickListener(this);

		ivMain = (ImageView) findViewById(R.id.imageMain);
		ivMain1 = (ImageView) findViewById(R.id.imageMain1);
		ivMain2 = (ImageView) findViewById(R.id.imageMain2);
		ivMain3 = (ImageView) findViewById(R.id.imageMain3);
		ivMain4 = (ImageView) findViewById(R.id.imageMain4);
		ivMain5 = (ImageView) findViewById(R.id.imageMain5);
		ivMain6 = (ImageView) findViewById(R.id.imageMain6);
		ivMain7 = (ImageView) findViewById(R.id.imageMain7);
		ivMain8 = (ImageView) findViewById(R.id.imageMain8);
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
		int imageId = 0;
		if (v.getId() == R.id.ibtnTire) imageId = R.drawable.daek;
		else if (v.getId() == R.id.ibtnSteerWheel) imageId = R.drawable.rat;
		else if (v.getId() == R.id.ibtnCrane) imageId = R.drawable.kran;

		if (ivMain1.getDrawable() == null) ivMain1.setImageResource(imageId);
		else if (ivMain2.getDrawable() == null) ivMain2
				.setImageResource(imageId);
		else if (ivMain3.getDrawable() == null) ivMain3
				.setImageResource(imageId);
		else if (ivMain4.getDrawable() == null) ivMain4
				.setImageResource(imageId);
		else if (ivMain5.getDrawable() == null) ivMain5
				.setImageResource(imageId);
		else if (ivMain6.getDrawable() == null) ivMain6
				.setImageResource(imageId);
		else if (ivMain7.getDrawable() == null) ivMain7
				.setImageResource(imageId);
		else if (ivMain8.getDrawable() == null) ivMain8
				.setImageResource(imageId);
	}
}
