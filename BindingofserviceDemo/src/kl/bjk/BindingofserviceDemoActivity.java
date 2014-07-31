package kl.bjk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BindingofserviceDemoActivity extends Activity {
	Button button, button2, button3, button4;
	Intent intent;
	EditText e1;
	
	ServiceConnection connection;
	MyInterface myInterface;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button= (Button)findViewById(R.id.button1);
        button2= (Button)findViewById(R.id.button2);
        button3= (Button)findViewById(R.id.button3);
        button4= (Button)findViewById(R.id.button4);
		e1=(EditText)findViewById(R.id.editText1);

        connection= new ServiceConnection() {
			
			public void onServiceDisconnected(
					ComponentName arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onServiceConnected(
					ComponentName arg0, IBinder arg1) {
				// TODO Auto-generated method stub
				myInterface= (MyInterface)arg1;
			}
		};
        intent= new Intent(
        		BindingofserviceDemoActivity.this,
        		MyServices.class);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(intent);	
			}
		});
        
        button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			bindService(intent, connection, BIND_AUTO_CREATE);	
			}
		});
        
        button3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int values= myInterface.getCount();
				Toast.makeText(getApplicationContext(),
               "Count is "+values, 3000).show();
				
			}
		});
        button4.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
        
    }
}