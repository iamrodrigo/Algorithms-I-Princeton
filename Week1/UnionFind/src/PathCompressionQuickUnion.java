public class PathCompressionQuickUnion extends QuickUnionWeigthing {
	
	protected int root(int element) {
		while(element != array[element]) {
			array[element] = array[array[element]];
			element = array[element];
		}
		
		return element;
	}
}
