package com.mytest.anytools;

import android.content.Context;

import com.mytest.anytools.model.Settings;

public interface IAnyTools {

	public abstract Settings getSettings();
	
	public abstract void setSettings(Settings set);
	
	
	/* activity跳转函数 */
	public abstract void gotoWeatherActivity(Context context);
	
	public abstract void gotoSettingsActivity(Context context);
	
}
