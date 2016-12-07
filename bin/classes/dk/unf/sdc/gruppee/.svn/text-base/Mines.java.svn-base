package dk.unf.sdc.gruppee;

import java.util.Random;

import javax.sql.RowSet;

import android.R.integer;
import android.provider.SyncStateContract.Columns;
import android.util.Log;

public class Mines {

	private int mines[][];
	private int xDim, yDim;
	private Random rnd;
	private int PATH = 0;
	private int MINE = 1;
	private int LEFT = 2;
	private int RIGHT = 3;
	private int UP = 4;

	

	
	


	public Mines(int rowsX, int columnsY) 	{	
		xDim = rowsX;
		yDim = columnsY;

		rnd = new Random();
		mines = new int[xDim][yDim];
		xDim--;
		yDim--;
	}

	public int[][] getMines() { 							// dette er vores getter for mines.
		return mines;
	}

	public void newMines() {								// denne metode bliver kaldt fra game. den starter med at sætte miner på alle pladser
		fillMines();										
		
		int xPos = rnd.nextInt(xDim);		
		int yPos = yDim-1;
		
		setPath(xPos, yPos);
		
		while (yPos > 1) {
			int direction = getRandomDirection();
			
			if (direction == LEFT) {
				if (canGoLeft(xPos, yPos)) {
					xPos -= 1;
					setPath(xPos, yPos);

				}
			}
			if (direction == RIGHT) {
				if (canGoRight(xPos, yPos)) {
					xPos += 1;
					setPath(xPos, yPos);
				}

			}
			if (direction == UP) {
				yPos -= 1;
				setPath(xPos, yPos);

			}
		}
		
		for(int i = 0; i < xDim+1; i++) {				//Denne funktion fylder den øverste og den nederste række med PATH i stedet for miner.
			mines[i][0] = PATH;							// den første række
			mines[i][yDim] = PATH;						// Den sidste række
		}
		String row = new String();
		for (int i = 0; i < yDim+1; i++) {
			//Log.v("Emu", "Række "+ i);
			row = "";
			for (int k = 0; k < xDim+1; k++) {
				row += mines[k][i]+" ";
				//Log.v("Emu", ""+mines[k][i]);
			}
			Log.v("Emu", row);
		}
	}

	public int getRandomDirection() {  				//Her får vi et random tal mellem 2 og 4
		return rnd.nextInt(3) + 2;

	}

	public boolean canGoLeft(int x, int y) {			//Her spørger vi om der er en path i feltet under det vi vil rykke til.
		if (x > 0) {
			if (mines[x - 1][y + 1] == MINE){
				return true;
			}
			else
				return false;
		} else
			return false;
	}

	public boolean canGoRight(int x, int y) {
			
		if (x < xDim) {
			if (mines[x + 1][y + 1] == MINE)
				return true;
			else
				return false;
		} else 
			
			return false;
	}

	public void fillMines() {							// Denne metode bliver kaldt først og den sætter miner på alle felterne.
		for (int i = 0; i < yDim+1; i++) {
			for (int k = 0; k < xDim+1; k++) {
				mines[k][i] = 1;
			}
		}
	}

	public void setPath(int x, int y) {
		mines[x][y] = PATH;
	}
}

