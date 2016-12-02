/*
 * Yusuf Khan CS2336.501
 * 
 * 
 * All needed files are contained in the "Othello" project file. 
 * The "Game" class file contains the main method, so run code
 * from that class file
 * 
 * 
 * Human class for when player is human, gets move from human.  Also holds color of game pieces for player.
 * Extends the player class.
 */

import java.util.Scanner;

public class Human extends Player {

	public Human(String color){
		this.color = color;
	}
	public int [] move(int size){
		int [] numbers = new int[2];
		boolean invalid = true;
		//get move numbers
		System.out.print("Enter row then cloumn for move (ex 2 2): ");
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		while (invalid){
			if (row <= size && row >= 1 && column <= size && column >= 1){
				invalid = false;
			}//breaks loop
			else {
				System.out.println("invalid input");
				System.out.print("Enter row then cloumn for move (ex 2 2): ");
				input = new Scanner(System.in);
				row = input.nextInt();
				column = input.nextInt();
			}
		}//for invalid checking
		row -= 1; //for correct array index
		column -= 1; //for correct array index
		numbers [0] = row;
		numbers[1] = column;
		return numbers;
	}//gets move from player
	public boolean isHuman(){return true;}//is human
}
