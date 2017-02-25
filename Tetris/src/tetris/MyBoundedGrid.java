package tetris;

import java.util.ArrayList;

//A MyBoundedGrid is a rectangular grid with a finite number of rows and columns.
public class MyBoundedGrid<E>
{
	private Object[][] occupantArray;  // the array storing the grid elements

	//Constructs an empty MyBoundedGrid with the given dimensions.
	//(Precondition:  rows > 0 and cols > 0.)
	public MyBoundedGrid(int rows, int cols)
	{
		occupantArray = new Object[rows][cols];
	}

	//returns the number of rows
	public int getNumRows()
	{
		return occupantArray.length;
	}

	//returns the number of columns
	public int getNumCols()
	{
		return occupantArray[0].length;
	}

	//returns true if loc is valid in this grid, false otherwise
	//precondition:  loc is not null
	public boolean isValid(Location loc)
	{
		return loc.getCol() >= 0 && loc.getCol() < getNumCols() 
				&& loc.getRow() >= 0 && loc.getRow() < getNumRows();
	}

	//returns the object at location loc (or null if the location is unoccupied)
	//precondition:  loc is valid in this grid
	@SuppressWarnings("unchecked")
	public E get(Location loc)
	{
		//obviously we are assuming that all objects of the thing are "E"
		return (E)occupantArray[loc.getRow()][loc.getCol()];

		//(You will need to promise the return value is of type E.)
	}

	//puts obj at location loc in this grid and returns the object previously at that location (or null if the
	//location is unoccupied)
	//precondition:  loc is valid in this grid
	@SuppressWarnings("unchecked")
	public E put(Location loc, E obj)
	{
		Object old = get(loc);
		remove(loc);
		occupantArray[loc.getRow()][loc.getCol()] = obj;
		if(obj instanceof Block) ((Block) obj).setGrid(this);
		//assuming this is an E type
		return (E)old;
	}

	//removes the object at location loc from this grid and returns the object that was removed (or null if the
	//location is unoccupied
	//precondition:  loc is valid in this grid
	@SuppressWarnings("unchecked")
	public E remove(Location loc)
	{
		Object old = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = null;
		return (E)old;
	}

	//returns an array list of all occupied locations in this grid
	public ArrayList<Location> getOccupiedLocations()
	{
		ArrayList<Location> locations = new ArrayList<>();
		for(int y = 0; y < occupantArray.length; y++){
			for(int x = 0; x < occupantArray[y].length; x++){
				if(occupantArray[y][x] != null){
					//of course we assume this a block thing
					locations.add(new Location(y,x));
				}
			}
		}
		return locations;
	}
}