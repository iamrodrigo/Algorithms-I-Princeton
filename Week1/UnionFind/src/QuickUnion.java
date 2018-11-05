
public class QuickUnion extends UnionFind
{	
	protected int root(int element) {
		while(element != array[element]) {
			element = array[element];
		}
		
		return element;
	}
	
	@Override
	void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		
		if(rootP == rootQ) {
			return;
		}
		
		array[rootP] = rootQ;
	}

	@Override
	boolean find(int p, int q) {
		return root(p) == root(q);
	}
}
