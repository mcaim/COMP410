package A6_Dijkstra;

import java.util.HashMap;

public class Vertex implements Comparable<Vertex> {
	
	boolean marked;
	String label;
	long id;
	HashMap<String, Edge> outedges;
	HashMap<String, Edge> inedges;
	double distance;
	Vertex parent = null;
	int location;

	public Vertex(String label, long id) {
		this.label = label;
		this.id = id;
		this.outedges = new HashMap<String, Edge>();
		this.inedges = new HashMap<String, Edge>();
		this.marked = false;
		this.distance = Double.NaN;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	public void setDist(double distance) {
		this.distance = distance;
	}

	public void setParent(Vertex parent) {
		this.parent  = parent;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int compareTo(Vertex other) {
		double other_distance = other.distance;
		int res = 0;
		if (other_distance < distance) {
			res = 1;
		}
		if (other_distance > distance) {
			res = -1;
		}
		if (res == 0) {
			res = this.label.compareTo(other.label);
		}

		return res;
	}
}