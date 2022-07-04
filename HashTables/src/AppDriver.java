public class AppDriver {

	public static void main(String[] args) {
		if(args.length < 2 || args.length > 3) {
			System.out.println("Error: Invalid number of arguments specified.");
			System.exit(1);
		}
		if(args[0].equals("-q")) {
			Utility myTest = new Utility(args[0], args[1], args[2]);
			myTest.readData();
			myTest.searchData();
		}
		else {
			Utility myTest = new Utility("nullFlag", args[0], args[1]);
			myTest.readData();
			myTest.searchData();
		}
	}
}