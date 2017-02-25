package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * a knight class
 * @version 1
 * @author Adriano Hernandez
 * @date 4 25 2016
 */
public class Knight extends Piece{

	/**
	 * dests
	 */
	private ArrayList<Location> destinations;
	/**
	 * the constructor for our knight
	 * @param color the color of this knight
	 * @param imageFileName the image file name of this knight
	 * @param value the value of death of this knight to the enemy team
	 */
	public Knight(Color color, String imageFileName, int value) {
		super(color, imageFileName, value);
		destinations = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	/**
	 * put self in the grid at location
	 * @param brd the grid we put ourself at
	 * @param loc the location we manifest at
	 */
	@Override
	public void putSelfInGrid(Board brd, Location loc){
		super.putSelfInGrid(brd,loc);
		updateDestinations();
	}
	/**
	 * get the destinations updated
	 * @return destinations
	 */
	@Override
	public ArrayList<Location> destinations() {
		// TODO Auto-generated method stub
		updateDestinations();
		return destinations;
	}
	/**
	 * update the destinations
	 */
	@Override
	protected void updateDestinations() {
		destinations = new ArrayList<>();
		Location loc1 = new Location(getLocation().getRow()+2,
				getLocation().getCol()+1);
		Location loc2 = new Location(getLocation().getRow()+2,
				getLocation().getCol()-1);
		Location loc3 = new Location(getLocation().getRow()-2,
				getLocation().getCol()+1);
		Location loc4 = new Location(getLocation().getRow()-2,
				getLocation().getCol()-1);
		Location loc5 = new Location(getLocation().getRow()-1,
				getLocation().getCol()-2);
		Location loc6 = new Location(getLocation().getRow()-1,
				getLocation().getCol()+2);
		Location loc7 = new Location(getLocation().getRow()+1,
				getLocation().getCol()-2);
		Location loc8 = new Location(getLocation().getRow()+1,
				getLocation().getCol()+2);
		
		if(canAdd(loc1)) destinations.add(loc1);
		if(canAdd(loc2)) destinations.add(loc2);
		if(canAdd(loc3)) destinations.add(loc3);
		if(canAdd(loc4)) destinations.add(loc4);
		
		if(canAdd(loc5)) destinations.add(loc5);
		if(canAdd(loc6)) destinations.add(loc6);
		if(canAdd(loc7)) destinations.add(loc7);
		if(canAdd(loc8)) destinations.add(loc8);
		
		// TODO Auto-generated method stub
		
	}
	/**
	 * check if we can add locatiton to possible locs
	 * @param loc the location we want to see if we can go to
	 * @return true of we can go to loc; otherwise,
	 * 	       false.
	 */
	private boolean canAdd(Location loc){
		try{
			return getBoard().isValid(loc) && 
					!(getBoard().get(loc).getColor().equals(getColor()));
		}
		catch(NullPointerException e){
			return getBoard().isValid(loc) && getBoard().get(loc) == null;
		}
	}

}
