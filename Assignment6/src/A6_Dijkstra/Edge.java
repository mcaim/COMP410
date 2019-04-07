package A6_Dijkstra;

public class Edge {
	
	Vertex source;
	Vertex destination;
	String label;
	long id;
	long weight;

	public Edge(long id, long weight, String label, Vertex destination, Vertex source) {
		this.source = source;
		this.label = label;
		this.destination = destination;
		this.weight = weight;
		this.id = id;
	}
}

