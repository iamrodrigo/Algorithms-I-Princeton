public class Percolation {
	
	public static final boolean OPEN = true;
	public static final boolean CLOSED = false;
	
	public int[][] sites;
	public boolean[][] open;
	
	public Percolation(int n) {
		int v = 0;
		sites = new int[n][n];
		open = new boolean[n][n];
		
		for(int i = 0; i < n ; i++) {
		   for(int j = 0; j < n; j++) {
			   sites[i][j] = v++;
			   open[i][j] = CLOSED;
		   	}
		}
	}
   
   public void open(int row, int col)
   {
	   open[row][col] = OPEN;
	   
	   // top
	   if(row > 0 && open[row - 1][col] == OPEN) {
		   sites[row-1][col] = sites[row][col]; 
	   }
	   
	   // left
	   if(col > 0 && open[row][col - 1] == OPEN) {
		   sites[row][col - 1] = sites[row][col]; 
	   }
	   
	   // right
	   if(col < sites.length && open[row][col + 1] == OPEN) {
		   sites[row][col + 1] = sites[row][col]; 
	   }
	   
	   // down
	   if(row < sites.length && open[row + 1][col] == OPEN) {
		   sites[row + 1][col] = sites[row][col]; 
	   }   
   }
	
   /*public    void open(int row, int col)    // open site (row, col) if it is not open already
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   public boolean isFull(int row, int col)  // is site (row, col) full?
   public     int numberOfOpenSites()       // number of open sites
   public boolean percolates()              // does the system percolate?

   public static void main(String[] args)   // test client (optional)
	*/
}