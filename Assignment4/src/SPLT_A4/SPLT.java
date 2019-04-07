package SPLT_A4;

public class SPLT implements SPLT_Interface{
	private BST_Node root;
	private int size;
	private BST_Node tempnode; //used in splay

	public SPLT() {
		this.size = 0;
		tempnode = new BST_Node(null);
	} 

	public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		// TODO Auto-generated method stub
		if (root == null) { //if tree is empty make a new node at root
			root = new BST_Node(s);
			size++;
			return;
		}
		if (contains(s)) {
			return;
		}
		
		
		splay(s);

		int cmp = s.compareTo(root.data);
		if (cmp == 0) {
			return;
		}

		BST_Node temp = new BST_Node(s);
		if (cmp < 0) {
			temp.left = root.left;
			temp.right = root;
			root.left = null;
			size++;
		} else {
			temp.right = root.right;
			temp.left = root;
			root.right = null;
			size++;
		}
		root = temp;
	}

	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		
		splay(s);

		if (s.compareTo(root.data) != 0) {
			return;
		}

		if (root.left == null) {
			root = root.right;
			size--;
		} else {
			BST_Node x = root.right;
			root = root.left;
			splay(s);
			root.right = x;
			size--;
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		BST_Node x = root;
		if(root == null) return null;
		while(x.left != null) {
			x = x.left;
			splay(x.data);
		}

		return x.data;
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		BST_Node x = root;
		if(root == null) return null;
		while(x.right != null) {
			x = x.right;
			splay(x.data);
		}
		return x.data;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		return find(s) != null;
	}

	private String find(String s) {
		if (root == null) {
			return null;
		}
		splay(s);
		if(root.data.compareTo(s) != 0) {
			return null;
		}
		return root.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return root.getHeight();
	}  

	private void splay(String s) {
		BST_Node left, right, x, y;
		left = tempnode;
		right = tempnode;
		x = root;
		tempnode.left = null;
		tempnode.right = null;
		while(true) {
			int cmp = s.compareTo(x.data);
			if (cmp < 0) {
				if (x.left == null) {
					break;
				}
				if (s.compareTo(x.left.data) < 0) { //rotate right
					y = x.left;
					x.left = y.right;
					y.right = x;
					x = y;
					if (x.left == null) {
						break;
					}
				}
				right.left = x;
				right = x;
				x = x.left;
			} else if (cmp > 0) {
				if (x.right == null) {
					break;
				}
				if (s.compareTo(x.right.data) > 0) { //rotate left
					y = x.right;
					x.right = y.left;
					y.left = x;
					x = y;
					if (x.right == null) {
						break;
					}
				}
				left.right = x;
				left = x;
				x = x.right;
			} else {
				break;
			}
		}
		left.right = x.left;
		right.left = x.right;
		x.left = tempnode.right;
		x.right = tempnode.left;
		root = x;
	}
}