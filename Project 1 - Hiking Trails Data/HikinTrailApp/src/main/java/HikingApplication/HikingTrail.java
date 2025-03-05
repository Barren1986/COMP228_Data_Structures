package HikingApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This is the data class - will not have a main method
public class HikingTrail implements Comparable<HikingTrail>{
	// Attributes/Instance Variables
	private String trailName;
	private int lengthFeet;
	private double lengthMiles;
	private int difficultyClass;
	private String trailDescription;
	private String parkName;
	private String surfaceTypes;

	//Constructors
	public HikingTrail() {}

	// Initializes HikingTrail object
	public HikingTrail(String trailName, int lengthFeet, double lengthMiles, int difficultyClass, String trailDescription, String parkName, String surfaceTypes) {
		this.trailName = trailName;
		this.lengthFeet = lengthFeet;
		this.lengthMiles = lengthMiles;
		this.difficultyClass = difficultyClass;
		this.trailDescription = trailDescription;
		this.parkName = parkName;
		this.surfaceTypes = surfaceTypes;
	}

	// Methods

	// Prints the object and displays it as a string
	@Override
	public String toString() {
		return "Trail Name: " + trailName + "\n" +
				"Length (Miles): " + lengthMiles + "\n" +
				"Length (Feet): " + lengthFeet + "\n" +
				"Difficulty: " + difficultyClass + "\n" +
				"Description: " + trailDescription + "\n" +
				"Park Name: " + parkName + "\n" +
				"Surface Type: " + surfaceTypes + "\n";
	}


		// Compares the Hiking objects and allows to be sorted easier
		// the compareTo will sort by miles and use the feet a tiebreaker
	@Override
	public int compareTo(HikingTrail other) {
		int mileComparison = Double.compare(this.lengthMiles, other.lengthMiles);

		// if miles are equal, use feet as a tiebreaker
		if (mileComparison == 0) {
			return Integer.compare(this.lengthFeet, other.lengthFeet);
		}

		return mileComparison;
	}
	// Using the List<>/Array<> creates a new sorted list
	public static List<HikingTrail> sortTrailLength(List<HikingTrail> trails) {
		List<HikingTrail> sortedTrails = new ArrayList<>(trails);
		Collections.sort(sortedTrails);
		return sortedTrails;
	}


	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public String getSurfaceTypes() {
		return surfaceTypes;
	}

	public void setSurfaceTypes(String surfaceTypes) {
		this.surfaceTypes = surfaceTypes;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getTrailDescription() {
		return trailDescription;
	}

	public void setTrailDescription(String trailDescription) {
		this.trailDescription = trailDescription;
	}

	public int getDifficultyClass() {
		return difficultyClass;
	}

	public void setDifficultyClass(int difficultyClass) {
		this.difficultyClass = difficultyClass;
	}

	public double getLengthMiles() {
		return lengthMiles;
	}

	public void setLengthMiles(double lengthMiles) {
		this.lengthMiles = lengthMiles;
	}

	public int getLengthFeet() {
		return lengthFeet;
	}

	public void setLengthFeet(int lengthFeet) {
		this.lengthFeet = lengthFeet;
	}
}
