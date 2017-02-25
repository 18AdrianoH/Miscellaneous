package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * a player superclass
 * @author Adriano Hernandez
 * @date 4 16 2015
 * @version 1
 */
public abstract class Player 
{
	private String name;
	private Board board;
	private Color color;
	
	private ArrayList<Move> moves;
	/**
	 * constructor
	 * @param board the board we go on
	 * @param color the color of this piece
	 * @param name the name of this piece
	 */
	public Player(Board board, Color color, String name){
		this.board = board;
		this.color = color;
		moves = new ArrayList<Move>();
		updateMoves();
		this.name = name;
	}
	/**
	 * update the possible moves
	 */
	protected void updateMoves(){
		moves = board.allMoves(color);
	}
	/**
	 * get the next move
	 * @return the next possible move with information for go from and go to locs
	 */
	public abstract Move nextMove();

	/**
	 * get the name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * get the board
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * get the color
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	
}
