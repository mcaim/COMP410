package DiGraph_A5;

import java.util.HashMap;

public class Vertex {
	
	boolean marked;
	String label;
	long id;
	HashMap<String, Edge> outedges;
	HashMap<String, Edge> inedges;

	public Vertex(String label, long id) {
		this.label = label;
		this.id = id;
		this.outedges = new HashMap<String, Edge>();
		this.inedges = new HashMap<String, Edge>();
		this.marked = false;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
}