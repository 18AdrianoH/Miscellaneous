package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * a class for the queen
 * @version 1
 * @author Adriano Hernandez
 * @date 4 25 2016
 */
public class Queen extends Piece
{
	protected ArrayList<Location> destinations;
	/**
	 * the constructor!
	 * @param col the color of this queen
	 * @param fileName the name of the file from which we will get the image
	 * for the queen
	 * @param val the value of death for the queen (pretty high!)
	 */
	public Queen(Color col, String fileName, int val) {
		super(col, fileName, val);
		destinations = new ArrayList<Location>();
		// TODO Auto-generated constructor stub
	}
	/**
	 * put self in the grid at loc
	 * @param brd the grid we manifest in
	 * @peram loc the location we spawn at
	 */
	@Override
	public void putSelfInGrid(Board brd, Location loc){
		super.putSelfInGrid(brd,loc);
		updateDestinations();
	}
	/**
	 * update the destinations giving us all the possible
	 * destinations
	 */
	protected void updateDestinations(){
		destinations = new ArrayList<>();
		sweep(destinations, 0);
		sweep(destinations, 90);
		sweep(destinations, 180);
		sweep(destinations, 270);
		sweep(destinations, 45);
		sweep(destinations, 135);
		sweep(destinations, 225);
		sweep(destinations, 315);
	}
	/**
	 * @return an updated version of destinations
	 */
	public ArrayList<Location> destinations(){
		updateDestinations();
		return destinations;
	}
}
