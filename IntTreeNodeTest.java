/* Description: This program is designed to test the minTime method in the IntTreeNode class.
*/

import static org.junit.Assert.*;
import org.junit.Test;


public class IntTreeNodeTest {

	/**
	 * The next two test cases are examples provided by the GeeksForGeeks
	 * web page for the Burning Tree Problem
	 */

	@Test
	public void testMinTime_Example1GeeksforGeeks() {
		IntTreeNode first = new IntTreeNode(1);
		IntTreeNode second = new IntTreeNode(2);
		IntTreeNode third = new IntTreeNode(3);
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode sixth = new IntTreeNode(6);
		IntTreeNode seventh = new IntTreeNode(7);
		IntTreeNode eighth = new IntTreeNode(8);
		IntTreeNode ninth = new IntTreeNode(9);
		IntTreeNode tenth = new IntTreeNode(10);
		
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		fifth.right = seventh;
		fifth.left = eighth;
		third.right = sixth;
		sixth.right = ninth;
		ninth.right = tenth;
		
    	//			 1
    	//		   /   \
    	//		  2     3
    	//  	 / \     \
    	//  	4   5     6
    	//         / \     \
    	//        7   8     9
    	//					 \
    	//					  10
    	
    	//Start burning at node 8
    	//Takes 7 seconds
    	assertEquals(7, IntTreeNode.minTime(first, 7));

	}
	
	
	@Test
	public void Example2_GeeksforGeeks() {
		IntTreeNode first = new IntTreeNode(1);
		IntTreeNode second = new IntTreeNode(2);
		IntTreeNode third = new IntTreeNode(3);
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode seventh = new IntTreeNode(7);
		IntTreeNode eighth = new IntTreeNode(8);
		IntTreeNode tenth = new IntTreeNode(10);
		
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		fourth.left = eighth;
		fifth.left = tenth;
		third.right = seventh;

    	
    	//			 1
    	//		   /   \
    	//		  2     3
    	//  	 / \     \
    	//  	4   5     7
    	//     /    /
    	//    8   10
    	
    	//Start burning at node 10
    	//Takes 5 seconds
    	assertEquals(5, IntTreeNode.minTime(first, 10));

	}
	
