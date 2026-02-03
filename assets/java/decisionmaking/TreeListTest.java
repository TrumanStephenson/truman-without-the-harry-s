package decisionmaking;

public class TreeListTest {
	
	public static void main (String[] args) {
		
		// Instance of Tree List
		TreeList treeList = new TreeList();
		
		treeList.addTree(new Trees("Sugar Pine", 600, 55));
		treeList.addTree(new Trees("Ponderosa Pine", 600, 7.6));
		treeList.addTree(new Trees("Sequoia", 2200, 85));
		treeList.addTree(new Trees("Monterey Pine", 100, 35));
		treeList.addTree(new Trees("Madrone", 200, 25));
		treeList.addTree(new Trees("Manzanita", 100, 6));
		treeList.addTree(new Trees("Maritime Chaparral", 70, 3));
		
		
		// Displays the trees
		System.out.println("Trees: ");
		treeList.printAllTrees();
		
		
		// Finding a specific tree in the index
		int findTree = 4;
		Trees foundTree = treeList.findTree(findTree);
		if(foundTree != null) {
			System.out.println("\nTree at index " + findTree + ": " + foundTree);
		} else {
			System.out.println("\nTree not found at index: " + findTree);
		}
		
		// Remove a tree from the specific index
		int removeTreeAtIndex = 2;
		treeList.removeTree(removeTreeAtIndex);
		System.out.println("\nRemoved tree at index: " + removeTreeAtIndex + ":");
		treeList.printAllTrees();
		
	}
	
}
