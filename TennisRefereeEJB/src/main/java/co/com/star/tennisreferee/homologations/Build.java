package co.com.star.tennisreferee.homologations;

import java.util.HashMap;
import java.util.Map;

public class Build {
	
	private static Map<Integer, String> scoreDescription = null;

	private Build() {}
	
	public static Map<Integer, String> getScoreDescription() {
		if (scoreDescription == null) buildInstance();
		return scoreDescription;
	}
 
	private synchronized static void buildInstance() {
		
		scoreDescription = new HashMap<>();
		
		scoreDescription.put(0, "Love");
		scoreDescription.put(1, "Quince");
		scoreDescription.put(2, "Treinta");
		scoreDescription.put(3, "Cuarenta");
		
	}
	
} 
