public class Solution {
	public static void main(String[] args) {
		AdjacencyListUndirected adj1 = new AdjacencyListUndirected();
		adj1.addEdge(0, 1);
		adj1.addEdge(0, 2);
		adj1.addEdge(1, 2);
		adj1.addEdge(1, 3);
		adj1.removeEdge(0, 1);
	}
}