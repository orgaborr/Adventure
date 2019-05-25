import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));
		
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
//		locations.get(1).addExit("Q", 0);
		
		locations.get(2).addExit("N", 5);
//		locations.get(2).addExit("Q", 0);
		
		locations.get(3).addExit("W", 1);
//		locations.get(3).addExit("Q", 0);
		
		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
//		locations.get(1).addExit("Q", 0);
		
		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);
//		locations.get(5).addExit("Q", 0);
		
		
		int loc = 1; //loc is going to be the key in the Map
		while(true) {
			//notice that locations' elements have access to the classes methods inside
			System.out.println(locations.get(loc).getDescription()); //getDescription returns a String
			if(loc == 0) { 
				break; //our quit command
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.print("Available exits are ");
			for(String exit: exits.keySet()) { //we have to specify it is the keySet we are looping through
				System.out.print(exit + ", ");
			}
			System.out.println();
			
			
			String input = sc.nextLine().toUpperCase(); //makes sure the direction's characters are upper case
			String[] inputArray = input.split(" "); //turns input into an array
			
//			for(String direction : inputArray) {
//				System.out.println(direction);
//			}

			for(String direction : inputArray) {
				
				if(exits.containsKey(direction)) {
					loc = exits.get(direction);
					break;
				}

			}
			System.out.println("You can not go in that direction");
		}
		
		sc.close();
	}

}
