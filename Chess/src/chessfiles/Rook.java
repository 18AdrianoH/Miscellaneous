package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * @version 1
 * @author Adriano Hernandez
 * @date 4 25 2016
 */
public class Rook extends Piece
{
	protected ArrayList<Location> destinations;
	/**
	 * constructor!
	 * @param col the color of this rook
	 * @param fileName the filename for the image for this rook
	 */
	public Rook(Color col, String fileName) {
		super(col, fileName, 5);
		destinations = new ArrayList<Location>();
		// TODO Auto-generated constructor stub
	}
	/**
	 * puts itself in the grid
	 * @param brd the board we put ourselves in
	 * @param loc the location we go to
	 */
	@Override
	public void putSelfInGrid(Board brd, Location loc){
		super.putSelfInGrid(brd,loc);
		updateDestinations();
	}
	/**
	 * update the destinations
	 */
	protected void updateDestinations(){
		destinations = new ArrayList<>();
		sweep(destinations, 0);
		sweep(destinations, 90);
		sweep(destinations, 180);
		sweep(destinations, 270);
	}
	/**
	 * return the destinations in an updated state
	 */
	public ArrayList<Location> destinations(){
		updateDestinations();
		return destinations;
	}
}
