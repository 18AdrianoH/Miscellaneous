package blocklab;

import java.awt.Color;

public class Block
{
    private MyBoundedGrid<Block> grid;
    private Location location;
    private Color color;

    //constructs a blue block, because blue is the greatest color ever!
    public Block()
    {
        color = Color.BLUE;
        grid = null;
        location = null;
    }

    //gets the color of this block
    public Color getColor()
    {
        return color;
    }

    //gets the color of this block to newColor.
    public void setColor(Color newColor)
    {
        color = newColor;
    }

    //gets the grid of this block, or null if this block is not contained in a grid
    public MyBoundedGrid<Block> getGrid()
    {
        return grid;
    }

	//gets the location of this block, or null if this block is not contained in a grid
    public Location getLocation()
    {
        return location;
    }

	//removes this block from its grid
	//precondition:  this block is contained in a grid
    public void removeSelfFromGrid()
    {
        grid.remove(this.getLocation());
        location = null;
        grid = null;
        
    }

	//puts this block into location loc of grid gr
	//if there is another block at loc, it is removed
	//precondition:  (1) this block is not contained in a grid
	//               (2) loc is valid in gr
    public void putSelfInGrid(MyBoundedGrid<Block> gr, Location loc)
    {
    	if(gr.get(loc) != null){
    		gr.get(loc).removeSelfFromGrid();
    	}
    	
        gr.put(loc, this);
        grid = gr;
        location = loc;
    }

	//moves this block to newLocation
	//if there is another block at newLocation, it is removed
	//precondition:  (1) this block is contained in a grid
	//               (2) newLocation is valid in the grid of this block
    public void moveTo(Location newLocation)
    {
    	if(!newLocation.equals(location)){
    		if(grid.get(newLocation) != null){
        		grid.get(newLocation).removeSelfFromGrid();
        	}
        	grid.put(location, null);
        	grid.put(newLocation, this);
            location = newLocation;
    	}
    }

	//returns a string with the location and color of this block
    public String toString()
    {
        return "Block[location=" + location + ",color=" + color + "]";
    }
}