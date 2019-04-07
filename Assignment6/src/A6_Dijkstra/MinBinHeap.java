package A6_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class MinBinHeap {

	private ArrayList<Vertex> array = new ArrayList<Vertex>();

	public MinBinHeap() {
		Vertex temp = new Vertex(null, 0);
		array.add(0, temp);
	}

	public void decreaseKey(double key, Vertex vertex) {
		vertex.setDist(key);
		bubbleUp(vertex.location);
	}

	public int size() {
		return array.size() - 1;
	}

	public void build(HashMap<String, Vertex> entries) {
		array.clear();
		Vertex temp = new Vertex(null, 0);
		array.add(0, temp);
		array.addAll(entries.values());

		for (int i = size() / 2; i > 0; --i) {
			bubbleDown(i);
		}
	}

	private void bubbleUp(int index) {
		int parent = this.getParent(index);
		if (parent >= 1) {
			if ((array.get(index)).compareTo(array.get(parent)) < 0) {
				Vertex tmp = array.get(parent);
				array.set(parent, array.get(index));
				array.set(index, tmp);
				tmp.setLocation(index);
				array.get(parent).setLocation(parent);
				if (parent != 1) {
					bubbleUp(parent);
				}
			}
		}
	}

	private void bubbleDown(int index) {
		if (this.size() != 1) {
			int swap = this.getLeft(index);
			if (this.getRight(index) <= this.size()
					&& (array.get(getRight(index))).compareTo(array.get(swap)) < 0) {
				swap = getRight(index);
			}

			if ((array.get(index)).compareTo(array.get(swap)) > 0) {
				Vertex temp = array.get(swap);
				array.set(swap, array.get(index));
				array.set(index, temp);
				temp.setLocation(index);
				(array.get(swap)).setLocation(swap);
				if (getLeft(swap) <= this.size()) {
					bubbleDown(swap);
				}
			}
		}
	}

	public Vertex test() {
		if (size() == 0) {
			return null;
		} else {
			Vertex res = (Vertex) this.array.get(1);
			if (size() == 1) {
			array.remove(0);
			} else {
				array.set(1, array.get(size()));
				array.get(1).setLocation(1);
				array.remove(size());
				if (size() > 1) {
					bubbleDown(1);
				}
			}
			return res;
		}
	}

	private int getParent(int i) {
		return i/2;
	}

	private int getLeft(int i) {
		return 2*i;
	}

	private int getRight(int i) {
		return 2*i + 1;
	}
}