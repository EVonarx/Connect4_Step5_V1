package fr.evonarx.connect4;

public class Are4SlotsConnect {

	
	//HORIZONTAL
		public static boolean Are4SlotsConnectHorizontally(char[][]  Grid, char current_player) {
		
			int compt=0;
			int StartColumn=0;
			
			for (int i=0; i<6; i++) {
				//System.out.println("ligne = "+(i+1));
				
				StartColumn=0;
				
				for (int j=StartColumn; j<StartColumn+4; j++) {
					//System.out.println("I check the position" +"["+(i+1)+"]"+"["+(j+1)+"]"+ " => there is : " + Grid[i][j] +" and I check the character = "+current_player);
					
					if (Grid[i][j] == current_player) {
						compt++;
						//System.out.println("From the column " +(StartColumn+1)+ " At the moment the counter = "+compt);
						if (compt == 4) 
							{
							//System.out.println("The player "+ current_player + " won");
							return true;
							}
					} else {
						compt=0;
						StartColumn=j+1;
						//System.out.println("A la position" +"["+(i+1)+"]"+"["+(j+1)+"]"+ " => il y a : " + Grid[i][j] + " donc je mets le compteur � 0 et je traite la colonne suivante, la colonne : "+ (StartColumn+1));
						
						if (StartColumn >= 4) {
							//System.out.println("Sup�rieur ou �gal � la colonne 5 => Je vais � la ligne suivante");
							break;
						}
					}
					
				} // end of the "for" instruction for the columns
				
			} // end of the "for" instruction for a raw
			
			//System.out.println("There are not 4 slots connected horizontaly");
			return false;
		}

		
		//VERTICAL
		public static boolean Are4SlotsConnectVertically(char[][]  Grid, char current_player) {
			
			int compt=0;
			int StartLine=0;
			
			for (int j=0; j<7; j++) {
				//System.out.println("colonne = "+(j+1));
				
				StartLine=0;
				
				for (int i=StartLine; i<StartLine+4; i++) {
					//System.out.println("Je traite la position" +"["+(i+1)+"]"+"["+(j+1)+"]"+ " => il y a : " + Grid[i][j] +" et je traite le caract�re = "+current_player);
					
					if (Grid[i][j] == current_player) {
						compt++;
						//System.out.println("A partir de la ligne " +(StartLine+1)+ " pour l'instant compteur = "+compt);
						if (compt == 4) 
							{
							//System.out.println("C'est le joueur "+ current_player + " qui a gagn�");
							return true;
							}
					} else {
						compt=0;
						StartLine=i+1;
						//System.out.println("A la position" +"["+(i+1)+"]"+"["+(j+1)+"]"+ " => il y a : " + Grid[i][j] + " donc je mets le compteur � 0 et je traite la ligne suivante, la ligne : "+ (StartLine+1));
						
						if (StartLine >= 3) {
							//System.out.println("Sup�rieur ou �gal � la ligne 4 => Je vais � la colonne suivante");
							break;
						}
					}
					
				} // end of the "for" instruction for the lines
				
			} // end of the "for" instruction for a column
			
			//System.out.println("There are not 4 slots connected verticaly");	
			return false;
		}
		
		
		//DIAGONAL_UP
		public static boolean Are4SlotsConnectInDiagonalUp(char[][]  Grid, char current_player) {
			//start cells => 12 cells
			// Grid[5][0]; Grid[5][1]; Grid[5][2]; Grid[5][3]; Grid[5][4]; Grid[5][5]; Grid[5][6]
			// Grid[4][0]; Grid[4][1]; Grid[4][2]; Grid[4][3]; Grid[4][4]; Grid[4][5]; Grid[4][6]
			// Grid[3][0]; Grid[3][1]; Grid[3][2]; Grid[3][3]; Grid[3][4]; Grid[3][5]; Grid[3][6]
			// *Grid[2][0]; *Grid[2][1]; *Grid[2][2]; *Grid[2][3]; Grid[2][4]; Grid[2][5]; Grid[2][6]
			// *Grid[1][0]; *Grid[1][1]; *Grid[1][2]; *Grid[1][3]; Grid[1][4]; Grid[1][5]; Grid[1][6]
			// *Grid[0][0]; *Grid[0][1]; *Grid[0][2]; *Grid[0][3]; Grid[0][4]; Grid[0][5]; Grid[0][6]
			
			int compt = 0;
			
			int i_initial =0;
			int j_initial= 0; 
			int i_temp = i_initial;
			int j_temp = j_initial;
			
			while (true) {
				if (Grid[i_temp][j_temp] == current_player) {
					compt++;
					i_temp++;
					j_temp++;
					//System.out.println("A partir de la ligne " +(StartLine+1)+ " pour l'instant compteur = "+compt);
					if (compt == 4) {
						//System.out.println("C'est le joueur "+ current_player + " qui a gagn�");
						
						return true;
					}
				} else {
					compt=0;
					i_initial++;
					i_temp = i_initial;
					j_temp= j_initial;
								
								
					//System.out.println("A la position" +"["+(i+1)+"]"+"["+(j+1)+"]"+ " => il y a : " + Grid[i][j] + " donc je mets le compteur � 0 et je traite la ligne suivante, la ligne : "+ (StartLine+1));
								
					if (i_temp >= 3) {
						//System.out.println("Sup�rieur ou �gal � la ligne 4 => Je vais � la colonne suivante");
						i_initial =0;
						i_temp = i_initial;
						j_initial++; 
						j_temp= j_initial;
						
						if (j_temp >= 4) break;
						
					}
										
				}
			}
			
			//System.out.println("There are not 4 slots connected in a diagonal going up (from left to right)");
			return false;	
		}
			
			
		
