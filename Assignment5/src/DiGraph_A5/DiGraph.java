package DiGraph_A5;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DiGraph implements DiGraphInterface {
	
	private HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();
	private HashSet<Long> vertex_IDs = new HashSet<Long>();
	private HashSet<Long> edge_IDs = new HashSet<Long>();
	

	public boolean addNode(long idNum, String label) {
		if (idNum < 0) {
			return false;
		}
		if (label == null) {
			return false;
		}
		if (vertex_IDs.contains(idNum)) {
			return false;
		}
		Vertex temp = new Vertex(label, idNum);
		if (vertices.get(label) != null) {
			return false;
		}
		
		this.vertices.put(label, temp);
		vertex_IDs.add(idNum);
		return true;
	}

	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if  (idNum < 0) {
			return false;
		}
		if (sLabel == null) {
			return false;
		}
		if (dLabel == null) {
			return false;
		}
		if (edge_IDs.contains(idNum)) {
			return false;
		}
		
		Vertex source = vertices.get(sLabel);
		Vertex destination = vertices.get(dLabel);
		Edge e = new Edge(idNum, weight, eLabel, destination, source);
		if (source == null) {
			return false;
		}
		if (destination == null) {
			return false;
		}
		if (source.outedges.put(dLabel, e) != null) {
			return false;
		}
		destination.inedges.put(sLabel, e);
		edge_IDs.add(idNum);
		return true;
	}

	public boolean delNode(String label) {
		Vertex vertex = vertices.get(label);
		if (vertex == null) {
			return false;
		} else {
			this.vertices.remove(label);
			this.vertex_IDs.remove(vertex.id);
			for (Edge e : vertex.outedges.values()) {
				this.edge_IDs.remove(e.id);
				e.destination.inedges.remove(label);
			}
			for (Edge e : vertex.inedges.values()) {
				this.edge_IDs.remove(e.id);
				e.source.outedges.remove(label);
			}
			return true;
		}
	}

	public boolean delEdge(String sLabel, String dLabel) {
		Vertex vertex = vertices.get(sLabel);
		if (vertex == null) {
			return false;
		} else {
			Edge e = vertex.outedges.get(dLabel);
			if (e == null) {
				return false;
			} else {
				this.edge_IDs.remove(e.id);
				e.destination.inedges.remove(sLabel);
				vertex.outedges.remove(dLabel);
				return true;
			}
		}
	}

	public long numNodes() {
		return vertices.size();
	}

	public long numEdges() {
		return edge_IDs.size();
	}

	public String[] topoSort() {
		String[] sorted = new String[vertices.size()];
		HashMap<String, Vertex> vistedNodes = new HashMap<String, Vertex>();
		Iterator<Vertex> iter = vertices.values().iterator();

		while (iter.hasNext()) {
			Vertex v = (Vertex) iter.next();
			if (!this.visit(v, sorted, vistedNodes)) {
				return null;
			}
		}
		return sorted;
	}

	private boolean visit(Vertex vertex, String[] res, HashMap<String, Vertex> visitedVertices) {
		if (visitedVertices.containsKey(vertex.label)) {
			return true;
		} else if (vertex.marked) {
			return false;
		} else {
			vertex.setMarked(true);
			Iterator<Edge> iter2 = vertex.outedges.values().iterator();

			while (iter2.hasNext()) {
				Edge e = (Edge) iter2.next();
				if (!this.visit(e.destination, res, visitedVertices)) {
					return false;
				}
			}

			visitedVertices.put(vertex.label, vertex);
			vertex.setMarked(false);
			res[vertices.size() - visitedVertices.size()] = vertex.label;
			return true;
		}
	}
}