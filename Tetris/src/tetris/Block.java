package tetris;

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
    public Block(Color color){
    	this.color = color;
    	grid = null;
    	location = null;
    }
	public Block(Color color, MyBoundedGrid<Block> grid, Location loc){
    	this.color = color;
    	this.grid = grid;
    	this.location = loc;
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
    public void setLocation(Location loc){
    	location = loc;
    }

	//removes this block from its grid
	//precondition:  this block is contained in a grid
    public void removeSelfFromGrid()
    {
        grid.remove(this.getLocation());
        location = null;
        grid = null;
        
    }
    /**
     * set grid
     * @param grid what we set  it to
     */
    public void setGrid(MyBoundedGrid grid){
    	this.grid = grid;
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
    		if(!grid.isValid(newLocation) || grid.get(newLocation) != null){
    			grid.remove(newLocation);

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
    public int hashCode(){
    	return super.hashCode();
    }
    public boolean equals(Object b){
    	return this.getLocation().equals(((Block) b).getLocation());
    }
}