		//DIAGONAL_DOWN
		public static boolean Are4SlotsConnectInDiagonalDown(char[][]  Grid, char current_player) {
			//start cells => 12 cells
			// *Grid[5][0]; *Grid[5][1]; *Grid[5][2]; *Grid[5][3]; Grid[5][4]; Grid[5][5]; Grid[5][6]
			// *Grid[4][0]; *Grid[4][1]; *Grid[4][2]; *Grid[4][3]; Grid[4][4]; Grid[4][5]; Grid[4][6]
			// *Grid[3][0]; *Grid[3][1]; *Grid[3][2]; *Grid[3][3]; Grid[3][4]; Grid[3][5]; Grid[3][6]
			// Grid[2][0]; Grid[2][1]; Grid[2][2]; Grid[2][3]; Grid[2][4]; Grid[2][5]; Grid[2][6]
			// Grid[1][0]; Grid[1][1]; Grid[1][2]; Grid[1][3]; Grid[1][4]; Grid[1][5]; Grid[1][6]
			// Grid[0][0]; Grid[0][1]; Grid[0][2]; Grid[0][3]; Grid[0][4]; Grid[0][5]; Grid[0][6]
			int compt = 0;
			
			int i_initial =5;
			int j_initial= 0; 
			int i_temp = i_initial;
			int j_temp = j_initial;
			
			
			while (true) {
				if (Grid[i_temp][j_temp] == current_player) {
					compt++;
					i_temp--;
					j_temp++;
					//System.out.println("A partir de la ligne " +(StartLine+1)+ " pour l'instant compteur = "+compt);
					if (compt == 4) {
						//System.out.println("C'est le joueur "+ current_player + " qui a gagn�");
						return true;
					}
				} else {
					compt=0;
					i_initial--;
					i_temp = i_initial;
					j_temp= j_initial;
								
								
					//System.out.println("A la position" +"["+(i+1)+"]"+"["+(j+1)+"]"+ " => il y a : " + Grid[i][j] + " donc je mets le compteur � 0 et je traite la ligne suivante, la ligne : "+ (StartLine+1));
								
					if (i_temp <= 2) {
						//System.out.println("Sup�rieur ou �gal � la ligne 4 => Je vais � la colonne suivante");
						i_initial =5;
						i_temp = i_initial;
						j_initial++; 
						j_temp= j_initial;
						
						if (j_temp >= 4) break;
						
					}
										
				}
			}
			
			//System.out.println("There are not 4 slots connected in a diagonal going down (from left to right)");
			return false;
		}
	
}
