package com.stmeow.meowpay.addbill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements 
		CompoundButton.OnCheckedChangeListener {
	private CheckBox cb;
	private TextView amount;
	private EditText selectedDate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		cb = (CheckBox)findViewById(R.id.amountVariesChk);
		cb.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		amount = (TextView)findViewById(R.id.aboutLabel);
		if (arg1)
			amount.setVisibility(View.VISIBLE);
		else
			amount.setVisibility(View.INVISIBLE);
	}
	
	public void chooseDate(View view) {
		Intent intent = new Intent(this, CalendarActivity.class);
		//Request code: 1001 -- waiting for user's selection
		startActivityForResult(intent,1001);
	}
	
	public void onActivityResult(int request, int result, Intent data) {
		if (request == 1001) {
			if (result == 2001) {
				selectedDate = (EditText)findViewById(R.id.selectedDate);
				String uDate = data.getStringExtra("selectedDate");
				selectedDate.setText(uDate, TextView.BufferType.EDITABLE);
			}
		}
	}
}
