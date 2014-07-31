package kl.bjk;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.webkit.WebView.FindListener;
import android.widget.EditText;
import android.widget.Toast;

public class MyServices extends Service{
	int count= Integer.parseInt(new BindingofserviceDemoActivity().e1.getText().toString());
	Handler handler;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "onBind", 3000).show();
		return new MyBinder();
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(getApplicationContext(), "onCreate", 3000).show();
		handler= new Handler();
		handler.postDelayed(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				count--;
				new Handler().postDelayed(this, 1000);
				if(count==0){
					Toast.makeText(getApplicationContext(),"Count finished", 3000).show();
				
				}
			}
		}, 3000);
	}
	

		

	class MyBinder extends Binder implements MyInterface{

		public int getCount() {
			// TODO Auto-generated method stub
			return count;
		}
		
		
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "onDestroy", 3000).show();
		
	}
	
	
	

}
