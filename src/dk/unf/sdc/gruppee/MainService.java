package dk.unf.sdc.gruppee;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MainService extends Service {
	private Context soundContext;
	private MediaPlayer mediaPlayer;
	private boolean onoff = true;
	
	// funktioner til styring af lyd

	public void playSound (){
//		mediaPlayer.setLooping(true);
		mediaPlayer.start();
	}
	public void stopSound(){
		mediaPlayer.pause();
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//finder lydfilen
	public void onCreate()
	{
		super.onCreate();
		mediaPlayer = MediaPlayer.create(this, R.raw.steelandseething);
	}
	
	//styre lyden, afhænging af onof status
	public int onStartCommand(Intent intent, int flags, int startid)
	{
		Log.d("testy", "shitworks");
		onoff = intent.getBooleanExtra("onoffId", true);
		
		 if (onoff){
			 
			 mediaPlayer.start();
			 mediaPlayer.setLooping(onoff);

			 onoff=false;
			 
			 
		 }
		 
		 else if(!onoff){
			 mediaPlayer.pause();
			 onoff=true;
		 }
		
		
		
		return START_STICKY;
	}
	
	
	
	
}

