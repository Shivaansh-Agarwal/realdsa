import java.util.*;

public class AdjacencyListDirected extends AbstractAdjacencyList {
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