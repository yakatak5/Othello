/* Yusuf Khan CS2336.501
 * 
 * 
 * All needed files are contained in the "Othello" project file. 
 * The "Game" class file contains the main method, so run code
 * from that class file
 */




//CPU class for when one of the players is the computer.  Extends the player class
import java.util.Random;
public class CPU extends Player{
	public CPU(String color){
		this.color = color; //color of gamepiece for player
	}//constructor
	
	
	public int [] move(int size){

		Random random = new Random();
		int row = random.nextInt(size);
		int column = random.nextInt(size);
		int [] numbers = {row,column};
		return numbers;
	}//generates random move for cpu
	public boolean isHuman(){return false;}//is not human
	
}
