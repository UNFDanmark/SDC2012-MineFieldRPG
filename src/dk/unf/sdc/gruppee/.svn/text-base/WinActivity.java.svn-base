package dk.unf.sdc.gruppee;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class WinActivity extends Activity {
	
	private Button menuYouwonButton; 
	private Button playAgainButton;
	private Button highscoreYouwonButton;
	
	private Intent intentMenuYouwon;
	private Intent intentPlayAgain;
	private Intent intentHighscoreYouwon;
	private int deaths;
	
	private TextView timeLong;
	private TextView pointInt;
	private TextView deathsInt;
	
	private Score score;
	
	private int sizeMorePoints;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Laver fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        long time = intent.getLongExtra("timeid", 1);
        deaths = intent.getIntExtra("deathid", 0);
        int easy = intent.getIntExtra("easyid", 0);
        int size = intent.getIntExtra("sizeid", 0);
        

        
        setContentView(R.layout.activity_win);
        //Linker knapper
        menuYouwonButton = (Button) findViewById(R.id.menuYouwonButton);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        highscoreYouwonButton = (Button) findViewById(R.id.highscoreYouwonButton);
        timeLong = (TextView) findViewById(R.id.timeInt);
        pointInt = (TextView) findViewById(R.id.pointInt);
        deathsInt = (TextView) findViewById(R.id.deathsInt);
        timeLong.setText(Long.toString(time));
        deathsInt.setText("" + deaths);
        

        
        long points = (100000/(time+(deaths*2))*Game.getMapSize());
        pointInt.setText("" + points);
        
        //(int point, int difficulty, int size)
        score = new Score((int) points, easy, size);
        ScoreDatabase database = new ScoreDatabase(getApplicationContext());
        database.saveScore(score);
        
        //knapper kobles til skærmklik
        menuYouwonButton.setOnClickListener(lMenuYouwonButton);
        playAgainButton.setOnClickListener(lPlayAgainButton);
        highscoreYouwonButton.setOnClickListener(lHighscoreYouwonButton);
        
        // opretter intent, og fortæller hvad de skal "linke" til
        intentMenuYouwon = intent;
        intentPlayAgain = new Intent(this,GameActivity.class);
        intentHighscoreYouwon = new Intent(this,HighscoreActivity.class);
        
        
    }
    
    
    
    
    
    //tager i mod klik
 private OnClickListener lMenuYouwonButton = new OnClickListener() {
		
		public void onClick(View v) {
			
			//sender svar tilbage til menu, ved klik på menu knap, og lukker aktiviten
			setResult(RESULT_OK);
			finish();
			
			
		}
	};
	
	 private OnClickListener lPlayAgainButton = new OnClickListener() {
			
			public void onClick(View v) {
				// sender besked til game aktiviteten, og åbner denne. lukker herefter win
				startActivityForResult(intentPlayAgain, 1);
				finish();
			
				
			}
		};
		
		 private OnClickListener lHighscoreYouwonButton = new OnClickListener() {
				
				public void onClick(View v) {
					// sender besked til highscore og åbner denne, lukker derefter win
					startActivityForResult(intentHighscoreYouwon, 1);
					finish();
					
					
				}
			};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_win, menu);
        return true;
    }

    
}
