package tetris;

import java.awt.Color;
import java.util.concurrent.Semaphore;
import tetris.Tetris.TETRAD_TYPE;

/**
 * @version 1.0
 * @author Adriano Hernandez
 * @date 10 March 2016
 * 
 */
public class Tetrad 
{
	/**
	 * instance vars
	 */
	private TETRAD_TYPE type;
	private Color color;
	private Location[] blocks;
	private MyBoundedGrid<Block> grid;
	private Semaphore lock; // for the multithreading
	
	/**
	 * constructor for grid grid
	 * @param grid is the grid we will play on
	 */
	public Tetrad(MyBoundedGrid<Block> grid){
		//create a random color random type tetrad
		
		//each tetrad type has its own color; I have made them allign in position so 
		//that we can have the same color for the same tetrads every time
		int randInt = (int)(Math.random()*7);
		
		TETRAD_TYPE[] types = {TETRAD_TYPE.I,TETRAD_TYPE.L,TETRAD_TYPE.T,TETRAD_TYPE.O,
				TETRAD_TYPE.J,TETRAD_TYPE.S,TETRAD_TYPE.Z};
		
		Color[] colors = {Color.RED,Color.YELLOW,Color.GRAY,
				Color.CYAN,Color.MAGENTA,Color.BLUE,Color.GREEN};
		this.color = colors[randInt];
		this.type = types[randInt];
		
		types = null;
		colors = null;
		randInt = 0;
		
		lock = new Semaphore(1,true);
		
		//state of existence
		this.grid = grid;
		
		blocks = chooseLocations();
		addToLocations(grid,blocks);
	}
	
