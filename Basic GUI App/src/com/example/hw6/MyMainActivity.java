package com.example.hw6;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyMainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_main, menu);
        return true;
    }
    
    //when click register button it sends you to new account screen
    public void addListenerOnRegister(View v){
        
     	Button register = (Button) findViewById(R.id.register_button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button_click);
         
         register.setOnClickListener(new OnClickListener()
         {
         	public void onClick(View v)
         	{
         		startActivity(new Intent(MyMainActivity.this,MyActivity2.class));
         		mp.start();
         	}
         });
    }
    
}
