package chessfiles;
import java.awt.*;
import java.util.*;

// Represesents a rectangular game board, containing Piece objects.
public class Board extends BoundedGrid<Piece>
{
	// Constructs a new Board with the given dimensions
	public Board()
	{
		super(8, 8);
	}

	// Precondition:  move has already been made on the board
	// Postcondition: piece has moved back to its source,
	//                and any captured piece is returned to its location
	public void undoMove(Move move)
	{
		Piece piece = move.getPiece();
		Location source = move.getSource();
		Location dest = move.getDestination();
		Piece victim = move.getVictim();

		piece.moveTo(source);

		if (victim != null)
			victim.putSelfInGrid(piece.getBoard(), dest);
	}
	
	
	/**
	 * get all the possible moves for either black or white
	 * @precondition color is either WHITE or BLACK
	 * @return all the possible moves for a certain color
	 */
	public ArrayList<Move> allMoves(Color color){
		ArrayList<Move> moves = new ArrayList<Move>();
		for(int r = 0; r < 8; r++){
			for(int c = 0; c < 8; c++){
				Piece piece = get(new Location(r,c));
				if(piece != null && piece.getColor() == color){
					piece.updateDestinations();
					for(Location loc: piece.destinations()){
						if(!loc.equals(piece.getLocation())) moves.add(new Move(piece,loc));
						
					}
				}
			}
		}
		return moves;
	}
	
	/**
	 * executes the given move
	 * @param move the move we will execute
	 */
	public void executeMove(Move move){
		if(move==null){return;}
		if(get(move.getDestination()) instanceof King){
			if(get(move.getDestination()).getColor() == Color.BLACK) 
				System.out.println("White wins");
			else
				System.out.println("Black Wins");
			Game.isGameOver = true;
		}
		move.getPiece().moveTo(move.getDestination());
		move.getPiece().updateDestinations();
		
		
	}
}