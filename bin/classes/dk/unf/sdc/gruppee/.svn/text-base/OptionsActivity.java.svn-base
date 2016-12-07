package dk.unf.sdc.gruppee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class OptionsActivity extends Activity {
	
	private Button soundButton;
	private Button easyButton;
	private Button normalButton;
	private Button menuOptionsButton;
	private Button changeSizeButton;
	
	private TextView sizeText;
	private TextView soundTxt;
	private TextView difficultyTxt;
	private TextView difficultyStatus;
	private String status;
		
	private Intent menuOptionsIntent;
	//private Sound music;
	
	private Boolean onoff=true;
	private Intent intentNormal;
	
	private String PREF_FILE = "preferences";
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	
	private MediaPlayer mPlayer;
	
	private int sizeCount;
	
	private String soundStatus= "Off";
	


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_options);
        
        //sætter knapperne fast på layout knapperne
        soundButton = (Button) findViewById(R.id.soundButton);
        easyButton = (Button) findViewById(R.id.easyButton);
        normalButton = (Button) findViewById(R.id.normalButton);
        menuOptionsButton = (Button) findViewById(R.id.menuOptionsButton);
        changeSizeButton = (Button) findViewById(R.id.changesizebutton_);
        difficultyStatus =(TextView) findViewById(R.id.difficultyStatus);
        sizeText = (TextView) findViewById(R.id.sizetext);
        
        //sætter en knap til et indput fra tryk på skærm
        soundButton.setOnClickListener(lSound);
        easyButton.setOnClickListener(lEasy);
        normalButton.setOnClickListener(lNormal);
        menuOptionsButton.setOnClickListener(lMenuOptions);
        changeSizeButton.setOnClickListener(lChangeSize);
        
        
        
        if(Game.getMapSize() == 1){
        	sizeText.setText("Small (7*11)");
        }
        if(Game.getMapSize() == 2){
        	sizeText.setText("Medium (9*13)");
        	}
        if(Game.getMapSize() == 3){
        	sizeText.setText("Large (11*15)");
        }
        sizeCount = Game.getMapSize();

        // henter oplysninger om lyd status og sværhedsgrad
        intentNormal = new Intent(this,GameActivity.class);
        sharedPreferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        onoff = sharedPreferences.getBoolean("buko", true);
        
        status = sharedPreferences.getString("statusString", "Normal");
        difficultyStatus.setText(status);
        
        //skriver tekst på lys knap, alt efter status
        if (onoff){
        	soundStatus="Off";
        }
        else {
        	soundStatus="On";
        }
        
        soundButton.setText(soundStatus);
        
        
        

    }
// tjekker for klik
    private OnClickListener lSound = new OnClickListener() { // her laves onclick listener for lyd knappen
		
		public void onClick(View v) {

			
			 if (onoff){
//hvis knappen er trykket på gemmer vi oplysninger om lys er on eller off 
				 Intent musicOn = new Intent(getApplicationContext(), MainService.class);
				 musicOn.putExtra("onoffId", onoff);
				 startService(musicOn);
				 onoff=false;
				 soundStatus="On";
				 sharedPreferences= getSharedPreferences(PREF_FILE, MODE_PRIVATE);
				 editor= sharedPreferences.edit();
				 editor.putBoolean("buko", onoff);
				 editor.commit();
				 soundButton.setText(soundStatus);
				 
			 }
			 
			 else if(!onoff){

				 Intent musicOff = new Intent(getApplicationContext(), MainService.class);
				 musicOff.putExtra("onoffId", onoff);
				 startService(musicOff);
				 onoff=true;
				 soundStatus="Off";
				 sharedPreferences= getSharedPreferences(PREF_FILE, MODE_PRIVATE);
				 editor= sharedPreferences.edit();
				 editor.putBoolean("buko", onoff);
				 editor.commit();
				 soundButton.setText(soundStatus);
			 }
	
			
		}
	};

	
	
	
    private OnClickListener lEasy = new OnClickListener() {
		
		public void onClick(View v) {
			// ved klik på easy, vi ændre statussen og gemmer denne
			status="Easy";
			 difficultyStatus.setText(status);
			 Game.easyMode();
			 
			 
			 
			 sharedPreferences= getSharedPreferences(PREF_FILE, MODE_PRIVATE);
			 editor= sharedPreferences.edit();
			 editor.putString("statusString", status);
			 editor.commit();
			
			
			
		}
	};
	
    private OnClickListener lNormal = new OnClickListener() {
		
		public void onClick(View v) {
			// ved klik på normal ændres status og denne gemmes
			status="Normal";
			difficultyStatus.setText(status);
			
			 sharedPreferences= getSharedPreferences(PREF_FILE, MODE_PRIVATE);
			 editor= sharedPreferences.edit();
			 editor.putString("statusString", status);
			 editor.commit();
			Game.normalMode();
			
			
			
		}
	};
	
    private OnClickListener lMenuOptions = new OnClickListener() {
		
		public void onClick(View v) {

			
		
			//sender svar tilbage til menu, og lukker sig selv
			
		setResult(RESULT_OK);
		
		finish();
			
		}
	};
    
	private OnClickListener lChangeSize = new OnClickListener() {
		
		public void onClick(View v) {
			if(sizeCount <= 2){
				sizeCount += 1;
			}else{
				sizeCount =1;
			}
			if (sizeCount == 1){
				sizeText.setText("Small (7*11)");
				Game.size(1);
				
			}
			if (sizeCount == 2){
				sizeText.setText("Medium (9*13)");
				Game.size(2);
			}
			if (sizeCount == 3){
				sizeText.setText("Large (11*15)");
				Game.size(3);
			}
		
		}	
	};
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_options, menu);
        return true;
    }

    
}
