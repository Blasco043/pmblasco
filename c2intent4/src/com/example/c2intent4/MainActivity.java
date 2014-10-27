package com.example.c2intent4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    int request_Code = 1;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View view) {
        
       Intent i = new Intent("PassingDataSecondActivity");
	    //startActivity(intent);
       i.putExtra("str1", "this is a string");
       i.putExtra("age1", 25);
       
       //usar bundle
       Bundle extras=new Bundle();
       
       
       extras.putString("str2","this is another string");
       extras.putInt("age2", 35);
       
       i.putExtras(extras);
       
       startActivityForResult(i,1);
    }
    public void onActivityResult(int requestCode, 
    		int resultCode, Intent data)
    {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
            	Toast.makeText(this,
            	          Integer.toString(data.getIntExtra("age3",0)),
            	                    Toast.LENGTH_SHORT).show();
            	Toast.makeText(this,data.getData().toString(),
            						Toast.LENGTH_SHORT).show();
            }
        }

    }
}