	/*
	 * Symmetrical Tree with height of 5
	 * Start burn in middle of tree
	 */
	@Test
	public void NormalCase1_BinaryTreeOfHeight5() {
		IntTreeNode first = new IntTreeNode(1, new IntTreeNode (2), new IntTreeNode (3));
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode sixth = new IntTreeNode(6);
		IntTreeNode seventh = new IntTreeNode(7);
		IntTreeNode eighth = new IntTreeNode(8, new IntTreeNode (16), new IntTreeNode(17));
		IntTreeNode ninth = new IntTreeNode(9, new IntTreeNode (18), new IntTreeNode (19));
		IntTreeNode tenth = new IntTreeNode(10, new IntTreeNode (20), new IntTreeNode(21));
		IntTreeNode eleventh = new IntTreeNode(11, new IntTreeNode (22), new IntTreeNode (23));
		IntTreeNode twelvth = new IntTreeNode(12, new IntTreeNode (24),new IntTreeNode(25));
		IntTreeNode thirteenth = new IntTreeNode(13, new IntTreeNode(26),new IntTreeNode(27));
		IntTreeNode fourteenth = new IntTreeNode(14, new IntTreeNode(28),new IntTreeNode(29));
		IntTreeNode fifteenth = new IntTreeNode(15, new IntTreeNode(30),new IntTreeNode(31));
		
		first.left.left = fourth;
		first.left.right = fifth;
		first.right.left = sixth;
		first.right.right = seventh;
		fourth.left = eighth;
		fourth.right = ninth;
		fifth.left = tenth;
		fifth.right = eleventh;
		sixth.left = twelvth;
		sixth.right = thirteenth;
		seventh.left = fourteenth;
		seventh.left = fifteenth;
    
    	//			         1
    	//		     /             \
    	//		    2               3
    	//  	 /     \         /    \
    	//  	4       5       6      7
    	//     / \     / \     / \    / \
    	//    8   9   10 11  12  13  14  15
    	//				...
    	
    	//Start burning at node 5
    	//Takes 6 seconds
    	assertEquals(6, IntTreeNode.minTime(first, 5));
	}
	
	
	/*
	 * Symmetrical Tree with height of 5
	 * Start burn at end of tree
	 */
	@Test
	public void NormalCase2_BinaryTreeOfHeight5() {
		IntTreeNode first = new IntTreeNode(1, new IntTreeNode (2), new IntTreeNode (3));
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode sixth = new IntTreeNode(6);
		IntTreeNode seventh = new IntTreeNode(7);
		IntTreeNode eighth = new IntTreeNode(8, new IntTreeNode (16), new IntTreeNode(17));
		IntTreeNode ninth = new IntTreeNode(9, new IntTreeNode (18), new IntTreeNode (19));
		IntTreeNode tenth = new IntTreeNode(10, new IntTreeNode (20), new IntTreeNode(21));
		IntTreeNode eleventh = new IntTreeNode(11, new IntTreeNode (22), new IntTreeNode (23));
		IntTreeNode twelvth = new IntTreeNode(12, new IntTreeNode (24),new IntTreeNode(25));
		IntTreeNode thirteenth = new IntTreeNode(13, new IntTreeNode(26),new IntTreeNode(27));
		IntTreeNode fourteenth = new IntTreeNode(14, new IntTreeNode(28),new IntTreeNode(29));
		IntTreeNode fifteenth = new IntTreeNode(15, new IntTreeNode(30),new IntTreeNode(31));
		
		first.left.left = fourth;
		first.left.right = fifth;
		first.right.left = sixth;
		first.right.right = seventh;
		fourth.left = eighth;
		fourth.right = ninth;
		fifth.left = tenth;
		fifth.right = eleventh;
		sixth.left = twelvth;
		sixth.right = thirteenth;
		seventh.left = fourteenth;
		seventh.left = fifteenth;
    
    	
    
    	//			         1
    	//		     /             \
    	//		    2               3
    	//  	 /     \         /    \
    	//  	4       5       6      7
    	//     / \     / \     / \    / \
    	//    8   9   10 11  12  13  14  15
    	//				...
    	
    	//Start burning at node 27
    	//Takes 8 seconds
    	assertEquals(8, IntTreeNode.minTime(first, 27));
	}


	//Start burning at root node with binary tree of height 1
	@Test
	public void SpecialCase_OnlyRootNode() {
		IntTreeNode root = new IntTreeNode(1);
    	
    	//Takes 0 seconds
    	assertEquals(0, IntTreeNode.minTime(root, 1));

	}
	
	/*
	 * Starts burning at the root node in a symmetrical binary tree
	 */
	@Test
	public void NormalCase_StartBurnAtRootNodeForSymmetricalTree() {
		IntTreeNode first = new IntTreeNode(1, new IntTreeNode (2), new IntTreeNode(3));
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode sixth = new IntTreeNode(6);
		IntTreeNode seventh = new IntTreeNode(7);
		
		
		first.left.left = fourth;
		first.left.right = fifth;
		first.right.left = sixth;
		first.right.right = seventh;

    	
    	//			 1
    	//		   /   \
    	//		  2     3
    	//  	 / \   / \
    	//  	4   5 6   7

    	
    	//Start burning at root node
    	//Takes 2 seconds
    	assertEquals(2, IntTreeNode.minTime(first, 1));
	}
	
	/*
	 * Starts burning at the root node in an asymmetrical binary tree
	 */
	@Test
	public void SpecialCase_StartBurnAtRootNodeForAsymmetricalTree() {
		IntTreeNode first = new IntTreeNode(1, new IntTreeNode (2), new IntTreeNode(3));
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5, new IntTreeNode (7), new IntTreeNode (8));
		IntTreeNode sixth = new IntTreeNode(6);
		IntTreeNode ninth = new IntTreeNode(9);
		IntTreeNode tenth = new IntTreeNode(10);
		
		
		first.left.left = fourth;
		first.left.right = fifth;
		first.right.right = sixth;
		sixth.right = ninth;
		ninth.right = tenth;
    	
    	//			 1
    	//		   /   \
    	//		  2     3
    	//  	 / \     \
    	//  	4   5     6
    	//         / \     \
    	//        7   8     9
    	//					 \
    	//					  10
    	