	/**
	 * chooses the locations depending on the type of tetrad
	 * note that [0] is the center of rotation
	 * @return the locations for this tetrad
	 */
	//note this is made so that blocks[0] is the center of rotation
	private Location[] chooseLocations(){
		Location[] locs = new Location[4];
		if(type == TETRAD_TYPE.I){
			locs[1] = new Location(0,grid.getNumCols()/2);
			locs[0] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(2,grid.getNumCols()/2);
			locs[3] = new Location(3,grid.getNumCols()/2);
		}
		else if(type == TETRAD_TYPE.L){
			locs[1] = new Location(0,grid.getNumCols()/2);
			locs[0] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(2,grid.getNumCols()/2);
			locs[3] = new Location(2,(grid.getNumCols()/2)+1);
		}
		else if(type == TETRAD_TYPE.T){
			locs[0] = new Location(0,grid.getNumCols()/2);
			locs[1] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(0,(grid.getNumCols()/2)+1);
			locs[3] = new Location(0,(grid.getNumCols()/2)-1);
		}
		else if(type == TETRAD_TYPE.O){
			locs[0] = new Location(0,grid.getNumCols()/2);
			locs[1] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(0,(grid.getNumCols()/2)+1);
			locs[3] = new Location(1,(grid.getNumCols()/2)+1);
		}
		else if(type == TETRAD_TYPE.J){
			locs[1] = new Location(0,grid.getNumCols()/2);
			locs[0] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(2,grid.getNumCols()/2);
			locs[3] = new Location(2,(grid.getNumCols()/2)-1);
		}
		else if(type == TETRAD_TYPE.S){
			locs[0] = new Location(0,grid.getNumCols()/2);
			locs[1] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(0,(grid.getNumCols()/2)+1);
			locs[3] = new Location(1,(grid.getNumCols()/2)-1);
		}
		else if(type == TETRAD_TYPE.Z){
			locs[0] = new Location(0,grid.getNumCols()/2);
			locs[1] = new Location(1,grid.getNumCols()/2);
			locs[2] = new Location(1,(grid.getNumCols()/2)+1);
			locs[3] = new Location(0,(grid.getNumCols()/2)-1);
		}
		return locs;
	}
	/**
	 * add blocks to locations in grid
	 * @param grid the grid we will add blocks to
	 * @param locations where in the grid we will add the blocks to
	 */
	private void addToLocations(MyBoundedGrid<Block> grid, Location[] locations){
		for(Location loc: locations){
			grid.put(loc,new Block(color,grid,loc));
		}
	}
	/**
	 * removes all our blocks
	 * @return the old blocks
	 */
	@SuppressWarnings("unused")
	private Location[] removeBlocks(){
		if(blocks == null){
			return null;
		}
		
		//find the old
		Location[] oldLocs = new Location[blocks.length];
		for(int i = 0; i < blocks.length; i++){
			oldLocs[i] = blocks[i];
		}
		//remove old
		for(Location loc: blocks){
			grid.get(loc).removeSelfFromGrid();
		}
		return oldLocs;
		
	}
	/**
	 * checks if locations are empty on the grid
	 * @param grid the grid we check locations on
	 * @param locations the locations we want to check
	 * @return true if the locations are empty; otherwise,
	 *         false.
	 */
	@SuppressWarnings("unused")
	private boolean areEmpty(MyBoundedGrid<Block> grid,
			Location[] locations){
		for(Location loc: locations){
			if(!grid.isValid(loc) || grid.get(loc) != null){
				return false;
			}
		}
		return true;
	}
	/**
	 * translate moving up/down delta row and right/left deltaCol
	 * @param deltaRow change in y
	 * @param deltaCol change in x
	 * @return true if it was able to move or the sephamore was on lock, otherwise false 
	 */
	public boolean translate(int deltaRow, int deltaCol){
		try{
			lock.acquire();
			
			for(Location loc: blocks){
				Location newLoc = new Location(loc.getRow() + deltaRow, loc.getCol() + deltaCol);
				if(!grid.isValid(newLoc) || (grid.get(newLoc) != null && !Tetris.arrayContains(blocks,newLoc))){
					return false;
				}
			}
			
			
			//deltaRow to down, deltaCol to the right
			Location[] oldLocs = removeBlocks();
			Location[] newLocs = new Location[oldLocs.length];
			int i = 0;
			for(Location loc: oldLocs){
				Location newLoc = new Location(loc.getRow() + deltaRow, loc.getCol() + deltaCol);
				newLocs[i] = newLoc;
				i++;
			}
			blocks = newLocs;
			addToLocations(grid, blocks);
			return true;
		}
		catch(InterruptedException e){
			/**
			 * we want it to return true here to avoid it thinking that it was literally unable to move
			 * due to terrain obstruction; this is so that we wont spawn tetrads randomly when the tetrad
			 * is still in motion
			 */
			//return true;
			
			
			//returning true changed nothing, depending on what happens in the future I might make it
			//work that way againk, but for now I'll keep it at false
			return false;
		}
		finally{
			lock.release();
		}
	}
	/**
	 * rotates
	 * @return true if it was able to rotate
	 */
	public boolean rotate(){
		//FIX THIS METHOD TO WORK IN THE SAME STYLE AS TRANSLATE WITH DELETION AND CREATION INSTEAD OF MOVETO
		//FIX TO MAKE THIS METHOD ACTUALLY DO SOMETHING
		try{
			lock.acquire();
			
			Location center = blocks[0];
			Location new1 = new Location(center.getRow()-center.getCol()+blocks[1].getCol(),
					center.getRow()+center.getCol()-blocks[1].getRow());
			Location new2 = new Location(center.getRow()-center.getCol()+blocks[2].getCol(),
					center.getRow()+center.getCol()-blocks[2].getRow());
			Location new3 = new Location(center.getRow()-center.getCol()+blocks[3].getCol(),
					center.getRow()+center.getCol()-blocks[3].getRow());
			Location[] newLocs = new Location[]{center,new1,new2,new3};
					
					
			//if they are not all null
			//FIX THIS SECTION
			for(int i = 0; i < newLocs.length; i++){
				if(!grid.isValid(newLocs[i])){
					//System.out.println("not valid");
					return false;
				}
				//it thinks these new locks are not null 
				if((grid.get(newLocs[i]) != null) && (!Tetris.arrayContains(blocks, newLocs[i]))){
					System.out.println("non null");
					return false;
				}
			}
			
			//the moving
			removeBlocks();
			blocks = newLocs;
			addToLocations(grid,blocks);
			
			return true;
		}
		catch(InterruptedException e){
			//System.out.println("interrupted");
			return false;
		}
		finally{
			lock.release();
		}
	}
	

	//getters and setters
	
	/**
	 * gets the color
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * gets the blocks locations
	 * @return the locations of the blocks
	 */
	public Location[] getBlocks() {
		return blocks;
	}
	/**
	 * the grid
	 * @return grid
	 */
	public MyBoundedGrid<Block> getGrid() {
		return grid;
	}
	/**
	 * the type of tetrad this is
	 * @return type of tetrad
	 */
	public TETRAD_TYPE getType() {
		return type;
	}
}
