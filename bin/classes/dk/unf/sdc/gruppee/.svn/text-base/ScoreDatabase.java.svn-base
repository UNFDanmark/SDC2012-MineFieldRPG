package dk.unf.sdc.gruppee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ScoreDatabase extends DatabaseManagerAbstraction {
	
	private static final String DATABASE_NAME = "mineFields";
		private static final String TABLE_SCORE = "score";
			private static final String KEY_SCORE_ID = "id";
			private static final String KEY_SCORE_SCORE = "score";
			private static final String KEY_SCORE_DIFFICULTY = "difficulty";
			private static final String KEY_SCORE_SIZE = "size";
	
	private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_SCORE + " " +
			"(" +
			KEY_SCORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			KEY_SCORE_SCORE + " INTEGER, " +
			KEY_SCORE_DIFFICULTY + " INTEGER, " +
			KEY_SCORE_SIZE + " INTEGER" +
			");";
	
	public ScoreDatabase(Context context) {
		super(context, DATABASE_NAME);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}
	
	public void saveScore(Score score) {
		/*
		 * Nu skal vi til at lave et ContentValues-objekter, for at kunne indsætte data i tabellerne.
		 * Man skal oprette et key-value-pair for hver kolonne i tabellen, som ikke har en defaultværdi.
		 * Kolonnenavnene er selvfølgelig keys.
		 */
		
		/*
		 * Her laver vi key-value-pairs for KEY_CONTACTS_NAME- og KEY_CONTACTS_PHONE-kolonnerne.
		 * Vi laver *ikke* for ID'et, da der er auto increement på.
		 */
		ContentValues table_contacts_values = new ContentValues();
		table_contacts_values.put(KEY_SCORE_SCORE, score.getPoint());
		table_contacts_values.put(KEY_SCORE_DIFFICULTY, score.getDifficulty());
		table_contacts_values.put(KEY_SCORE_SIZE, score.getSize());

		/*
		 * Indsæt rækker i contacts
		 * Resultatet fra db.insert-metoden er en long, hvilket er ID'et på den række, man indsætter.
		 * Der er altid et tal at modtage, og når man bruger auto increement, vil det svare til rækkeID'et (med mindre man piller ved nummeret på værdierne i databsen).
		 * Der indsættes null udfor alle de key-value-pairs som mangler.
		 */
		long insertID = insertRow(TABLE_SCORE, table_contacts_values);
		
		if (insertID == -1) return ; // Hvis insertID == -1, skete der en fejl. Stop!
		// Ellers modtager vi ID'et på kontakten. Dette gemmer vi for en god ordens skyld i kontaktobjektet
		score.setId((int) insertID);
	}
	
	public List<Score> getScores(int diff, int size) {
		List<Score> scores = new ArrayList<Score>();
		
		Map<String, String> where = new HashMap<String, String>();
		where.put(KEY_SCORE_DIFFICULTY, String.valueOf(diff));
		where.put(KEY_SCORE_SIZE, String.valueOf(size));
		
		// Hent alle rækker i TABLE_CONTACTS
		List<Map<String, Object>> contactRows = getAllWhere(TABLE_SCORE, where);
		
		if (contactRows.size() == 0) {
			// Der er ingen kontakter i databasen. Stop her!
			return scores; // Retuner en tom liste af kontakter
		}
		
		/*
		 * Løb gennem listen af rækker.
		 */
		for (Map<String, Object> row : contactRows) {
			// Hent data ned. Vi ved, at der ikke sker cast exceptions, fordi vi ved, hvad type felterne er.
			int sId = (Integer) row.get(KEY_SCORE_ID);
			int sScore = (Integer) row.get(KEY_SCORE_SCORE);
			int sDifficulty = (Integer) row.get(KEY_SCORE_DIFFICULTY);
			int sSize = (Integer) row.get(KEY_SCORE_SIZE);
			// Lav kontakten og put den i listen af kontakter.
			Score score = new Score(sId, sScore, sDifficulty, sSize);
			scores.add(score);
		}
		// Aflever listen af kontakter.
		Collections.sort(scores);
		return scores;
	}
}
