package fr.evonarx.connect4;
// SERVER
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server1 {
    public static void main(String[] args) throws IOException {
        
    	System.out.println("Server : Main");
    	ServerSocket s = new ServerSocket(4999);
        Socket socket = s.accept();
        System.out.println("Client is connected");

        //The server gets the first message from the client
//        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String str = bufferedReader.readLine();
//        System.out.println("Client : " + str);
        
        //The server sends the first message to the client
//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//        printWriter.println("Hello World from Server, C'est Eric.");
//        printWriter.flush();
        
        
        String strClientInput = "";
        String strServerInput = "";
        Scanner serverInput;
        
        int input = 0;
        Game j = new Game();
        
        while (!j.vCS.endOfTheGame) {
        	// Server answer
        	do {
        	
        		System.out.println("Player 1 : Enter the column number (1 to 7) => ");
        		serverInput = new Scanner(System.in);
        		strServerInput = serverInput.next();
        		input = Integer.parseInt(strServerInput);

        		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        		printWriter.println(input);
        		printWriter.flush();

        		j.go(input);
        		
        	} while (j.vCS.change_player == false);
        	
        	
        	if (!j.vCS.endOfTheGame) {
        		// Client answer
        		do  {
 
        			System.out.println("Waiting for the move of the client ");

        			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        			strClientInput = bufferedReader.readLine();
        			input = Integer.parseInt(strClientInput);

        			j.go(input);
        			
        		} while (j.vCS.change_player == false);
        	}
          
        }
        
  
      
    }
}