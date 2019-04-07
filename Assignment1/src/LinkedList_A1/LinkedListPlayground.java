package LinkedList_A1;

public class LinkedListPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
      */
    //test1();
    //test2();
   // test3();
	  //test4();
	  //test5();
	  test6();

  }
  
  public static void test1(){
    // example test cases
    LinkedListImpl L= new LinkedListImpl();
    System.out.println(L.isEmpty());
    printList(L);
    L.clear();
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.sentinel.toString());
    L.insert(3.3,0);
    System.out.println(L.isEmpty());
    printList(L);
    System.out.println(L.sentinel.next.toString());
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    System.out.println("testing...list before insert at index 1");
    printList(L);
    L.insert(3.67, 1);
    System.out.println("testing...list after insert at index 1");
    printList(L);
    L.insert(3.357, 0);
    System.out.println("testing...insert at index 0");
    L.insert(3.333, 4);
    System.out.println(L.size()); //6
    printList(L); //sentinel --> 3.357 --> 3.5 --> 3.67 --> 3.4 --> 3.333 --> 3.3
  // System.out.println(L.get(3));
    printBackwards(L);
   
    
    
    L.remove(3);
    System.out.println(L.size());//5
    printList(L);
    L.clear();
    L.insert(3.4, 0);
    L.insert(3.5, 0);
    L.insert(3.67, 1);
    L.insert(3.357, 0);
    L.insert(3.333, 3);
    L.remove(0);
    System.out.println(L.size()); //4
    printList(L);
    Node curr=L.sentinel.prev;
    System.out.println(curr.data);
    System.out.println(L.get(4));
    printList(L);
    L.clear();
    printList(L);
  }

  public static void test2(){
    // example test cases
	  System.out.println("test 2 start");
    LinkedListImpl L= new LinkedListImpl();
    L.insert(3.4,0);
    L.insert(3.5,1);
    L.insert(3.67,2);
    printList(L);
    L.remove(0);
    System.out.println(L.size());
    printList(L);
    printBackwards(L);
    System.out.println("test 2 end");
  }
  
  public static void test3() {
	  System.out.println("test 3 start");
	  LinkedListImpl L = new LinkedListImpl();
	  L.insert(3.453, 0);
	  L.insert(4.5, 0);
	  System.out.println("test 3 size:" + L.size);
	  printList(L);
	  printBackwards(L);
	  
  }
  
  public static void test4() {
	  LinkedListImpl L = new LinkedListImpl();
	  L.insert(3, 0);
	  L.insert(5, 1);
	  printList(L);
	  System.out.println(L.get(0));
  }
  
  public static void test5() {
	  LinkedListImpl L = new LinkedListImpl();
	  L.insert(3, 0);
	  L.insert(5, 1);
	  L.insert(6, 2);
	  L.insert(4, 1);
	  printList(L);
	  L.remove(0);
	  printList(L);
	  L.clear();
	  System.out.println(L.isEmpty());
  }
  
  public static void test6() {
	  LinkedListImpl L = new LinkedListImpl();
	  L.insert(3, 0);
	  System.out.println(L.get(1));
	  System.out.println(L.get(-1));
  }
  
  public static void printList(LinkedListImpl L){ 
    //note that this is a good example of how to iterate through your linked list
    // since we know how many elements are in the list we can use a for loop
    // and not worry about checking the next field to see if we hit the end sentinel
    Node curr=L.sentinel.next; // the first data node in the list is the one after sentinel. 
    System.out.print("sentinel");
    for(int i=0; i<L.size(); i++) { 
      System.out.print(" --> " + curr.data);
      curr=curr.next;
    }
    System.out.println();
  }
  
  public static void printBackwards(LinkedListImpl L) {
	  Node curr=L.sentinel.prev; // the last data node in the list is the one before sentinel. 
	    
	    for(int i=0; i<L.size(); i++) { 
	      System.out.print(curr.data + " --> ");
	      curr=curr.prev;
	    }
	    System.out.print("sentinel");
	    System.out.println();
  }
  
}