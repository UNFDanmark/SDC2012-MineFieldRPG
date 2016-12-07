package dk.unf.sdc.gruppee;

public class Score implements Comparable<Score> {
	
	private int id;
	private int point;
	private int difficulty;
	private int size;

	public Score(int id, int point, int difficulty, int size) {
		this.id = id;
		this.point = point;
		this.difficulty = difficulty;
		this.size = size;
	}
	public Score(int point, int difficulty, int size) {
		this(0, point, difficulty, size);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int compareTo(Score another) {
		return - ( this.point - another.point );
	}
}
