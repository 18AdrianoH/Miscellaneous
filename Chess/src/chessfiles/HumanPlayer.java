package chessfiles;

import java.awt.Color;
/**
 * a player controlled by a human
 * @version 1
 * @author Adriano Hernandez
 * @date 4 20 2016
 */
public class HumanPlayer extends Player 
{

	private BoardDisplay display;
	/**
	 * the constructor for the human player
	 * @param board the board we play on
	 * @param color the color we play with
	 * @param name the name we take
	 * @param display the display that displays the game
	 */
	public HumanPlayer(Board board, Color color, String name, BoardDisplay display) 
	{
		super(board, color, name);
		this.display = display;
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the next move
	 * @return the next move we will do
	 */
	@Override
	public Move nextMove() 
	{
		Move move = null;
		while(!getBoard().allMoves(getColor()).contains(move)){
			move = display.selectMove();
		}
		// TODO Auto-generated method stub
		return move;
	}

}
