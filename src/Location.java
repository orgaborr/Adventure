import java.util.Map;

public class Location {
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int locationID, String description) {
		this.locationID = locationID;
		this.description = description;
	}
	
	
}
