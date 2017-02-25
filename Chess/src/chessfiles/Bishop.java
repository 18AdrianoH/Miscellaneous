package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * a bishop class
 * @version 1
 * @author Adriano Hernandez
 * @date 4 23 2016
 */
public class Bishop extends Piece{

	private ArrayList<Location> destinations;
	/**
	 * the constructor
	 * @param color the color of this bishop
	 * @param imageFileName the name of the image file for this
	 * @param value the value of death for the enemy team
	 */
	public Bishop(Color color, String imageFileName, int value) {
		super(color, imageFileName, value);
		destinations = new ArrayList<Location>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * return the destinations
	 * @return destinations
	 */
	@Override
	public ArrayList<Location> destinations() {
		// TODO Auto-generated method stub
		updateDestinations();
		return destinations;
	}
	/**
	 * put itself in the grid
	 * @param brd the board we go into
	 * @param loc the loctation we manifest ourselves at
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
		sweep(destinations, 45);
		sweep(destinations, 135);
		sweep(destinations, 225);
		sweep(destinations, 315);
	}
}
