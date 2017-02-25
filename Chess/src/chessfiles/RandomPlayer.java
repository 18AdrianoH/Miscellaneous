package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * a random player
 * @author Adriano Hernandez
 * @date 4 16 2015
 */
public class RandomPlayer extends Player {

	public RandomPlayer(Board board, Color color, String name) {
		super(board,color,name);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Move nextMove() {
		List<Move> moves = getBoard().allMoves(getColor());
		int choose = (int)(Math.random()*(moves.size()));
		
		// TODO Auto-generated method stub
		return moves.get(choose);
	}

}
