package com.example.threads;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
EditText e1;
TextView view1,view2;
Button b1;
Handler h;
Runnable r,c;
boolean cg = true;
int[] colors = {Color.GREEN,Color.RED};
int data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText1);
        view1=(TextView)findViewById(R.id.textView1);
        view2=(TextView)findViewById(R.id.textView2);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				h = new Handler();
				data = Integer.parseInt(e1.getText().toString());
				r = new Runnable(){
                     @Override
                     public void run() {
                             // TODO Auto-generated method stub
                             if(data > -1){
                                     view1.setText(String.valueOf(data));
                                     data = data - 1;
                                     view2.setText(String.valueOf(data));
                                     data = data - 1;
                                     h.postDelayed(this, 1000);
                             }
                     }
     };        
     			c = new Runnable(){
     			@Override
     		public void run() {
                 // TODO Auto-generated method stub
                 if(cg){
                         view1.setTextColor(Color.GREEN);
                         view2.setTextColor(Color.RED);
                         cg=false;
                 }
                 else{
                     view1.setTextColor(Color.RED);
                     view2.setTextColor(Color.BLUE);
                     cg= true;
             }
                 h.postDelayed(this, 1000);
         }
};  
	h.post(r);
	h.post(c);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
