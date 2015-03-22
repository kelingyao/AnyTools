package com.mytest.anytools;

import java.nio.MappedByteBuffer;

import com.mytest.anytools.activities.WeatherActivity;
import com.mytest.anytools.model.Settings;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

public class AnyTools extends Application implements IAnyTools{
	
	private static String CLASS_NAME;
	private Settings settings;

	public AnyTools()
	{
		CLASS_NAME = getClass().getName();
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		
	}

	@Override
	public Settings getSettings() {
		if (null == settings)
		{
			settings = new Settings();
		}
		return settings;
	}

	@Override
	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	@Override
	public void gotoWeatherActivity(Context context)
	{
		Intent intent = new Intent(context, WeatherActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void gotoSettingsActivity(Context context)
	{
		Intent intent = new Intent(context, WeatherActivity.class);
		startActivity(intent);
	}
	
}
