/* 
 * Description: This program represents a class called IntTreeNode. 
 * The class includes constructor to create a IntTreeNode with a left and a
 * right node. A method called minTime is used to find the minimum time
 * for the complete binary tree to burn when a target node is set on fire.
 * Input: The root node and the target value
 * Output: The minimum time required to burn the complete tree
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//An IntTreeNode object is one node in a binary tree of ints.
public class IntTreeNode {
    public int data; // data stored at this node
    public IntTreeNode left; // reference to left subtree
    public IntTreeNode right; // reference to right subtree

    // Constructs a leaf node with the given data.
    public IntTreeNode(int data) {
        this(data, null, null);
    }

    // Constructs a branch node with the given data and links.
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    /**
     * This method uses a breadth-first search algorithm to find the minimum
     * time required for a complete binary tree to burn after a target node is
     * set on fire. The target node is set on fire at the 0th second and it takes
     * 1 second for the fire to travel to each node attached to the burning node.
     * 
     * @param root node
     * @param target node's value
     * @return time for the complete tree to burn
     */
	public static int minTime(IntTreeNode root, int target) {
    	
    	Map<Integer, Integer> parents = new HashMap<>();//Node -> Parent Node
    	Map<Integer, Integer> times = new HashMap<>();//Node -> Time Taken to Burn
    	
    	//Add root node to map (with no parent node)
    	parents.put(root.data, 0);
    	
    	//Helper method called to map the rest of nodes with their parent nodes
    	map(root,parents);
    	
    	//If the target node is not found in the map
    	if (!parents.containsKey(target) || (root.left == null && root.right == null)) {
    		return 0; //Return a time of 0 seconds
    	}
  
    	
    	Queue <Integer> q = new LinkedList<>(); //keep track of "visited" nodes
    	
    	//Adds node set on fire and set time to 0 seconds
    	times.put(target, 0);
    	q.add(target);//Adds the initial node set on fire
    	
    	int front = 0; 
    	
    	//Breadth-First Search Algorithm
    	while (!q.isEmpty()) {
    		front = q.remove();
    		
    		
    		for (Integer key : parents.keySet()) { //for each node in the tree
    			
    			//if the key is a parent node  and the node is not already mapped
    			if (key == front && !(times.containsKey(parents.get(key)))) { 
    				//Add the node and increase the time
    				times.put(parents.get(front), times.get(front) + 1); 
    				q.add(parents.get(key));//Add the node to the priority queue
    			}
    			
    			//If the key is a child node and the node is not already mapped
    			if (parents.get(key) == front && !(times.containsKey(key))) {
    				times.put(key, times.get(front) + 1); //Add the node and increase the time
    				q.add(key);//Add the node to the priority queue
    			}

    		}

    	}
    	
    	//Returns the time of the last node burned
    	return times.get(front);
    	
    }
	
	

	/**
	 * Helper method used to map the nodes (as keys) to their parent 
	 * nodes (as values). The first node is the root node and the method
	 * recursively calls each sub-tree until all nodes are mapped.
	 * 
	 * @param node
	 * @param node-to-parent map
	 */
	private static void map(IntTreeNode node, Map<Integer, Integer> map){
		
		if (node != null) {
			
			//If there is a left node
			if (node.left != null) {
	    		map.put(node.left.data, node.data);
	    	}
			
			//If there is a right node
	    	if (node.right != null) {
	    		map.put(node.right.data, node.data);
	    	}
	    	
	    	map(node.left, map); //Map left node
	    	map(node.right, map); //Map right node
	 
		}
		
	}
    
}
