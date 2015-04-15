package com.example.bachelorproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DisplayCommandoActivity extends ActionBarActivity implements View.OnClickListener
{
	private ImageView ivObjectMain;
    private ImageView ivCommandoMain1, ivCommandoMain2, ivCommandoMain3;
    private ImageButton btnCommando1, btnCommando2, btnCommando3, btnCommando4;
    private Helper help = new Helper();

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
		int imageID = intent.getIntExtra(MainActivity.EXTRA_IMAGEID,
				R.drawable.startmain);

		if (imageID == R.drawable.daek)
        {
            help.setImageAndTag(ivObjectMain, R.drawable.daekmain);
            btnCommando1.setImageResource(R.drawable.daekop);
            btnCommando2.setImageResource(R.drawable.daekned);
        }
		else if (imageID == R.drawable.rat)
        {
            help.setImageAndTag(ivObjectMain, R.drawable.ratmain);
            btnCommando1.setImageResource(R.drawable.ratvenstre);
            btnCommando2.setImageResource(R.drawable.rathoejre);
        }
		else if (imageID == R.drawable.kran)
        {
            help.setImageAndTag(ivObjectMain, R.drawable.kranmain);
            btnCommando1.setImageResource(R.drawable.kranvenstre);
            btnCommando2.setImageResource(R.drawable.kranop);
            btnCommando3.setImageResource(R.drawable.kranned);
            btnCommando4.setImageResource(R.drawable.kranhoejre);
        }
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
            if (v.getId() == R.id.imagebtnCommando1) imageId = R.drawable.daekop;
            else if (v.getId() == R.id.imagebtnCommando2) imageId = R.drawable.daekned;
        }
        else if (help.getImageId(ivObjectMain) == R.drawable.ratmain)
        {
            if (v.getId() == R.id.imagebtnCommando1) imageId = R.drawable.ratvenstre;
            else if (v.getId() == R.id.imagebtnCommando2) imageId = R.drawable.rathoejre;
        }
        else if (help.getImageId(ivObjectMain) == R.drawable.kranmain)
        {
            if (v.getId() == R.id.imagebtnCommando1) imageId = R.drawable.kranvenstre;
            else if (v.getId() == R.id.imagebtnCommando2) imageId = R.drawable.kranop;
            else if (v.getId() == R.id.imagebtnCommando3) imageId = R.drawable.kranned;
            else if (v.getId() == R.id.imagebtnCommando4) imageId = R.drawable.kranhoejre;
        }

        // Set selected image on the map for the objects Tire, Steeringwheel and crane
        if (v.getId() == R.id.imagebtnCommando1 || v.getId() == R.id.imagebtnCommando2
                || v.getId() == R.id.imagebtnCommando3 || v.getId() == R.id.imagebtnCommando4)
        {
            if (ivCommandoMain1.getDrawable() == null)
            {
                help.setImageAndTag(ivCommandoMain1, imageId);
            }
            else if (ivCommandoMain2.getDrawable() == null)
            {
                help.setImageAndTag(ivCommandoMain2, imageId);
            }
            else if (ivCommandoMain3.getDrawable() == null)
            {
                help.setImageAndTag(ivCommandoMain3, imageId);
            }
        }
    }
}
