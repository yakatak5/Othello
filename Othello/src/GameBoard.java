/*
 * Yusuf Khan CS2336.501
 * 
 * 
 * All needed files are contained in the "Othello" project file. 
 * The "Game" class file contains the main method, so run code
 * from that class file
 * 
 * 
 * 
 * Game Board class holds a 2D array of Game Pieces that represents the game board. 
 Board is created based off of size requested.  Can count number of pieces of same color as well as output the board
*/

public class GameBoard {
	int size = 0;

	GamePiece [][] pieces;

	
	public GameBoard(int size){
	
		//create board
		this.size = size;
		this.pieces = new GamePiece[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				pieces[i][j] = new GamePiece("_");
			}
		}
		this.pieces[ (size/2) - 1][(size/2)].setColor("B");
		this.pieces[(size/2) - 1][(size/2) - 1].setColor("W");
		this.pieces[size/2][(size/2) - 1].setColor("B");
		this.pieces[size/2][size/2].setColor("W");
	}//fills in beginning blacks and whites
	public int getSize() {
		return size;
	}

	public void printBoard(){
		for (int i = 0; i < size; i++){
			System.out.println();
			for (int j = 0; j < size; j++){
				System.out.print(pieces[i][j].getColor() + " ");
			}//runs thru every row and outputs board
		}//runs through and outputs all of board
		System.out.println();
	}//outputs board
	public GamePiece[][] getPieces() {
		return pieces;
	}
	public void setPieces(GamePiece[][] pieces) {
		this.pieces = pieces;
	}
	public int getNumColor(String color){
		int num = 0;
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				if (pieces[i][j].getColor().equals(color)) num++;
			}
		}
		return num;
	}
	
}
