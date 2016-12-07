package dk.unf.sdc.gruppee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class HowtoActivity extends Activity {

	private Button menuHowtoButton;
	private Button playHowtoButton;
	
	//private Intent intentMenu;
	private Intent intentPlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_howto);

		menuHowtoButton = (Button) findViewById(R.id.menuHowtoButton);
		playHowtoButton = (Button) findViewById(R.id.playHowtoButton);
		
		playHowtoButton.setOnClickListener(lPlayHowtoButton);
        menuHowtoButton.setOnClickListener(lMenuHowtoButton);
        

        intentPlay = new Intent(this,GameActivity.class);
	}

	private OnClickListener lMenuHowtoButton = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			//går tilbage til menuen og lukker denne aktivitet
			setResult(RESULT_OK);
			finish();
					

		}
	};
	private OnClickListener lPlayHowtoButton = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			//åbner play og lukker denne
			startActivityForResult(intentPlay,1);
			finish();
		

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_howto, menu);
		return true;
	}

}
