import java.util.*;

public abstract  class AbstractAdjacencyList {
    protected  Map<Integer, List<Integer>> adj;

	public AbstractAdjacencyList() {
		this.adj = new HashMap<>();
	}

	public AbstractAdjacencyList(int initialCapacity) {
        this.adj = new HashMap<>(initialCapacity);
    }

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			Integer node = entry.getKey();
			List<Integer> neighbours = entry.getValue();
			System.out.print("u: " + node + " -> ");
			for (int num : neighbours) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	abstract void addEdge(int u, int v);

	abstract void removeEdge(int u, int v);
	
	abstract boolean hasEdge(int u, int v);

	abstract List<Integer> getNeighbors(int u);

	abstract int getNumberOfVertices();

	abstract int getNumberOfEdges();
}
