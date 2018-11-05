public class QuickUnionWeigthing extends QuickUnion {
	
	public int[] sz;
	
	public QuickUnionWeigthing()
	{
		super();
		
		sz = new int[array.length];
		for(int i = 0; i < sz.length; i++) {
			sz[i] = 1;
		}
	}
	
	@Override
	void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		
		if(rootP == rootQ) {
			return;
		}
		
		if(sz[rootP] > sz[rootQ]) {
			array[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
		} else {
			array[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		}
	}
}
