package com.example.p33ejer2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] canciones = new String[10];
        String linea;
        int i = 0;
        
        try {
        	// open the file for reading
        	InputStream instream = new FileInputStream("/data/canciones.txt");

        	// if file the available for reading
        	if (instream != null) {
        	  // prepare the file for reading
        	  InputStreamReader inputreader = new InputStreamReader(instream);
        	  BufferedReader buffreader = new BufferedReader(inputreader);

        	  // read every line of the file into the line-variable, on line at the time
        	  linea=buffreader.readLine();
        	  do {
        	     canciones[i] = linea;
        	     Toast.makeText(getBaseContext(), canciones[i], Toast.LENGTH_SHORT).show();
        	     i++;
        	    // do something with the line 
        	     linea=buffreader.readLine();
        	  } while (linea != null);

        	}
        	instream.close();
        	
        	this.setListAdapter(new ArrayAdapter<String>(this, R.layout.mylist,
    				R.id.Itemname, canciones));
        	
        	} catch (Exception ex) {
        	    // print stack trace.
        	}
        
    }
}
