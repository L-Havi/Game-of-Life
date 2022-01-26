package Main;

import java.util.concurrent.TimeUnit;

public class Game {
	
	boolean play = true;
	int neighbours = 0;
	
	public Game(char[][] gameArea) throws InterruptedException{
		do {
			for(int i = 0; i < gameArea.length; i++){
				for(int j = 0; j < gameArea[0].length; j++){
						//North
						if(i >= 1) {
							if(gameArea[i-1][j] == 'X' || gameArea[i-1][j] == 'D') {
								neighbours++;
							}
						}
						//South
						if(i <= (99 - 1)) {
							if(gameArea[i+1][j] == 'X' || gameArea[i+1][j] == 'D') {
								neighbours++;
							}
						}
						//West
						if(j >= 1) {
							if(gameArea[i][j-1] == 'X' || gameArea[i][j-1] == 'D') {
								neighbours++;
							}
						}
						//East
						if(j <= (99 - 1)) {
							if(gameArea[i][j+1] == 'X' || gameArea[i][j+1] == 'D') {
								neighbours++;
							}
						}
						//Northwest
						if(i >= 1 && j >= 1) {
							if(gameArea[i-1][j-1] == 'X' || gameArea[i-1][j-1] == 'D') {
								neighbours++;
							}
						}
						//Southeast
						if(i <= (99 - 1) && j <= (99 - 1)) {
							if(gameArea[i+1][j+1] == 'X' || gameArea[i+1][j+1] == 'D') {
								neighbours++;
							}
						}
						//Northeast
						if(i >= 1 && j <= (99 - 1)) {
							if(gameArea[i-1][j+1] == 'X' || gameArea[i-1][j+1] == 'D') {
								neighbours++;
							}
						}
						//Southwest
						if(i <= (99 - 1) && j >= 1) {
							if(gameArea[i+1][j-1] == 'X' || gameArea[i+1][j-1] == 'D') {
								neighbours++;
							}
						}
					//Actions for live cell dying
					if(gameArea[i][j] == 'X') {
						if(neighbours < 2) {
							gameArea[i][j] = 'D';
						}
						if(neighbours > 3) {
							gameArea[i][j] = 'D';
						}
					//Actions for dead cell becoming alive
					} else {
						if(neighbours == 3) {
							gameArea[i][j] = 'B';
						}	
					}
					neighbours = 0;
				}
			}
			//Changing marked cells to dead or alive from last iteration
			for(int i = 0; i < gameArea.length; i++){
				for(int j = 0; j < gameArea[0].length; j++){
					if(gameArea[i][j] == 'D') {
						gameArea[i][j] = '*';
					}
					if(gameArea[i][j] == 'B') {
						gameArea[i][j] = 'X';
					}
				}
			}
			//Displaying last iteration
			System.out.println("");
			for(int i = 0; i< gameArea.length; i++){
				for(int j = 0; j< gameArea[0].length; j++){
					System.out.print(gameArea[i][j]);
				}
				System.out.println("");
			}
			TimeUnit.SECONDS.sleep(1);
		}while(play);
	}
}
