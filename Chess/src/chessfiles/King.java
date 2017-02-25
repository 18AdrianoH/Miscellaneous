package chessfiles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * a king class
 * @author Adriano Hernandez
 * @version 1.0
 * @date 4/5/2016
 */
public class King extends Piece 
{
	private ArrayList<Location> destinations;
	
	/**
	 * normal constructor
	 * @param col column
	 * @param fileName the name of the image file
	 */
	public King(Color col, String fileName) {
		super(col, fileName, 1000);
		//updateAdjacentLocations();
		destinations = new ArrayList<Location>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * put yourslf in the grid
	 * @param brd the grid we put ourselves in
	 * @param loc the location we manifest at
	 */
	@Override
	public void putSelfInGrid(Board brd, Location loc){
		super.putSelfInGrid(brd,loc);
		updateDestinations();
	}
	/**
	 * update the adjacent locations
	 */
	protected void updateDestinations(){
		destinations = new ArrayList<>();
		Location loc = getLocation();
		for(int i = 0; i < 360; i+=45){
			Location adjacent = loc.getAdjacentLocation(i);
			if(isValidDestination(adjacent)) destinations.add(adjacent);
		}
		
	}
	/**
	 * get the possible destinations
	 * @return adjacent locations
	 */
	public ArrayList<Location> destinations(){
		updateDestinations();
		return destinations;
	}
}
