package BST_A2;

public class BST_Playground {
	/*
	 * you will test your own BST implementation in here
	 *
	 * we will replace this with our own when grading, and will
	 * do what you should do in here... create BST objects,
	 * put data into them, take data out, look for values stored
	 * in it, checking size and height, and looking at the BST_Nodes
	 * to see if they are all linked up correctly for a BST
	 * 
	 */

	public static void main(String[]args){

		// you should test your BST implementation in here
		// it is up to you to test it thoroughly and make sure
		// the methods behave as requested above in the interface

		// do not simple depend on the oracle test we will give
		// use the oracle tests as a way of checking AFTER you have done
		// your own testing

		// one thing you might find useful for debugging is a print tree method
		// feel free to use the printLevelOrder method to verify your trees manually
		// or write one you like better
		// you may wish to print not only the node value, and indicators of what
		// nodes are the left and right subtree roots,
		// but also which node is the parent of the current node
		
		//test1();
		//test2();
		//test3();
		/*String a = "a";
		String b = "b";
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));*/
		//test4();
		//testinsert();
		testall();
	}
	
	static void testinsert() {
		BST bst = new BST();
		bst.insert("B");
		bst.insert("A");
		bst.insert("D");
		bst.insert("C");
		bst.insert("E");
		printLevelOrder(bst);
		System.out.println("should be B,A,D,C,E");
		
	}
	
	static void testall() {
		BST bst = new BST();
		System.out.println("should be false " + bst.remove("a"));
		bst.insert("B");
		System.out.println("size should be 1 " + bst.size());
		System.out.println("should be true " + bst.remove("B"));
		System.out.println("should be false " + bst.remove("B"));
		System.out.println("size should be 0 " + bst.size());
		bst.insert("B");
		bst.insert("B");
		bst.insert("B");
		System.out.println("should be false " + bst.remove("a"));
		System.out.println("should be true " + bst.remove("B"));
		System.out.println("size should be 0 " + bst.size());
		System.out.println("should be false " + bst.contains("B"));
		bst.insert("B");
		System.out.println("should be true " + bst.contains("B"));
		bst.insert("A");
		bst.insert("D");
		bst.insert("C");
		bst.insert("E");
		System.out.println("should be true " + bst.contains("A"));
		System.out.println("should be true " + bst.contains("D"));
		System.out.println("should be true " + bst.contains("C"));
		System.out.println("should be true " + bst.contains("E"));
		System.out.println("should be true " + bst.contains("B"));
		System.out.println("should be true " + bst.contains("C"));
		bst.remove("B");
		bst.remove("E");
		bst.remove("C");
		bst.remove("A");
		bst.remove("D");
		System.out.println("should be false " + bst.contains("C"));
		System.out.println("should be true " + bst.empty());
		System.out.println("should be null " + bst.findMin());
		System.out.println("should be null " + bst.findMax());
		bst.insert("D");
		bst.insert("A");
		System.out.println("should be A " + bst.findMin());
		System.out.println("should be D " + bst.findMax());
		System.out.println("should be 1 " + bst.height());
		bst.insert("B");
		System.out.println("should be 2 " + bst.height());
		printLevelOrder(bst);
		bst.insert("C");
		bst.insert("E");
		bst.insert("z");
		bst.insert("x");
		bst.insert("y");
		bst.insert("f");
		bst.insert("m");
		System.out.println("\nLevel Order");
		printLevelOrder(bst);
		System.out.println("\nIn Order");
		printInOrder(bst.root);
		bst.insert("n");
		bst.remove("x");
		System.out.println("\nLevel Order");
		printLevelOrder(bst);
		System.out.println("\nIn Order");
		printInOrder(bst.root);
		
	}
	
	static void test4() {
		BST bst = new BST();
		bst.insert("B");
		bst.insert("A");
		bst.insert("D");
		bst.insert("C");
		bst.insert("E");
		System.out.println(bst.insert("B"));
		
	}
	
	static void test2() {
		//contains test
		BST bst = new BST();
		bst.insert("B");
		bst.insert("A");
		bst.insert("D");
		bst.insert("C");
		bst.insert("E");
		printLevelOrder(bst);
		bst.remove("B");
		//bst.remove("D");
		printLevelOrder(bst);
		System.out.println(bst.contains("C"));
	}
	
	static void test3() {
		//height test
		BST bst = new BST();
		bst.insert("B");
		bst.insert("A");
		bst.insert("D");
		bst.insert("C");
		bst.insert("F");
		bst.insert("E");
		System.out.println(bst.height());
	}

	static void test1() {
		BST bst = new BST();
		bst.insert("a");
		bst.insert("b");
		bst.insert("d");
		bst.insert("e");
		bst.insert("hello");
		printLevelOrder(bst);
		System.out.println("the max is: " + bst.findMax());
		System.out.println("the min is: " + bst.findMin());
		bst.remove("a");
		printLevelOrder(bst);
		bst.remove("hello");
		bst.remove("d");
		System.out.println(bst.contains("e"));
		
		printLevelOrder(bst);
		System.out.println(bst.remove("b"));
		System.out.println(bst.remove("e"));
		System.out.println(bst.empty());
		bst.insert("ladfjl");
		System.out.println(bst.empty());
		
	}

	static void printLevelOrder(BST tree){ 
		//will print your current tree in Level-Order...
		//https://en.wikipedia.org/wiki/Tree_traversal
		int h=tree.getRoot().getHeight();
		for(int i=0;i<=h;i++){
			printGivenLevel(tree.getRoot(), i);
		}

	}
	static void printGivenLevel(BST_Node root,int level){
		if(root==null)return;
		if(level==0)System.out.print(root.data+" ");
		else if(level>0){
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}
	static void printInOrder(BST_Node root){
		//will print your current tree In-Order
		if(root!=null){
			printInOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			printInOrder(root.getRight());
		}
	}
}