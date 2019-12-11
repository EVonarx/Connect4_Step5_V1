package fr.evonarx.connect4;


//CLIENT
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client1 {
	public static void main(String[] args) throws IOException {

		System.out.println("Client : Main");
		//Socket socket = new Socket("localhost", 4999);
		Socket socket = new Socket("10.113.28.58", 4999);
		System.out.println("The socket is opened");

		//The client sends the first message to the server
		//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		//        printWriter.println("Hello World from Client");
		//        printWriter.flush();

		//The client gets the first message from the server
		//        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
		//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		//        String str = bufferedReader.readLine();
		//        System.out.println("Server : " + str);

		String strServerInput = "";
		String strClientInput = "";
		Scanner clientInput = null;

		int input = 0;

		Game j = new Game();

		while (!j.vCS.endOfTheGame) {

			// Server answer

			do {

				System.out.println("Waiting for the move of the server ");

				InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				strServerInput = bufferedReader.readLine();
				input = Integer.parseInt(strServerInput);

				j.go(input);
				
			} while (j.vCS.change_player == false);

			if (!j.vCS.endOfTheGame) {
				
				// Client answer

				do {

					System.out.println("Player 2 : Enter the column number (1 to 7) => ");

					clientInput = new Scanner(System.in);
					strClientInput = clientInput.next();
					input = Integer.parseInt(strClientInput);

					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.println(input);
					printWriter.flush();

					j.go(input);
					
				} while (j.vCS.change_player == false);
			}

		}
		
		
		
		
		

	}
}