    	//Start burning at node 1
    	//Takes 4 seconds
    	assertEquals(4, IntTreeNode.minTime(first, 1));
	}
	
	/*
	 * Start fire at a non-existent node 
	 */
	@Test
	public void SpecialCase_NonExistentNode() {
		IntTreeNode first = new IntTreeNode(1, new IntTreeNode (2), new IntTreeNode(3));
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5, new IntTreeNode (7), new IntTreeNode (8));
		IntTreeNode sixth = new IntTreeNode(6);
		IntTreeNode ninth = new IntTreeNode(9);
		IntTreeNode tenth = new IntTreeNode(10);
		
		
		first.left.left = fourth;
		first.left.right = fifth;
		first.right.right = sixth;
		sixth.right = ninth;
		ninth.right = tenth;
    	
    	//			 1
    	//		   /   \
    	//		  2     3
    	//  	 / \     \
    	//  	4   5     6
    	//         / \     \
    	//        7   8     9
    	//					 \
    	//					  10
    	
    	//Start burning at node 23
    	//Takes 0 seconds
    	assertEquals(0, IntTreeNode.minTime(first, 0));
	}
	
	/**
	 * Asymmetrical Tree with height of 8
	 * Target Node on the right side of tree
	 */
	@Test
	public void NormalCase_AsymmetricalTreeHeight8() {
		IntTreeNode first = new IntTreeNode(1);
		IntTreeNode second = new IntTreeNode(2);
		IntTreeNode third = new IntTreeNode(3);
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode seventh = new IntTreeNode(7);
		IntTreeNode eighth = new IntTreeNode(8);
		IntTreeNode ninth = new IntTreeNode(9);
		IntTreeNode tenth = new IntTreeNode(10);
		IntTreeNode eleventh = new IntTreeNode(11);
		IntTreeNode twelvth = new IntTreeNode(12);
		IntTreeNode thirteenth = new IntTreeNode(13);
		
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		fourth.left = eighth;
		fifth.left = tenth;
		third.right = seventh;
		eighth.left = ninth;
		ninth.left = eleventh;
		eleventh.left = twelvth;
		twelvth.left = thirteenth;

    	
    	//			      1
    	//		        /   \
    	//		       2     3
    	//  	      / \     \
    	//  	     4   5     7
    	//          /    /
    	//         8   10
		//	      /
		//       9
		//      /
		//    11
		//	  /
		//   12
		//  / 
		// 13
    	
    	//Start burning at node 10
    	//Takes 5 seconds
    	assertEquals(9, IntTreeNode.minTime(first, 7));

	}
	
	/*
	 * Asymmetrical Tree with height of 8
	 * Target Node on left side of tree
	 */
	@Test
	public void NormalCase2_AsymmetricalTreeHeight8() {
		IntTreeNode first = new IntTreeNode(1);
		IntTreeNode second = new IntTreeNode(2);
		IntTreeNode third = new IntTreeNode(3);
		IntTreeNode fourth = new IntTreeNode(4);
		IntTreeNode fifth = new IntTreeNode(5);
		IntTreeNode seventh = new IntTreeNode(7);
		IntTreeNode eighth = new IntTreeNode(8);
		IntTreeNode ninth = new IntTreeNode(9);
		IntTreeNode tenth = new IntTreeNode(10);
		IntTreeNode eleventh = new IntTreeNode(11);
		IntTreeNode twelvth = new IntTreeNode(12);
		IntTreeNode thirteenth = new IntTreeNode(13);
		
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		fourth.left = eighth;
		fifth.left = tenth;
		third.right = seventh;
		eighth.left = ninth;
		ninth.left = eleventh;
		eleventh.left = twelvth;
		twelvth.left = thirteenth;

    	
    	//			      1
    	//		        /   \
    	//		       2     3
    	//  	      / \     \
    	//  	     4   5     7
    	//          /    /
    	//         8   10
		//	      /
		//       9
		//      /
		//    11
		//	  /
		//   12
		//  / 
		// 13
    	
    	//Start burning at node 10
    	//Takes 5 seconds
    	assertEquals(7, IntTreeNode.minTime(first, 5));

	}
	
}
