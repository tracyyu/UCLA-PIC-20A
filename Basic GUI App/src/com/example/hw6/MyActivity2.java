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
import android.widget.RadioButton;
import android.widget.RatingBar;

public class MyActivity2 extends Activity{
	
	//each text category has it's own unique key
	public static final String NAME_KEY = "second.MyActivity2.MESSAGE.name";
	public static final String GENDER_KEY = "second.MyActivity2.MESSAGE.gender";
	public static final String AGE_KEY = "second.MyActivity2.MESSAGE.age";
	public static final String EMAIL_KEY = "second.MyActivity2.MESSAGE.email";
	public static final String PASSWORD_KEY = "second.MyActivity2.MESSAGE.password";
	public static final String RATE_KEY = "second.MyaActivity2.MESSAGE.rate";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myact2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_main, menu);
        return true;
    }
    
    //when click cancel button it sends you back to app home page
    public void addListenerOnCancel(View v){
        
     	Button register = (Button) findViewById(R.id.cancel_button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_click);
         
         register.setOnClickListener(new OnClickListener()
         {
         	public void onClick(View v)
         	{
         		startActivity(new Intent(MyActivity2.this,MyMainActivity.class));
         		mp.start();
         		
         	}
         });
    }
    
    //when click submit button it sends your input into a "created file" screen
    public void addListenerOnSubmit(View v){
        
     	Button register = (Button) findViewById(R.id.submit_button);
         
         register.setOnClickListener(new OnClickListener()
         {
         	public void onClick(View v)
         	{
         		//get the value from each text field and button
         		EditText name = (EditText) findViewById(R.id.name_editText);
         		String name_value = name.getText().toString();
         		
         		EditText age = (EditText) findViewById(R.id.number_editText);
         		String age_value = age.getText().toString();
         		
         		String gender_value;
         		RadioButton gender = (RadioButton) findViewById(R.id.male_radio);
         		if(gender.isSelected())
         		{
         			StringBuilder gender_string = new StringBuilder("Male");
         			gender_value = gender_string.toString();
         		}
         		else
         		{
         			StringBuilder gender_string = new StringBuilder("Female");
         			gender_value = gender_string.toString();
         		}
         		
         		EditText email = (EditText) findViewById(R.id.email_editText);
         		String email_value = email.getText().toString();
         		
         		EditText password = (EditText) findViewById(R.id.password_editText);
         		String password_value = password.getText().toString();
         		
         		RatingBar rate = (RatingBar) findViewById(R.id.ratingBar1);
         		float rate_value = rate.getRating();
         		
         		
         		//Store the values with the a unique key to send to activity 3
         		Intent activity2 = new Intent(MyActivity2.this,MyActivity3.class);
         		activity2.putExtra(NAME_KEY, name_value);
         		activity2.putExtra(GENDER_KEY, gender_value);
         		activity2.putExtra(AGE_KEY, age_value);
         		activity2.putExtra(EMAIL_KEY, email_value);
         		activity2.putExtra(PASSWORD_KEY, password_value);
         		activity2.putExtra(RATE_KEY, rate_value);
         		startActivity(activity2);
         	}
         });
    }
}
