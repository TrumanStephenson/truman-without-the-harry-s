package decisionmaking;

import java.util.ArrayList;

public class TreeList {
	
	private ArrayList<Trees> treeList = new ArrayList<>();
	
	// Objects for list
	public void addTree(Trees tree) {
		treeList.add(tree);
	}
	
	// Display the objects
	public void printAllTrees() {
		for(Trees x : treeList) {
			System.out.println(x);
		}
	}
	
	// Finds object at given index 
	public Trees findTree(int index) {
		return index >= 0 && index < treeList.size() ? treeList.get(index) : null;
	}
	
	// This will remove a tree from the index
	public void removeTree(int index) {
		if (index >= 0 && index < treeList.size()) {
			treeList.remove(index);
		}
	}
	
	
	
	
}
