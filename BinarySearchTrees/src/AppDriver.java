public class AppDriver {

	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("Invalid number of arguments specified.");
			System.exit(1);
		}
		
		Utility myTest = new Utility(args[0], args[1], args[2]);
		myTest.readData();
		myTest.inOrder(myTest.getBinaryTree().getRoot());
		System.out.println();
		myTest.breadthFirst(myTest.getBinaryTree().getRoot());
		
	}
}
