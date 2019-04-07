package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST(){ size=0; root=null; }

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ return root; }

	
	@Override
	public boolean insert(String s) {
		// TODO Auto-generated method stub
		//size++;
		if (root == null) {
			root = new BST_Node(s,null);
			size++;
			return true;
		} else {
			boolean insert = root.insertNode(s);
			if (insert) {
				size++;
			}
			return insert;
		}	
	}

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;
		else {
			if (s.compareTo(root.data) == 0) { //remove & replace root
				BST_Node temproot = new BST_Node(s, root);
				temproot.left = root;
				boolean removeroot = root.removeNode(s, temproot);
				root = temproot.left;
				if (removeroot) {
					size--;
				}
				return removeroot;
			} else { //remove node that isn't root
				boolean remove_notroot = root.removeNode(s,null);
				if (remove_notroot) {
					size--;
				}
				return remove_notroot;
			}
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		} else if (size == 1) {
			return root.data;
		} else {
			return root.findMin().data;
		}
	}
	
	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		} else if (size == 1) {
			return root.data;
		} else {
			return root.findMax().data;
		}
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		} else {
			return root.containsNode(s);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			return 0;
		} else {
			return root.getHeight();
		}
	}

}