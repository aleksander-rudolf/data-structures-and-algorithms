public class AppDriver {

	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("Error: Invalid number of arguments specified.");
			System.exit(1);
		}
		
		Utility myTest = new Utility(args[0], args[1], args[2], args[3]);
		myTest.readData();
		myTest.depthFirstPath();
		myTest.breadthFirstPath();
	}
}
