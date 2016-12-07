package dk.unf.sdc.gruppee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class GameActivity extends Activity {
	/** Called when the activity is first created. */
	DrawView drawView;

	Point size = new Point();

	private int width;
	private int height;
	private Game game;
	private Intent intentYouwonGame;
	BitmapDrawable mBitmap;
	BitmapDrawable manBitmap;
	BitmapDrawable mineBitmap;
	private ViewThread mThread;
	private int rowsX;
	private int columnsY;
	private boolean timeStartCheck=true;
	private long startTime=0;
	private long estimatedTime=0;
	

	// til Swipe funktionen!
	private float touchStartX = 0;
	private float touchStartY = 0;
	private float touchEndX = 0;
	private float touchEndY = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) { // når interfaset for
														// spillet bliver lavet
														// gør den baggrunden
														// hvid
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		game = new Game(this);
		// drawView = new DrawView(this);
		// drawView.setBackgroundColor(Color.WHITE);
		setContentView(new DrawView(this));
		rowsX = game.getRowsX();
		columnsY = game.getColumnsY();
		intentYouwonGame = new Intent(this, WinActivity.class);
		
	}
	
	

	class DrawView extends SurfaceView implements SurfaceHolder.Callback {
		Paint paint = new Paint(); // vi kalder paint
		Paint paintMine = new Paint(); // vi kalder paintMine
		Paint txtPaint = new Paint();
		Paint paintLine = new Paint();
		
		public DrawView(Context context) {
			super(context);
			paint.setColor(Color.BLACK); // vi sætter farven på paint til sort
			paintLine.setColor(Color.GRAY);
			paintMine.setColor(Color.RED);
			txtPaint.setColor(Color.BLACK);
			txtPaint.setTextSize(30);
			getHolder().addCallback(this);
			mThread = new ViewThread(this);
			mBitmap = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.game));
			manBitmap = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.man));
			mineBitmap = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.skull));
		}

		@Override
		public void onDraw(Canvas canvas) {
			super.onDraw(canvas);			
						
			mBitmap.draw(canvas);
			
			 
			// Her laver vi de vertikale streger i spillet
			for (int i = 1; i <= rowsX - 1; i++) {
				canvas.drawLine((width / rowsX) * i, height / columnsY, (width / rowsX) * i, height / columnsY * (columnsY-1), paintLine);
			}

			//
			// Her laver vi de horisontale streger i spillet
			for (int i = 1; i <= columnsY-1; i++) {
				canvas.drawLine(0, (height / columnsY) * i, width, (height / columnsY) * i, paintLine);
			}

			manBitmap.setBounds(
					(width/rowsX) * game.getPlayer().getPlayerPositionX()-(width/rowsX), 					//venstre
					(height/columnsY)*game.getPlayer().getPlayerPositionY()-(height/columnsY),				//top
					(width/rowsX)*game.getPlayer().getPlayerPositionX(), 									//højre
					(height/columnsY)* game.getPlayer().getPlayerPositionY());								//bund
			
			manBitmap.draw(canvas);
			
			
			// Her spørges der efter om easymode er activeret, hvorefter den
			// spørger efter player deaths. Herefter laves cirklen, der
			// representerer bomberne ved hjælp af koordinaterne, hvor spilleren
			// døde.

			
			
			if (Game.isEasyMode()) {
				game.getDeathPoints();
				for (int i = 0; i < game.getDeathPoints().size(); i++) {

					mineBitmap.setBounds(
							(width / rowsX) * game.getDeathPoints().get(i).x - (width /rowsX), 			//left
							(height / columnsY) * game.getDeathPoints().get(i).y - (height / columnsY),	//top
							(width / rowsX) * game.getDeathPoints().get(i).x,								//right
							(height / columnsY) * game.getDeathPoints().get(i).y);							//bund
							
					mineBitmap.draw(canvas);
				}
			}

			// Her tegnes, hvor mange deaths man har i toppen af vores
			// skærm
			canvas.drawText("Deaths: " + game.getPlayerDeaths(), (width / 100), (height / columnsY) - (height / 100), txtPaint);
			//Toast.makeText(getApplicationContext(), "You died!", Toast.LENGTH_SHORT).show();
			
		}

		public boolean onTouchEvent(MotionEvent event) { // når vi trykker på
															// skærmen gøres
															// dette

			
			if ((rowsX != game.getPlayer().getPlayerPositionX() || columnsY != game.getPlayer().getPlayerPositionY() )&& timeStartCheck){
				
				startTime = System.currentTimeMillis(); 
				timeStartCheck=false;
				
			}
			
			synchronized (event) {
				try {
					// vi får den til at vente 16ms, da dette er anbefalet for
					// at swipe bliver bedre - don't ask me why!
					event.wait(16);
					if (event.getAction() == MotionEvent.ACTION_DOWN) {
						touchEndX = touchEndY = 0;

						touchStartX = event.getRawX();
						touchStartY = event.getRawY();
					}
					if (event.getAction() == MotionEvent.ACTION_UP) {
						touchEndX = event.getRawX() - touchStartX;
						touchEndY = event.getRawY() - touchStartY;

						if (Math.abs(touchEndX) > Math.abs(touchEndY)) {
							// X swipe

							if ((int) Math.signum(touchEndX) == 1) {
								game.movePlayerRight();
								game.playerMineCollision(game.getPlayer());
								return true;
							} else {
								game.movePlayerLeft();
								game.playerMineCollision(game.getPlayer());
								return true;
							}

						} else {
							game.movePlayerUp();
							game.playerMineCollision(game.getPlayer());

							if (game.getPlayer().getPlayerPositionY() == 1) {
								// Her tjekker vi om Player har vundet efter at
								// have rykket et felt op!!!

								Log.v("Emu", "Vi har vundet");
								estimatedTime = (System.currentTimeMillis() - startTime)/1000;
								intentYouwonGame.putExtra("timeid", estimatedTime);
								intentYouwonGame.putExtra("deathid", game.getPlayerDeaths());
								String mode="2";
								if(game.isEasyMode()){
									mode="1";
								}
								intentYouwonGame.putExtra("easyid", mode);
								String size="0";
								if (rowsX==7){
									size="1";
								}
								else if (rowsX==9){
									size="2";
								}
								else if(rowsX==11){
									size="3";
								}

								intentYouwonGame.putExtra("sizeid", size);
								startActivityForResult(intentYouwonGame, 1);
								
								finish();
								return true;
							}
							
						}

						
						
//						if (touchEndX + (70) < 0) {
//							game.movePlayerLeft();
//							game.playerMineCollision(game.getPlayer());
//							return true;
//						}
//						if (touchEndX - (70) > 0) {
//							game.movePlayerRight();
//							game.playerMineCollision(game.getPlayer());
//							return true;
//						}
//						if (touchEndY + (70) < 0) {
//							game.movePlayerUp();
//							game.playerMineCollision(game.getPlayer());
//
//							if (game.getPlayer().getPlayerPositionY() == 1) {
//								// Her tjekker vi om Player har vundet efter at
//								// have rykket et felt op!!!
//
//								Log.v("Emu", "Vi har vundet");
//								startActivityForResult(intentYouwonGame, 1);
//								finish();
//								return true;
//							}
//
//						}
					}
					return true;
				}

				catch (InterruptedException e) {

					return true;
				}
			}

		}

		protected void onSizeChanged(int w, int h, int oldw, int oldh) { // denne
																			// funktion
																			// fortæller
																			// os
																			// hvor
																			// mange
																			// pixels
																			// der
																			// er
																			// på
																			// telefonens
																			// skærm
			Log.v("Emu", "x: " + w + " Y:" + h);
			width = w; // Den sætter (private int width) til bredden af skærmen.
			height = h; // Den sætter (private int height) til højden af
						// skærmen.
			mBitmap.setBounds(0,0, width, height);
			
		}

		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { // ingen
																								// ved
																								// hvad
																								// den
																								// her
																								// gør
			// TODO Auto-generated method stub

		}

		public void surfaceCreated(SurfaceHolder holder) {
			if (!mThread.isAlive()) {
				mThread = new ViewThread(this);
				mThread.setRunning(true);
				mThread.start();
			}

		}

		public void surfaceDestroyed(SurfaceHolder holder) {
			if (mThread.isAlive()) {
				mThread.setRunning(false);

			}

		}

	}



	public int getRowsX() {
		return rowsX;
	}



	public int getColumnsY() {
		return columnsY;
	}

}
