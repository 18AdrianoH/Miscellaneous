package chessfiles;

import java.awt.Color;
import java.util.ArrayList;
/**
 * @version 1
 * @author Adriano Hernandez
 * 
 */
public class Pawn extends Piece{

	private ArrayList<Location> destinations;
	/**
	 * THIS IS A CONSTRUCTOR DUH
	 * @param color the color of this pawn
	 * @param imageFileName the name of the file holding the image of this
	 * @param value the value of a pawn (pretty low)
	 */
	public Pawn(Color color, String imageFileName, int value) {
		super(color, imageFileName, value);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return possible destinations to go to
	 */
	@Override
	public ArrayList<Location> destinations() {
		// TODO Auto-generated method stub
		updateDestinations();
		return destinations;
	}

	/**
	 * update le destinations
	 */
	@Override
	protected void updateDestinations() {
		//BOTH CAN GO WEST BUT NOT EAST FOR SOME REASON
		destinations = new ArrayList<>();
		if(getColor().equals(Color.BLACK)){
			Location loc1 = getLocation().getAdjacentLocation(Location.SOUTH);
			Location loc2 = loc1.getAdjacentLocation(Location.SOUTH); //maybe
			Location loc3 = getLocation().getAdjacentLocation(Location.SOUTHEAST); //maybe
			Location loc4 = getLocation().getAdjacentLocation(Location.SOUTHWEST); //maybe
			if(canAdd(loc1) && getBoard().get(loc1) == null) destinations.add(loc1);
			if(canAdd(loc1) && canAdd(loc2) &&(getLocation().getRow()==1))destinations.add(loc2);
			if(canAdd2(loc3)) destinations.add(loc3);
			if(canAdd2(loc4)) destinations.add(loc4);
		}
		else{
			Location loc1 = getLocation().getAdjacentLocation(Location.NORTH);
			Location loc2 = loc1.getAdjacentLocation(Location.NORTH); //maybe
			Location loc3 = getLocation().getAdjacentLocation(Location.NORTHEAST); //maybe
			Location loc4 = getLocation().getAdjacentLocation(Location.NORTHWEST); //maybe
			if(canAdd(loc1) && getBoard().get(loc1) == null) destinations.add(loc1);
			if(canAdd(loc2) &&(getLocation().getRow()==6))destinations.add(loc2);
			if(canAdd2(loc3)) destinations.add(loc3);
			if(canAdd2(loc4)) destinations.add(loc4);
			
			
		}
		if(destinations.contains(getLocation())){
			destinations.remove(getLocation());
		}
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
	/**
	 * check if we can add this location to destinations, where
	 * loc is a location and its a diagonal for a pawn
	 * @param loc a location we want to check if we can add, assuming it is a
	 * diagonal for a pawn
	 * @return true if we can add this diagonal for a pawn, or false if
	 * we cant.
	 */
	private boolean canAdd2(Location loc){
		return getBoard().isValid(loc) &&
				getBoard().get(loc) != null && 
					!getBoard().get(loc).getColor().equals(getColor());
	}

}
