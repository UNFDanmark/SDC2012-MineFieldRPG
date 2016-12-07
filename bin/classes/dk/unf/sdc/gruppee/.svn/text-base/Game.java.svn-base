package dk.unf.sdc.gruppee;


import java.util.ArrayList;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.widget.Toast;

public class Game {

	private Player player;
	private int playerDeaths = 0;
	private Mines mines;
	private static boolean easyMode = true;
	private ArrayList<Point> deathPoints = new ArrayList<Point>();
	private static int rowsX =7;
	private static int columnsY = 11;
	private static int mapSize = 1;
	private Context context;
	private Toast youDied;
	
	public Game(Context c) {					// Når game bliver lavet laver den en player og et minefelt
		player = new Player(rowsX, columnsY);
		mines = new Mines(rowsX, columnsY);	
		mines.newMines();
		context = c;
		youDied = Toast.makeText(context, "You died!", Toast.LENGTH_SHORT);
	}

	public Player getPlayer() {		//getter for player
		return player;
	}

	public void movePlayerLeft() {

		if ((getPlayer().getPlayerPositionX()) > 1) { // er Player ved væggen?
														// skriver til loggen at
														// player ikke var ved
														// væggen
			getPlayer().setPlayerPositionX(getPlayer().getPlayerPositionX() - 1); // Rykker
			Log.v("Emu", "PlayerPositionX er " + getPlayer().getPlayerPositionX()); // Player
			return; // en
			// til
			// venstre

		}

	}

	public void movePlayerUp() {
		if ((getPlayer().getPlayerPositionY()) > 1) {
			getPlayer().setPlayerPositionY(getPlayer().getPlayerPositionY() - 1);
			Log.v("Emu", "PlayerPositionY er" + getPlayer().getPlayerPositionY());
			return;
		}
	}

	public void movePlayerRight() {

		if ((getPlayer().getPlayerPositionX()) < rowsX) {
			getPlayer().setPlayerPositionX(getPlayer().getPlayerPositionX() + 1);
			Log.v("Emu", "PlayerPositionX er" + getPlayer().getPlayerPositionX());

			return;
		}
	}



	public boolean checkPlayerMineCollision(Player player) {  								//Her checker vi om player står på en mine når han flytter sig
		//Log.v("Emu", "PlayerPositionX er" + (player.getPlayerPositionX() - 1));
	//	Log.v("Emu", "PlayerPositionY er" + (player.getPlayerPositionY() - 1));
	//	Log.v("Emu", "Mine på pos er:"+ mines.getMines()[player.getPlayerPositionX() - 1][player.getPlayerPositionY() - 1] );
		if (mines.getMines()[player.getPlayerPositionX() - 1][player.getPlayerPositionY() - 1] == 1) {
			return true;
		}

		return false;
	}

	public void playerMineCollision(Player player) { 										//Denne funktion bliver startet hvis player står på en mine.
		if (checkPlayerMineCollision(player)) {												//hvor efter den dræber player.
			if (easyMode) {
				if (!deathPoints.contains(new Point(player.getPlayerPositionX(), player.getPlayerPositionY()))) {

					deathPoints.add(new Point(player.getPlayerPositionX(), player.getPlayerPositionY()));
				}
				
			}
			
			youDied.cancel();
			youDied.show();
			player.playerReset();															//player bliver sat tilbage til start	
			playerDeaths();																	// her køres metoden playerDeaths
			
		}
	}

	public void playerDeaths() {															//playerdeaths bliver kaldt når player dør
		playerDeaths += 1;																	// her lægger den en til vores death count.
		Log.v("Emu", "playerDeaths er" + getPlayerDeaths());								// denne log viser os hvor mange gange player er død i logcat
		
	}

	public int getPlayerDeaths() {
		return playerDeaths;
	}

	public void setPlayerDeaths(int playerDeaths) {
		this.playerDeaths = playerDeaths;
	}

	public static void easyMode(){
		
		easyMode = true;
	}

	public ArrayList<Point> getDeathPoints() {
		return deathPoints;
	}

	public Mines getMines() {
		return mines;
	}

	public int getRowsX() {
		return this.rowsX;
	}

	public int getColumnsY() {
		return this.columnsY;
	}

	public static boolean isEasyMode() {
		return easyMode;
	}
	
	public static void normalMode(){
		
		easyMode = false;
	}
	
	public static void size(int size){
		
		
			if(size == 1){
				rowsX = 7;
				columnsY = 11;
				
			}
			if(size == 2){
				rowsX = 9;
				columnsY = 13;
				
			}
			if(size == 3){
				rowsX = 11;
				columnsY = 15;
				
			}
			mapSize = size;
	}

	public static int getMapSize() {
		return mapSize;
	}
	

}
