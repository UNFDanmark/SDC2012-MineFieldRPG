package dk.unf.sdc.gruppee;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class HighscoreActivity extends Activity {
	
	private Button difficultyButton;
	private Button sizeButton;
	private Button menuHighscoreButton;
	
	private int size;
	private int diff;
	
    private ScoreDatabase database;
    
	private TextView difficultyText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_highscore);
        

		menuHighscoreButton = (Button) findViewById(R.id.menuHighscoreButton);
				
		menuHighscoreButton.setOnClickListener(lmenuHighscore);
		
        Intent intent = getIntent();
        long time = intent.getLongExtra("timeid", 0);
        int deaths = intent.getIntExtra("deathid", 0);
        int easy = intent.getIntExtra("easyid", 0);
        int size = intent.getIntExtra("sizeid", 0);
		diff = easy;
		
		database = new ScoreDatabase(getApplicationContext());
		List<Score> scores = database.getScores( diff,size);

		List<TextView> scoreViews = new ArrayList<TextView>();
		scoreViews.add((TextView) findViewById(R.id.score1));
		scoreViews.add((TextView) findViewById(R.id.score2));
		scoreViews.add((TextView) findViewById(R.id.score3));
		scoreViews.add((TextView) findViewById(R.id.score4));
		scoreViews.add((TextView) findViewById(R.id.score5));
		
        for (int j=0; j<scores.size() && j<scoreViews.size(); j++) {
        	TextView v = scoreViews.get(j);
        	Score s = scores.get(j);
        	v.setText(String.valueOf(s.getPoint()));
        }
    }
    

	private OnClickListener lmenuHighscore = new OnClickListener() {

		public void onClick(View v) {

			setResult(RESULT_OK);
			finish();
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_highscore, menu);
        return true;
    }

    
}
