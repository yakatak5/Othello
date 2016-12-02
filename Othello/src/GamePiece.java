/* 
 * Yusuf Khan CS2336.501
 * 
 * 
 * All needed files are contained in the "Othello" project file. 
 * The "Game" class file contains the main method, so run code
 * from that class file
 * 
 * 
 *Game piece class is the piece that is put down on every space in the board.  holds its own color, 
 *which can be W for white, B for black, or _ for empty space
 */
public class GamePiece {
	private String color;
	
	public GamePiece(){}
	
	public GamePiece(String color){
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
