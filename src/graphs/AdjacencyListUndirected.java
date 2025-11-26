import java.util.*;

public class AdjacencyListUndirected extends AbstractAdjacencyList {

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