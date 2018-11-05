
public class QuickFind extends UnionFind
{
	@Override
	void union(int p, int q) {
		int indexP = array[p];
		int indexQ = array[q];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == indexP){
				array[i] = indexQ;
			}
		}
		
	}

	@Override
	boolean find(int p, int q) {
		return array[p] == array[q];
	}
}
