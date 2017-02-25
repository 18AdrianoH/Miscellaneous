package tetris;

/**
 * @version 1.0
 * @author Adriano Hernandez
 * @date 10 March 2016
 */
public class Tetris implements ArrowListener
{
	//main
	public static void main(String[]args){
		@SuppressWarnings("unused")
		Tetris tetris = new Tetris();
	}
	//tetrad types
	public static enum TETRAD_TYPE{
		I,T,O,L,J,S,Z
	}
	
	//the class
	private MyBoundedGrid<Block> grid;
	private BlockDisplay display;
	private Tetrad tetrad;
	private boolean over;
	
	/**
	 * constructor for tetris.  creates a grid and a tetrad and then displays them and launches the game
	 */
	public Tetris(){
		over = false;
		grid = new MyBoundedGrid<>(16,9);
		display = new BlockDisplay(grid);
		
		display.setTitle("Tetris");
		display.setArrowListener(this);
		display.showBlocks();
		tetrad = new Tetrad(grid);
		
		System.out.println("GAME IS STARTING.");
		System.out.println("RIGHT AND LEFT ARROW KEYS TO MOVE.  UP ARROW TO ROTATE, AND DOWN ARROW TO SPEED UP.");
		while(!over){
			play();
		}
		System.out.println("GAME IS OVER.  YOU LOST.");
	}
	/**
	 * this is what we call when we play the game
	 */
	//to play the game
	public void play(){
		
		try{
			//sleep 1 sec
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			//we dont care
		}
		
		
		display.showBlocks();
		
		//
		//System.out.println(Math.random()*7);
		//
		boolean canMove = tetrad.translate(1, 0);
		if(!canMove){
			//we want to test to make sure of a few things here
			/*
			//blocked by a block
			boolean blockedByBlock = false;
			for(Location loc: tetrad.getBlocks()){
				if(loc.getAdjacentLocation(180) != null && !arrayContains(tetrad.getBlocks(),loc.getAdjacentLocation(180))){
					//System.out.println("blocked by blocks");
					blockedByBlock = true;
				}
			}
			//blocked by the edge of the map; not 180 is downwards
			boolean blockedByEdge = false;
			for(Location loc: tetrad.getBlocks()){
				if(!grid.isValid(loc.getAdjacentLocation(180))){
					blockedByEdge = true;
				}
			}
			
			//just because this way it looks prettier
			boolean blocked = blockedByBlock || blockedByEdge;
			*/
			boolean blocked = true;
			//only do this in certain cases wherer the tetrad is blocked and is not stopped by the sephamore
			if(blocked){
				if(gameIsOver()){
					over = true;
					return;
				}
				clearAllCompletedRows();
				tetrad = new Tetrad(grid);
			}
			
		}
	}
	/**
	 * check if the game is over
	 * @return true if the game is over and lost; otherwise,
	 *         false.
	 */
	private boolean gameIsOver(){
		for(int i = 0; i < grid.getNumCols(); i++){
			if(grid.get(new Location(0,i)) != null){
				return true;
			}
		}
		return false;
	}
	/**
	 * this will tell us if the given array has the given item
	 * @param array is the array we search
	 * @param item is the item we are searching for
	 * @return true if array contains item; otherwise,
	 *         false.
	 */
	public static boolean arrayContains(Object[] array, Object item){
		for(Object o: array){
			if(o.equals(item)){
				return true;
			}
		}
		return false;
	}
	/**
	 * check if row is completed
	 * @param row the row we check
	 * @return true if row is completed; otherwise,
	 * 	       false.
	 */
	private boolean isCompleted(int row){
		for(int i = 0; i<grid.getNumCols() ; i++){
			if(grid.get(new Location(row,i)) == null) return false;
		}
		return true;
	}
	/**
	 * clear row
	 * @param row the row we will clear
	 */
	private void clearRow(int row){
		if(row < 1){
			over = true;
			return;
		}
		if(isCompleted(row)){
			for(int i = 0; i < grid.getNumCols(); i++){
				if(grid.get(new Location(row,i)) != null) grid.remove(new Location(row,i));
			}
			for(int n = row-1; n > 0; n --){
				for(int i = 0; i < grid.getNumCols(); i++){
					if(grid.get(new Location(n,i)) != null){
						Block copy = new Block();
						copy.setGrid(grid);
						copy.setLocation(grid.get(new Location(n,i)).getLocation());
						copy.setColor(grid.get(new Location(n,i)).getColor());
						grid.put(new Location(n+1,i), copy);
						grid.remove(new Location(n,i));
					}
				}
			}
		}
	}
	/**
	 * clears all completed rows on the game board
	 */
	private void clearAllCompletedRows(){
		//System.out.println("clearing rows");
		for(int i = 0; i < grid.getNumRows(); i++){
			if(over == true){
				return;
			}
			if(isCompleted(i)) clearRow(i);
		}
	}


	//these are our arrow methods
	@Override
	/**
	 * what to do when the up arrow key is pressed
	 */
	public void upPressed() {
		// TODO Auto-generated method stub
		tetrad.rotate();
	}

	@Override
	/**
	 * what to do when the down arrow key is pressed
	 */
	public void downPressed() {
		// TODO Auto-generated method stub
		tetrad.translate(1,0);
		//System.out.println(rotated);
	}

	@Override
	/**
	 * what to do when the left arrow key is pressed
	 */
	public void leftPressed() {
		// TODO Auto-generated method stub
		tetrad.translate(0, -1);
		
	}

	@Override
	/**
	 * what to do when the right arrow key is pressed
	 */
	public void rightPressed() {
		// TODO Auto-generated method stub
		tetrad.translate(0, +1);
	}
	
}
