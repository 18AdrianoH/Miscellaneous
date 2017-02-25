package chessfiles;
import java.awt.*;
import java.util.*;

public abstract class Piece
{
	//the board this piece is on
	private Board board;

	//the location of this piece on the board
	private Location location;

	//the color of the piece
	private Color color;

	//the file used to display this piece
	private String imageFileName;

	//the approximate value of this piece in a game of chess
	private int value;

	//constructs a new Piece with the given attributes.
	public Piece(Color col, String fileName, int val)
	{
		color = col;
		imageFileName = fileName;
		value = val;
	}

	//returns the board this piece is on
	public Board getBoard()
	{
		return board;
	}

	//returns the location of this piece on the board
	public Location getLocation()
	{
		return location;
	}

	//returns the color of this piece
	public Color getColor()
	{
		return color;
	}

	//returns the name of the file used to display this piece
	public String getImageFileName()
	{
		return imageFileName;
	}

	//returns a number representing the relative value of this piece
	public int getValue()
	{
		return value;
	}

    /**
     * Puts this piece into a board. If there is another piece at the given
     * location, it is removed. <br />
     * Precondition: (1) This piece is not contained in a grid (2)
     * <code>loc</code> is valid in <code>gr</code>
     * @param brd the board into which this piece should be placed
     * @param loc the location into which the piece should be placed
     */
    public void putSelfInGrid(Board brd, Location loc)
    {
        if (board != null)
            throw new IllegalStateException(
                    "This piece is already contained in a board.");

        Piece piece = brd.get(loc);
        if (piece != null)
            piece.removeSelfFromGrid();
        brd.put(loc, this);
        board = brd;
        location = loc;
    }

    /**
     * Removes this piece from its board. <br />
     * Precondition: This piece is contained in a board
     */
    public void removeSelfFromGrid()
    {
        if (board == null)
            throw new IllegalStateException(
                    "This piece is not contained in a board.");
        if (board.get(location) != this)
            throw new IllegalStateException(
                    "The board contains a different piece at location "
                            + location + ".");

        board.remove(location);
        board = null;
        location = null;
    }

    /**
     * Moves this piece to a new location. If there is another piece at the
     * given location, it is removed. <br />
     * Precondition: (1) This piece is contained in a grid (2)
     * <code>newLocation</code> is valid in the grid of this piece
     * @param newLocation the new location
     */
    public void moveTo(Location newLocation)
    {
        if (board == null)
            throw new IllegalStateException("This piece is not on a board.");
        if (board.get(location) != this)
            throw new IllegalStateException(
                    "The board contains a different piece at location "
                            + location + ".");
        if (!board.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation
                    + " is not valid.");

        if (newLocation.equals(location))
            return;
        board.remove(location);
        Piece other = board.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();
        location = newLocation;
        board.put(location, this);
    }
    /**
     * check if dest is valid
     * @param dest the destination we will check
     * @return true if dest is valid; otherwise,
     *         false.
     */
    public boolean isValidDestination(Location dest){
    	return board.isValid(dest) && (board.get(dest) == null || board.get(dest) instanceof Piece);
    }
    /**
     * this is meant to be overriden; for each piece it will return all
     * the valid destinations for the given piece
     * @return nothing for now
     */
    public abstract ArrayList<Location> destinations();
    protected abstract void updateDestinations();
    /**
     * gets all locations until it hits an obstacle in the direction given
     * @param dests the arraylist we add these locations to
     * @param direction the direction we travel in
     */
    public void sweep(ArrayList<Location> dests, int direction){
    	Location loc = getLocation().getAdjacentLocation(direction);
    	while(board.isValid(loc) && !(board.get(loc) instanceof Piece)){
    		dests.add(loc);
    		loc = loc.getAdjacentLocation(direction);
    	}
    	if(board.isValid(loc) && (board.get(loc) instanceof Piece) 
    			&& !(board.get(loc).getColor().equals(color))) 
    		dests.add(loc);//we want to be able to eat pieces
    }
    
}