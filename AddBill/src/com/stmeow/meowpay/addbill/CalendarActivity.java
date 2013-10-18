package com.stmeow.meowpay.addbill;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class CalendarActivity extends Activity 
	implements OnDateChangeListener{
	
	private CalendarView calendar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		calendar = (CalendarView)findViewById(R.id.calendar1);
		calendar.setOnDateChangeListener(this);
	}

	@Override
	public void onSelectedDayChange(CalendarView view, int year, int month,
			int day) {
		Calendar user = new GregorianCalendar(year,month,day);
		String sDate = user.getTime().toString();
		Toast.makeText(this, sDate, Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("selectedDate", sDate);
		//Result code: 2001 -- user has made his selection. 
		setResult(2001, intent);
		finish();
	}

}
