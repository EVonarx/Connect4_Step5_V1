package fr.evonarx.connect4;

import java.util.Scanner;
import java.lang.Integer;

public class Game {
	
	Grid grid = new Grid();
	Player player = new Player();
	ValuesClientServer vCS = new ValuesClientServer();
	
	
	
	public Game() {
		grid.initGrid();
		grid.printGrid();
		player.initCurrent_player();
	}


	public void go(int input) {

		
		if (!vCS.endOfTheGame) {
			
			if (!grid.isGridFull()) {
//				if (vCS.change_player == true ) 
//					player.changePlayer(player.getCurrent_player());
//					
//				vCS.current_player= player.getCurrent_player();
//				vCS.change_player = play(player.getCurrent_player(),input);
//				
				vCS.change_player = play(player.getCurrent_player(),input);
				
				if (grid.isThereAWinner(player.getCurrent_player())) {
					vCS.endOfTheGame= true;
					System.out.println("There is a winner...It is player "+ player.getCurrent_player());
				} else {
					if (vCS.change_player == true ) {
						player.changePlayer(player.getCurrent_player());
						vCS.current_player= player.getCurrent_player();
					}
				}

			}
			else {
				vCS.endOfTheGame= true;
				System.out.println("Match nul");
			}
		}

		
	}
	

	private boolean play(char current_player, int input) {
		 //Scanner input = new Scanner(System.in);
		 String answer = String.valueOf(input);
		
		 if (!isAnswerInRange(answer))
		    {
			 	System.out.println("Enter a value between 1 and 7 !!!!");
			    vCS.change_player = false;    
		    }
		 else {
			
				 if (grid.putTokenInTheColum(answer, current_player)) {
					 grid.printGrid();
					 vCS.change_player = true;
					 }
				 else {
					 System.out.println("This column is full !!!!");
					 vCS.change_player = false;
				 }
			 
		}
		
			return vCS.change_player; 
	}
	
	
	private boolean isAnswerInRange(String s) {
		if (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7"))
			return true;
		return false;
	}


//	public static void main(String[] args) {
//		Game j = new Game();
//		j.go();
//	}
	
}
