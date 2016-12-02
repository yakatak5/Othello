/*
 * Yusuf Khan CS2336.501
 * 
 * 
 * All needed files are contained in the "Othello" project file. 
 * The "Game" class file contains the main method, so run code
 * from that class file
 * 
 * 
 * Player class. Is abstract because is meant to be extended by CPU and Human.  Holds color of player and score.
 * Also has abstract method for making a move
 */
public abstract class Player {
	String color;
	int score = 0;
	public Player(){}
	public Player(String color){
		this.color = color;
	}
	public abstract int [] move(int size);
	public abstract boolean isHuman();
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
