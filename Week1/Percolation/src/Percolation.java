import java.util.Scanner;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	public static final boolean OPEN = true;
	public static final boolean CLOSED = false;
	
	public int sitesOpened;
	public int top;
	public int bottom;
	
	public boolean[][] open;

	public WeightedQuickUnionUF wqfu;
	
	public Percolation(int n) {
		
		if(n < 0) {
			throw new IllegalArgumentException("Invalid argument n");
		}
		
		top = 0;
		bottom = n * n + 1;
		
		open = new boolean[n][n];
		
		for(int i = 0; i < n ; i++) {
		   for(int j = 0; j < n; j++) {
			   open[i][j] = CLOSED;
		   	}
		}
	}
	
	protected int validateAndDecrease(int p) {
		if (p <= 0 || p > open.length) {
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
		
		return p--;
	}
	
	private int XYTo1d(int row, int col) {
		   return (open.length * row) + 1;
	}
   
   public void open(int row, int col) {
	   row = validateAndDecrease(row);
	   col = validateAndDecrease(col);
	   
	   if(open[row][col] == OPEN) {
		   return;
	   }
	   
	   open[row][col] = OPEN;
	   sitesOpened++;
	   
	   // top
	   if(row > 0 && open[row - 1][col] == OPEN) {
		   wqfu.union(XYTo1d(row, col), XYTo1d(row-1, col));
	   }
	   
	   // left
	   if(col > 0 && open[row][col - 1] == OPEN) {
		   wqfu.union(XYTo1d(row, col), XYTo1d(row, col-1));
	   }
	   
	   // right
	   if(col < open.length && open[row][col + 1] == OPEN) {
		   wqfu.union(XYTo1d(row, col), XYTo1d(row, col + 1));
	   }
	   
	   // down
	   if(row < open.length && open[row + 1][col] == OPEN) {
		   wqfu.union(XYTo1d(row, col), XYTo1d(row + 1, col));
	   }   
   }
   
   public boolean isOpen(int row, int col) {
	   row = validateAndDecrease(row);
	   col = validateAndDecrease(col);
	   return open[row][col] == OPEN;
   }
	
   public int numberOfOpenSites() {
	   return open.length * open.length - sitesOpened;
   }
   
   public boolean percolates(){
	   return wqfu.connected(top, bottom);
   }
   
   public boolean isFull(int row, int col) {
	   row = validateAndDecrease(row);
	   col = validateAndDecrease(col);
	   return wqfu.connected(top, bottom);
   }
   
   public static void main(String[] args) {
	   Percolation p = new Percolation(5);
	   Scanner sc = new Scanner(System.in);
	   while(true) {
		   p.open(sc.nextInt(), sc.nextInt());
		   System.out.println(p.percolates());
	   }
   }
}