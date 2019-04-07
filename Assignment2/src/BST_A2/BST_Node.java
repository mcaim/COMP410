package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;


	BST_Node(String data, BST_Node parent){
		this.data = data;
		this.parent = parent;
	}

	// --- used for testing  ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData(){ return data; }
	public BST_Node getLeft(){ return left; }
	public BST_Node getRight(){ return right; }
	public BST_Node getParent() {
		return parent;
	}

	// --- end used for testing -------------------------------------------


	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false 
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations


	public boolean containsNode(String s) { 
		int compare = s.compareTo(this.data);
		if (compare == 0) {
			return true;
		} else if (compare < 0) {
			if (left == null) {
				return false;
			} else {
				return left.containsNode(s);
			}
		} else if (compare > 0) {
			if (right == null) {
				return false;
			} else {
				return right.containsNode(s);
			}
		}

		return false; 
	}

	public boolean insertNode(String s) { 
		int compare = s.compareTo(this.data);
		if (compare == 0) {
			return false;
		} else if (compare < 0) {
			if (left == null) {
				left = new BST_Node(s,this);
				return true;
			} else {
				return left.insertNode(s);
			}
		} else if (compare > 0) {
			if (right == null) {
				right = new BST_Node(s,this);
				return true;
			} else {
				return right.insertNode(s);
			}
		} 
		return false;
	}
	
	public BST_Node findMin() {
		if (left == null) {
			return this;
		} else {
			return left.findMin();
		}
	}
	
	public BST_Node findMax() {
		if (right == null) {
			return this;
		} else {
			return right.findMax();
		}
	}

	public int getHeight() {
		int heightright = -1;
		int heightleft = -1;
		if (this.right != null) {
			heightright = this.right.getHeight();
		}
		if (this.left != null) {
			heightleft = this.left.getHeight();
		}

		if (heightright > heightleft) {
			return heightright + 1;
		} else {
			return heightleft + 1;
		}
	}

	public boolean removeNode(String s, BST_Node parent) {
		int compare = s.compareTo(this.data);
		if (compare < 0) { //go left and look for node
			if (left != null) {
				return left.removeNode(s, this);
			} else { return false; }
		} else if (compare > 0) { //go right and look for node
			if (right != null) {
				return right.removeNode(s, this);
			} else { return false; }
		} else { //found node to remove (compare == 0)
			if (left != null && right != null) { //node to replace has two children, find min child to replace
				this.data = right.findMin().data; //change data to min node in right subtree data
				right.removeNode(this.data, this);
			} else if (parent.left == this) { //replace with left child
				if (left != null) {
					parent.left = left;
				} else {
					parent.left = right;
				}
			} else if (parent.right == this) { //replace with left child
				if (left != null) {
					parent.right = left;
				} else {
					parent.right = right;
				}
			}
			return true;
		}
	}


	// --- end fill in these methods --------------------------------------


	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
	}
}