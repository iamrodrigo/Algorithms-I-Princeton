import java.util.Scanner;

public abstract class UnionFind {
	
	public static final int UNION = 1;
	public static final int FIND = 2;
	
	public int[] array;
	public Scanner sc;

	abstract void union(int p, int q);
	abstract boolean find(int p, int q);
	
	public UnionFind()
	{
		sc = new Scanner(System.in);
		array = new int[sc.nextInt()];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}
	
	public void print()
	{
		for(int i = 0; i < array.length; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println("\n");
	}
	
	public void menu()
	{
		int option = 0;
		
		do {
			System.out.println("1.Union");
			System.out.println("2.Find");
			System.out.println("0. Exit");
			option = sc.nextInt();
			
			switch(option) {
				case UNION:
					union(sc.nextInt(), sc.nextInt());
					break;
				case FIND:
					System.out.println(find(sc.nextInt(), sc.nextInt()));
					break;	
			}
			print();
		} while(option != 0);
	}
}