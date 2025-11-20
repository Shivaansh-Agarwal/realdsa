import java.util.*;

abstract class AbstractAdjacencyList {
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

class AdjacencyListUndirected extends AbstractAdjacencyList {

	public AdjacencyListUndirected() {
		super();
	}

	@Override
	public void addEdge(int u, int v) {
		List<Integer> list1 = adj.getOrDefault(u, new ArrayList<>());
		list1.add(v);
		adj.put(u, list1);
		
		List<Integer> list2 = adj.getOrDefault(v, new ArrayList<>());
		list2.add(u);
		adj.put(v, list2);

		System.out.println("GRAPH after adding edge (u,v):" + u + ", " + v);
		this.printGraph();
	}

	@Override
	public void removeEdge(int u, int v) {
		if (adj.containsKey(u)) {
			int indexOfV = adj.get(u).indexOf(v);
			if (indexOfV >= 0) {
				adj.get(u).remove(indexOfV);
				// Remove node from map if it has no neighbors
				if (adj.get(u).isEmpty()) {
					adj.remove(u);
				}
			}
		}
		if (adj.containsKey(v)) {
			int indexOfU = adj.get(v).indexOf(u);
			if (indexOfU >= 0) {
				adj.get(v).remove(indexOfU);
				// Remove node from map if it has no neighbors
				if (adj.get(v).isEmpty()) {
					adj.remove(v);
				}
			}
		}
		System.out.println("GRAPH after removing edge (u,v):" + u + ", " + v);
		this.printGraph();
	}

	@Override
	public boolean hasEdge(int u, int v) {
		if (!adj.containsKey(u) || !adj.containsKey(v)) {
			return false;
		}
		return adj.get(u).indexOf(v) >= 0 && adj.get(v).indexOf(u) >= 0;
	}

	@Override
	public List<Integer> getNeighbors(int u) {
		return adj.getOrDefault(u, new ArrayList<>());
	}

	public int getDegree(int u) {
		return adj.getOrDefault(u, new ArrayList<>()).size();
	}

	@Override
	public int getNumberOfVertices() {
		return adj.size();
	}

	@Override
	public int getNumberOfEdges() {
		int sum = 0;
		for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			sum += entry.getValue().size();
		}
		return sum/2;
	}
}

class AdjacencyListDirected extends AbstractAdjacencyList {
	@Override
	public void addEdge(int u, int v) {
		List<Integer> list = adj.getOrDefault(u, new ArrayList<>());
		list.add(v);
		adj.put(u, list);
		System.out.println("GRAPH after adding edge (u,v):" + u + ", " + v);
		this.printGraph();
	}

	@Override
	public void removeEdge(int u, int v) {
		if (adj.containsKey(u)) {
			int indexOfV = adj.get(u).indexOf(v);
			if (indexOfV >= 0) {
				adj.get(u).remove(indexOfV);
				// Remove node from map if it has no neighbors
				if (adj.get(u).isEmpty()) {
					adj.remove(u);
				}
			}
		}
		System.out.println("GRAPH after removing edge (u,v):" + u + ", " + v);
		this.printGraph();
	}

	@Override
	public boolean hasEdge(int u, int v) {
		if (!adj.containsKey(u)) {
			return false;
		}
		return adj.get(u).indexOf(v) >= 0;
	}

	@Override
	public List<Integer> getNeighbors(int u) {
		return adj.getOrDefault(u, new ArrayList<>());
	}

	public int getInDegree(int u) {
		int inDegree = 0;
		for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			if (entry.getValue().contains(u)) {
				inDegree++;
			}
		}
		return inDegree;
	}

	public int getOutDegree(int u) {
		return adj.getOrDefault(u, new ArrayList<>()).size();
	}

	@Override
	public int getNumberOfVertices() {
		return adj.size();
	}

	@Override
	public int getNumberOfEdges() {
		int sum = 0;
		for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
			sum += entry.getValue().size();
		}
		return sum;
	}
}

class Solution {
	public static void main(String[] args) {
		AdjacencyListUndirected adj1 = new AdjacencyListUndirected();
		adj1.addEdge(0, 1);
		adj1.addEdge(0, 2);
		adj1.addEdge(1, 2);
		adj1.addEdge(1, 3);
		adj1.removeEdge(0, 1);
		adj1.printGraph();
	}
}