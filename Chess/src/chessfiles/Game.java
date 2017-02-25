package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * @version 1
 * @author Adriano Hernandez
 * @date 4 25 2016
 * This is the main class through which we play the game
 *
 */
public class Game {

	public static boolean isGameOver = false;
	/**
	 * main method, launch the method
	 * @param args arguments
	 */
	public static void main(String[] args) /*throws InterruptedException*/ {
		// TODO Auto-generated method stub
		Board board = new Board();
		
		Bishop blackbishop = new Bishop(Color.BLACK,"src/chessfiles/black_bishop.gif",3);
		Bishop blackbishop2 = new Bishop(Color.BLACK,"src/chessfiles/black_bishop.gif",3);
		Bishop whitebishop = new Bishop(Color.WHITE,"src/chessfiles/white_bishop.gif",3);
		Bishop whitebishop2 = new Bishop(Color.WHITE,"src/chessfiles/white_bishop.gif",3);
		Knight blackKnight = new Knight(Color.BLACK,"src/chessfiles/black_knight.gif",3);
		Knight blackKnight2 = new Knight(Color.BLACK,"src/chessfiles/black_knight.gif",3);
		Knight whiteKnight = new Knight(Color.WHITE,"src/chessfiles/white_knight.gif",3);
		Knight whiteKnight2 = new Knight(Color.WHITE,"src/chessfiles/white_knight.gif",3);
		Queen whiteQueen = new Queen(Color.WHITE,"src/chessfiles/white_queen.gif",10);
		Queen blackQueen = new Queen(Color.BLACK,"src/chessfiles/black_queen.gif",10);
		
		//everything above this has to be fixed up
		
		King blackKing = new King(Color.BLACK,"src/chessfiles/black_king.gif");
		King whiteKing  = new King(Color.WHITE,"src/chessfiles/white_king.gif");
		
		Rook blackRook1 = new Rook(Color.BLACK,"src/chessfiles/black_rook.gif");
		Rook blackRook2 = new Rook(Color.BLACK,"src/chessfiles/black_rook.gif");
		Rook whiteRook1 = new Rook(Color.WHITE,"src/chessfiles/white_rook.gif");
		Rook whiteRook2 = new Rook(Color.WHITE,"src/chessfiles/white_rook.gif");
		
		blackKing.putSelfInGrid(board, new Location(0,4));
		whiteKing.putSelfInGrid(board, new Location(7,4));
		
		blackRook1.putSelfInGrid(board, new Location(0,7));
		blackRook2.putSelfInGrid(board, new Location(0,0));
		whiteRook1.putSelfInGrid(board, new Location(7,0));
		whiteRook2.putSelfInGrid(board, new Location(7,7));
		whitebishop.putSelfInGrid(board,new Location(7,2));
		whitebishop2.putSelfInGrid(board, new Location(7,5));
		blackbishop.putSelfInGrid(board,new Location(0,2));
		blackbishop2.putSelfInGrid(board, new Location(0,5));
		whiteQueen.putSelfInGrid(board, new Location(7,3));
		blackQueen.putSelfInGrid(board,new Location(0,3));
		whiteKnight.putSelfInGrid(board, new Location(7,1));
		whiteKnight2.putSelfInGrid(board, new Location(7,6));
		blackKnight.putSelfInGrid(board, new Location(0,1));
		blackKnight2.putSelfInGrid(board, new Location(0,6));
		BoardDisplay display = new BoardDisplay(board);
		//ADD THE PAWNS HERE
		for(int i = 0; i < 8; i++){
			Pawn potato = new Pawn(Color.WHITE,"src/chessfiles/white_pawn.gif",1);
			Pawn potato2 = new Pawn(Color.BLACK,"src/chessfiles/black_pawn.gif",1);
			potato.putSelfInGrid(board, new Location(6,i));
			potato2.putSelfInGrid(board, new Location(1,i));
			for(Location loc: potato.destinations()){
				display.setColor(loc, Color.BLUE);
			}
			for(Location loc: potato2.destinations()){
				display.setColor(loc, Color.RED);
			}
		}
		
		Player rand = new HumanPlayer(board,Color.WHITE, "the illuminati",display);
		Player human = new HumanPlayer(board,Color.BLACK, "obama", display);
		
		
		
		//get human player later
		play(board, display, rand,human);
		
		
	}
	/**
	 * play the gmae
	 * @param board the board we play on
	 * @param display the display we display with
	 * @param player1 the first player to play
	 * @param player2 the second player to play
	 */
	public static void play(Board board, BoardDisplay display, Player player1, Player player2){
		System.out.println("game is starting");
		Player player = player2;
		try{Thread.sleep(1000);} catch(InterruptedException e){}
		while(!isGameOver){
			if(player == player2){
				player = player1;
			}
			else{
				player = player2;
			}
			nextTurn(board,display,player);
		}
	}
	
	
	/**
	 * play the next turn
	 * @param board the board we are playing on
	 * @param display the display that displays the game
	 * @param player the player that is making the move
	 */
	public static void nextTurn(Board board, BoardDisplay display, Player player){
		
		display.setTitle(player.getName() + " is playing");
		
		Move nextMove = player.nextMove();
		board.executeMove(nextMove);
		display.setColor(nextMove.getDestination(), Color.YELLOW);
		display.setColor(nextMove.getSource(), Color.ORANGE);
		
		try{Thread.sleep(1000);} 
		catch(InterruptedException e){
			System.out.println("WHY DON'T WE HAVE PARALLEL COMPUTING YET");}
		finally{
			
			display.setColor(nextMove.getDestination(), null);
			display.setColor(nextMove.getSource(), null);
		}
	}
		

}
