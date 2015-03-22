package com.mytest.anytools.activities;

import com.mytest.anytools.IAnyTools;
import com.mytest.anytools.R;
import com.mytest.anytools.R.layout;
import com.mytest.anytools.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private static String CLASS_NAME;
	private Context mContext;
	private IAnyTools mMyApp;
	
	private ImageButton ibtnWeather;
	private ImageButton ibtnSettings;
	
	public MainActivity()
	{
		CLASS_NAME = getClass().getName();
		mContext = MainActivity.this;
		mMyApp = (IAnyTools) getApplication();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initialView();
	}

	private void initialView()
	{
		ibtnWeather = (ImageButton) findViewById(R.id.ibtn_weather);
		ibtnSettings = (ImageButton) findViewById(R.id.ibtn_settings);
		
		OnClickListener onClkLtn = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switch (v.getId())
				{
					case R.id.ibtn_weather:
						
						break;
						
					case R.id.ibtn_settings:
						
						break;
				}
			}
		};
		
		ibtnWeather.setOnClickListener(onClkLtn);
		ibtnSettings.setOnClickListener(onClkLtn);
	}

}
