package fr.evonarx.connect4;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game j = new Game();
		Scanner input;
		int value;

		while (!j.vCS.endOfTheGame) {
			// Server answer
				 System.out.print("Player " + j.vCS.current_player + " : Enter the column number (1 to 7) => ");
				input = new Scanner(System.in);
				value= Integer.parseInt(input.next());
				j.go(value);
		}	

	}

}
