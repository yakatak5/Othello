/*
 * Yusuf Khan CS2336.501
 * 
 * All needed files are contained in the "Othello" project file. 
 * The "Game" class file contains the main method, so run code
 * from that class file
 *  
 * Game client that gets game size from player and number of players, and initializes the board
 * and players based off of inputs.  Checks to see where and when moves are valid, as well as
 * if there are still valid moves available. Also changes board based off of moves.  Once game is ended, 
 * outputs the scores of each player
 */


import java.util.Scanner;





public class Game {
	public static boolean checkLeft(Player p, int row, int column, GameBoard game){
		if (column == 0) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
			//check to left of entry
			for (int i = column - 1; i >= 0 && !same; i--){
				if (pieces[row][i].getColor().equals(p.getColor())){
					same = true; break; //breaks after 2 same pieces
				}
				else if (pieces[row][i].getColor().equals("_")) break; //if empty space, invalid
				else diffColor++; //counts number of different color
			}
			if (same && diffColor >=1){
				return true;
			}//there is another of same piece to the left and at least 1 opposite color in between
			else return false;
	}//checks to left of move for validity
	public static boolean checkRight(Player p, int row, int column, GameBoard game){
		//check to right of entry
		if (column == game.getSize()-1) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = column + 1; i < game.getSize() && !same; i++ ){
			if (pieces[row][i].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[row][i].getColor().equals("_")) break; //if empty space, invalid
			else diffColor++;
		}
		if (same && diffColor >=1){
			return true;
		}//2 of same color not next to each other
		else return false;
	}//checks to right of move for validity
	public static boolean checkUp(Player p, int row, int column, GameBoard game){ 
		if (row == 0) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = row - 1; i >=0 && !same; i--){
			if (pieces[i][column].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[i][column].getColor().equals("_")) break;
			else diffColor++;
		}
		if (same && diffColor >= 1) return true; //2 of same color not next to each other
		else return false;
	}
	public static boolean checkDown(Player p, int row, int column, GameBoard game){
		if (row == game.getSize()-1) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = row + 1; i < game.getSize() && !same; i++){
			if (pieces[i][column].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[i][column].getColor().equals("_")) break;
			else diffColor++;
		}
		if (same && diffColor >= 1) return true; //2 of same color not next to each other
		else return false;
	}//checks below move for validity
	public static boolean checkDRight(Player p, int row, int column, GameBoard game){
		//check down right
		if (row == game.getSize()-1) return false;
		if (column == game.getSize()-1) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = row +1, j = column + 1; i < game.getSize() && j < game.getSize(); i++, j++){
			if (pieces[i][j].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[i][j].getColor().equals("_")) break;
			else diffColor++;
		}
		if (same && diffColor >= 1) return true; //2 of same color not next to each other
		else return false;
		}//checks down right for validity
	
	public static boolean  checkURight(Player p, int row, int column, GameBoard game){
		if (row == 0) return false;
		if (column == game.getSize()-1) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = row -1, j  = column + 1; i >= 0 && j < game.getSize(); i--, j++){
			if (pieces[i][j].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[i][j].getColor().equals("_")) break;
			else diffColor++;
		}
		if (same && diffColor >= 1) return true; //2 of same color not next to each other
		else return false;
		}//checks up right for validity
	
	public static boolean checkULeft(Player p, int row, int column, GameBoard game){
		if (row == 0) return false;
		if (column == 0) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = row -1, j  = column - 1; i >= 0 && j >= 0; i--, j--){
			if (pieces[i][j].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[i][j].getColor().equals("_")) break;
			else diffColor++;
		}
		if (same && diffColor >= 1) return true; //2 of same color not next to each other
		else return false;
		}//checks up left for validity
	
	public static boolean checkDLeft(Player p, int row, int column, GameBoard game){
		if (row == game.getSize()-1) return false;
		if (column == 0) return false;
		GamePiece[][] pieces = game.getPieces();
		int diffColor = 0;
		boolean same = false;
		for (int i = row +1, j  = column - 1; i < game.getSize() && j >= 0; i++, j--){
			if (pieces[i][j].getColor().equals(p.getColor())){
				same = true; break; //breaks after 2 same pieces
			}
			else if (pieces[i][j].getColor().equals("_")) break;
			else diffColor++;
		}
		if (same && diffColor >= 1) return true; //2 of same color not next to each other
		else return false;
		}//checks down left for validity

	
	
	
		
	
	public static boolean hasMove(GameBoard game, Player p){
		for (int i = 0; i < game.getSize(); i++){
			for (int j = 0; j < game.getSize(); j++){
				if ( validMove(p,game,i,j)  ){
					return true;
				}
			}

		}
		return false;
	}//checks if moves are still available
	public static boolean validMove(Player p, GameBoard game, int row, int column){
			//check entered space
			boolean empty = false;
			GamePiece [][] pieces = game.getPieces();
			if (pieces[row][column].getColor().equals("_")) empty = true;
			else empty = false;
			//check left
			boolean left = checkLeft(p, row, column, game);
			//check right
			boolean right = checkRight(p,row,column,game);
			//check up
			boolean up = checkUp(p,row,column,game);
			//check down
			boolean down = checkDown(p,row,column,game);
			//check diags
			boolean URight = checkURight(p,row,column,game);
			boolean ULeft = checkULeft(p,row,column,game);
			boolean DRight = checkDRight(p,row,column,game);
			boolean DLeft = checkDLeft(p,row,column,game);
			//check if any are true
			return (empty && (left || right || up || down|| URight || ULeft || DRight || DLeft)); 
		
	}//checks to see if entered move is valid
	
	public static void changeBoard(Player p, GameBoard game, int row, int column){
		GamePiece[][] pieces = game.getPieces();
		//check for directions to go
		//check left
		boolean left = checkLeft(p, row, column, game);
		//check right
		boolean right = checkRight(p,row,column,game);
		//check up
		boolean up = checkUp(p,row,column,game);
		//check down
		boolean down = checkDown(p,row,column,game);
		
		//check diags
		boolean URight = checkURight(p,row,column,game);
		boolean ULeft = checkULeft(p,row,column,game);
		boolean DRight = checkDRight(p,row,column,game);
		boolean DLeft = checkDLeft(p,row,column,game);
		
		//change board based off of possibilities
		
		if (left){
			pieces[row][column].setColor(p.getColor());
			for (int i = column - 1; i >= 0 ; i--){
				if (pieces[row][i].getColor().equals(p.getColor())) break;
				else pieces[row][i].setColor(p.getColor());
			}//flips all pieces to left of piece
		}
		if (right){
			pieces[row][column].setColor(p.getColor());
			for (int i = column + 1; i < game.getSize(); i++ ){
				if (pieces[row][i].getColor().equals(p.getColor())) break;
				else pieces[row][i].setColor(p.getColor());
			}//flips all pieces to right of piece
		}
		if (up){
			pieces[row][column].setColor(p.getColor());
			for (int i = row - 1; i >=0; i--){
				if (pieces[i][column].getColor().equals(p.getColor())) break;
				else pieces[i][column].setColor(p.getColor());
			}//flips all pieces above piece
		}
		if (down){
			pieces[row][column].setColor(p.getColor());
			for (int i = row + 1; i < game.getSize(); i++){
				if (pieces[i][column].getColor().equals(p.getColor())) break;
				else pieces[i][column].setColor(p.getColor());
			}//changes all pieces below piece
		}
		if (DRight){
			pieces[row][column].setColor(p.getColor());
			for (int i = row +1, j = column + 1; i < game.getSize() && j < game.getSize(); i++, j++){
				if (pieces[i][j].getColor().equals(p.getColor())) break;
				else pieces[i][j].setColor(p.getColor());
			}//changes all pieces diagonally down  right
			
		}
		if (DLeft){
			pieces[row][column].setColor(p.getColor());
			for (int i = row +1, j = column - 1; i < game.getSize() && j >= 0; i++, j--){
				if (pieces[i][j].getColor().equals(p.getColor())) break;
				else pieces[i][j].setColor(p.getColor());
			}//changes all pieces diagonally down left
		}
		if (URight){
			pieces[row][column].setColor(p.getColor());
			for (int i = row -1, j = column + 1; i >= 0 && j < game.getSize(); i--, j++){
				if (pieces[i][j].getColor().equals(p.getColor())) break;
				else pieces[i][j].setColor(p.getColor());
			}//changes all pieces diagonally up right
		}
		if (ULeft){
			pieces[row][column].setColor(p.getColor());
			for (int i = row - 1, j = column  - 1; i >= 0 && j >= 0; i--, j--){
				if (pieces[i][j].getColor().equals(p.getColor())) break;
				else pieces[i][j].setColor(p.getColor());
			}//changes all pieces diagonally Up left
		}
	}//changes board where needed
	
	public static void main(String [] args){
		//generate board
		boolean notEven = true; //for invalid input checking
		GameBoard game;
		System.out.println("Enter an even number for the height and width of your board: ");
		Scanner input = new Scanner(System.in);
		int getSize;
		getSize = input.nextInt();
		while(notEven){
			
			if (getSize % 2  == 0 && getSize >= 4){
				notEven = false;
			}
			else {
				System.out.println("Invalid size, Enter an even number for the height and width of your board: ");
				getSize = input.nextInt();
			}
		}//check for valid input
		game = new GameBoard(getSize);//constructs board
		
		//get players
		boolean invalid = true;
		input = new Scanner(System.in);
		Player p1 = null;
		Player p2 = null;
		while (invalid){
			//ask for number of players
			System.out.print("Enter 0, 1, or 2 for number of players: ");
			int entered = input.nextInt();
			//if valid input
			if (entered == 0){
				p1 = new CPU("W");
				p2 = new CPU("B");
				invalid = false;
			}//for 2 computers (0 players)
			else if (entered == 1){
				p1 = new Human("W");
				p2 = new CPU("B");
				invalid = false;
			}//for 1 player
			else if (entered == 2){
				p1 = new Human("W");
				p2 = new Human("B");
				invalid = false;
			}//for 2 player
			else System.out.println("Invalid input");
		}//gets number of players
		//play
		while (hasMove(game,p1) || hasMove(game,p2)){
			//print board
			game.printBoard();
			boolean valid;
			int row = 0;
			int column = 0;
			int numbers[]; //for function return
			
			if (hasMove(game,p1)){ //make moves while moves available
			
				System.out.println("Player 1 (White): ");
				do {
					numbers = p1.move(game.getSize());
					row = numbers[0];
					column = numbers[1];
					valid =validMove(p1,game,row,column);
					if (!valid && p1.isHuman()) System.out.println("Invalid move");

				
				}while (!valid); //keeps asking for move until move is valid
				//make changes of move
				changeBoard(p1,game,row,column);
				//print new board
				game.printBoard();
			}
			else {
				break;
			}//break before p2 turn if no move for p1
			if (hasMove(game,p2)){
				System.out.println("Player 2 (Black): ");
				do {
					numbers = p2.move(game.getSize());
					row = numbers[0];
					column = numbers[1];
					valid =validMove(p2,game,row,column);
					if (!valid && p2.isHuman()) System.out.println("Invalid move");

				
				}while (!valid); //keeps asking for move until move is valid
				//make changes
				changeBoard(p2,game,row,column);
			}

		}
		game.printBoard(); //print final board
		p1.setScore(game.getNumColor(p1.getColor())); //set score for p1
		p2.setScore(game.getNumColor(p2.getColor())); //set score for p2
		//output game results
		System.out.println("Game Over");
		System.out.println("Player 1 (White) Score: " + p1.getScore() + "          " + "Player 2 (Black) Score: " + p2.getScore());;
		
	}
}
