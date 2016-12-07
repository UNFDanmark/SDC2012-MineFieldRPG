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
import android.widget.TextView;

public class MenuActivity extends Activity {
	
	private Button playButton;
	private Button exitButton;
	private Button howtoButton;
	private Button optionsButton;
	private Button highscoreButton;
	
	private TextView titleTxt;
	private TextView unterTitleTxt;
	
	private Intent intentPlay;
	private Intent intentHowto;
	private Intent intentOptions;
	private Intent intentHighscore;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        // sætter menu til fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_minefield);
        

        
        playButton = (Button) findViewById(R.id.playButton);
        exitButton = (Button) findViewById(R.id.exitButton);
        howtoButton = (Button) findViewById(R.id.howtoButton);
        optionsButton = (Button) findViewById(R.id.optionsButton);
        highscoreButton = (Button) findViewById(R.id.highscoreButton);
        

        
        
        
        playButton.setOnClickListener(lPlayButton);
        exitButton.setOnClickListener(lExitButton);
        howtoButton.setOnClickListener(lHowtoButton);
        optionsButton.setOnClickListener(lOptionsButton);
        highscoreButton.setOnClickListener(lHighscoreButton);
        
        intentPlay = new Intent(this,GameActivity.class);
        intentHowto = new Intent(this,HowtoActivity.class);
        intentOptions = new Intent(this,OptionsActivity.class);
        intentHighscore = new Intent(this,HighscoreActivity.class);

        
    }

    private OnClickListener lPlayButton = new OnClickListener() {
    	// når knappen play trykkes sender vi besked til gameactvity om at starte
		
		public void onClick(View v) {
			
			 
			startActivityForResult(intentPlay, 1);
			
		}
	};
	
	private OnClickListener lHighscoreButton = new OnClickListener() {
    	
		
		public void onClick(View v) {
			
			 
			startActivityForResult(intentHighscore, 1);
			
		}
	};
	
	  private OnClickListener lExitButton = new OnClickListener() {
			// afslutter appen ved tryk på exitactvity om at starte
			public void onClick(View v) {

				 finish();
				
				
			}
		};
		
		private OnClickListener lHowtoButton = new OnClickListener() {
			//når knappen  how to play trykkes sender vi besked til howtoactvity om at starte
			public void onClick(View v) {
			
				startActivityForResult(intentHowto, 1);
				
			}
		};
		
		private OnClickListener lOptionsButton = new OnClickListener() {
			//når knappen options trykkes sender vi besked til optionsactvity om at starte
			public void onClick(View v) {
				
				 
				startActivityForResult(intentOptions,1);

			}
		};
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu2, menu);
        return true;
    }

    
}
