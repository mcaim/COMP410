package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the
					// head)
	int size = 0;

	public LinkedListImpl() {// this constructor is needed for testing purposes.
								// Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part
								// of your data set!
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to
							// grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		// TODO Auto-generated method stub
		if (index > size) {
			return false;
		}

		Node newnode = new Node(elt);
		if (size == 0) {
			sentinel.next = newnode;
			newnode.next = sentinel;
			newnode.prev = sentinel;
			sentinel.prev = newnode;
		} else {

			if (index == 0) {
				Node currentnode = sentinel.next;
				/*for (int i = 0; i < index; i++) {
					currentnode = currentnode.next;
				}*/
				sentinel.next = newnode;
				newnode.prev = sentinel;
				newnode.next = currentnode;
				currentnode.prev = newnode;
			} else if (index == size) {
				/*Node currentnode = sentinel;
				for (int i = 0; i < index; i++) {
					currentnode = currentnode.next;
				}
				newnode.next = sentinel;
				newnode.prev = currentnode;
				sentinel.prev = newnode;
				currentnode.next = newnode;*/
				
				Node currentnode = sentinel.prev;
				newnode.prev = currentnode;
				newnode.next = sentinel;
				sentinel.prev = newnode;
				currentnode.next = newnode;
				
				
			} else {
				
				Node currentnode = sentinel.next;
				for (int i = 0; i < index; i++) {
						currentnode = currentnode.next;
				}
				newnode.prev = currentnode.prev;
				newnode.next = currentnode;
				currentnode.prev.next = newnode;
				currentnode.prev = newnode;
				
			}
		}

		size++;
		return true;
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if (index > size || size == 0) {
			return false;
		}
		
		if (index == 0) {
			Node currentnode = sentinel.next;
			/*for (int i = 0; i < index; i++) {
				currentnode = currentnode.next;
			}*/
			sentinel.next = currentnode.next;
			currentnode.next.prev = sentinel;
			currentnode.prev = null;
			currentnode.next = null;
			
		} else if (index == size) {
			/*Node currentnode = sentinel;
			for (int i = 0; i < index; i++) {
				currentnode = currentnode.next;
			}
			currentnode.prev.next = sentinel;
			sentinel.prev = currentnode.prev;
			currentnode.prev = null;
			currentnode.next = null;*/
			
			Node currentnode = sentinel.prev;
			currentnode.prev.next = sentinel;
			sentinel.prev = currentnode.prev;
			currentnode.prev = null;
			currentnode.next = null;
		} else {
			
			Node currentnode = sentinel.next;
			for (int i = 0; i < index; i++) {
					currentnode = currentnode.next;
			}
			 currentnode.next.prev = currentnode.prev;
			 currentnode.prev.next = currentnode.next;
			 currentnode.prev = null;
			 currentnode.next = null;
			
		}

		size--;
		return true;
	}

	@Override
	public double get(int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			return Double.NaN;
		}
		if (size == 0) {
			return Double.NaN;
		}
		double value = 0.0;
		
		if (index == 0) {
			Node currentnode = sentinel.next;
			value = currentnode.data;
			
		} else if (index == size) {
			/*Node currentnode = sentinel;
			for (int i = 0; i < index; i++) {
				currentnode = currentnode.next;
				value = currentnode.data;
			}*/
			
			value = sentinel.prev.data;

		} else {
			//this works with  this...maybe not lol
			Node currentnode = sentinel.next;
			for (int i = 0; i < index; i++) {
				currentnode = currentnode.next;
				value = currentnode.data;
			}
		}
		
		return value;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		/*int s = size;
		for (int i = 0; i < s; i++) {
			remove(0);
		}*/
		
		//above works but is O(N)
		//below is O(1)
		
		sentinel.next = null;
		sentinel.prev = null;
		size = 0;
	}

	public Node currentNode(int x) {
		// if (size == 0) {
		// return sentinel;
		// }

		Node current = sentinel;
		for (int i = 0; i < x; i++) {
			Node tempnode = current;
			tempnode = current.next;
			current = tempnode;
		}

		return current;
	}
}