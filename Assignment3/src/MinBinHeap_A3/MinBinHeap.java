package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
		size = 0;
		//of child/parent computations...
		//the book/animation page both do this.
	}

	//Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() { 
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		int hole = ++size;
		array[0] = entry;
		while (entry.getPriority() < array[hole/2].getPriority()) {
			array[hole] = array[hole/2];
			hole /= 2;
		}
		array[hole] = entry;
	}

	@Override
	public void delMin() {
		array[1] = array[size--];
		bubbleDown(1);
	}

	public void bubbleDown(int hole) {
		int child;
		EntryPair tmp = array[hole];
		while (hole*2 <=  size) {
			child = hole * 2;
			if (child != size && array[child+1].getPriority() < array[child].getPriority()) {
				child++;
			}
			if (array[child].getPriority() < tmp.getPriority()) {
				array[hole] = array[child];
			} else {
				break;
			}
			hole = child;
		}
		array[hole] = tmp;
	}

	@Override
	public EntryPair getMin() {
		if (size == 0) {
			return null;
		}
		return array[1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		int j  = 1;
		for (EntryPair entry: entries) {
			array[j] = entry;
			j++;
		}
		//System.arraycopy(entries, 0, array, 1, entries.length);
		size = entries.length;
		for (int i  = size/2; i > 0; i--) {
			bubbleDown(i);
		}
	}
}
