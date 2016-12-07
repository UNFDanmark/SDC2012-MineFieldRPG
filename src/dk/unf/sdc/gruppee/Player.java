package dk.unf.sdc.gruppee;

import android.os.Bundle;

public class Player {
	// Variabler for player
	private int playerPositionX;
	private int playerPositionY;
	private int startPlayerPositionX;
	private int startPlayerPositionY;


	// Constructor for player
	public Player(int rowsX, int columnsY) {
		startPlayerPositionX = rowsX;
		startPlayerPositionY = columnsY;
		playerReset();
	}

	public void playerReset() { // Når playerReset bliver kaldt rykkes player
								// hen til det sted han startede - (4,11)
		playerPositionX = Math.round(startPlayerPositionX / 2f);
		playerPositionY = startPlayerPositionY;
	}

	public void setPlayerPositionX(int playerPositionX) {
		this.playerPositionX = playerPositionX;
	}

	public void setPlayerPositionY(int playerPositionY) {
		this.playerPositionY = playerPositionY;
	}

	public int getPlayerPositionX() {
		return playerPositionX;
	}

	public int getPlayerPositionY() {
		return playerPositionY;
	}
	public int getStartPlayerPositionX() {
		return startPlayerPositionX;
	}

	public void setStartPlayerPositionX(int startPlayerPositionX) {
		this.startPlayerPositionX = startPlayerPositionX;
	}

	public int getStartPlayerPositionY() {
		return startPlayerPositionY;
	}

	public void setStartPlayerPositionY(int startPlayerPositionY) {
		this.startPlayerPositionY = startPlayerPositionY;
	}



}
