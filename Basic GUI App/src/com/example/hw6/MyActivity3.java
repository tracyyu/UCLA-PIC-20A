package com.example.hw6;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MyActivity3 extends Activity{
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myact3);
        
        //Retrieve all the data from activity2
        Intent intent = getIntent();
        String name = intent.getStringExtra(MyActivity2.NAME_KEY);
        String age = intent.getStringExtra(MyActivity2.AGE_KEY);
        String gender = intent.getStringExtra(MyActivity2.GENDER_KEY);
        String email = intent.getStringExtra(MyActivity2.EMAIL_KEY);
        String password = intent.getStringExtra(MyActivity2.PASSWORD_KEY);
        float rating = intent.getExtras().getFloat(MyActivity2.RATE_KEY);
        
        //set all the editText to the appropriate values
        EditText name_value = (EditText) findViewById(R.id.editText1);
    	name_value.setText(name);
    	name_value.setEnabled(false);
    	
        EditText age_value = (EditText) findViewById(R.id.editText2);
        int age_number = Integer.parseInt(age);
    	age_value.setText(age_number);
    	age_value.setEnabled(false);
    	
        EditText gender_value = (EditText) findViewById(R.id.editText3);
    	gender_value.setText(gender);
    	gender_value.setEnabled(false);
    	
        EditText email_value = (EditText) findViewById(R.id.editText4);
    	email_value.setText(email);
    	email_value.setEnabled(false);
    	
        EditText password_value = (EditText) findViewById(R.id.editText5);
    	password_value.setText(password);
    	password_value.setEnabled(false);
    	
    	RatingBar rate = (RatingBar) findViewById(R.id.ratingBar1);
    	rate.setRating(rating);
        rate.setEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_main, menu);
        return true;
    }
    
    //when click ok button it sends you back to the beginning
    public void addListenerOnOk(View v){
        
     	Button register = (Button) findViewById(R.id.register_button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_click);
         
         register.setOnClickListener(new OnClickListener()
         {
         	public void onClick(View v)
         	{
         		startActivity(new Intent(MyActivity3.this,MyMainActivity.class));
         		mp.start();
         	}
         });
    }
}
