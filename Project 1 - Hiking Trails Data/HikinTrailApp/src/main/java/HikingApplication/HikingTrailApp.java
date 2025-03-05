package HikingApplication;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HikingTrailApp {
	public static void main(String[] args) {
		// Load data from single ArrayList prior to any user input
		// User must be allowed to display the data over and over again
		ArrayList<HikingTrail> trails = new ArrayList<>();
		String fileName = "C:\\Users\\thega\\OneDrive - Brookdale Community College\\COMP 228 - Data Structures\\Project 1 - Hiking Trails Data\\HikinTrailApp\\src\\main\\java\\Documents_and_CVS\\MonmouthCountyNJ_Hiking_Trails.csv";
		trails = loadTrailsFromCSV(fileName);

		if (trails.isEmpty()) {
			System.out.println("No Trails Found");
			return; // Exit if no data is available
		}

		runMenu(trails);

	}

	// --- Methods ---
	// Load Trail Data Method
	private static ArrayList<HikingTrail> loadTrailsFromCSV(String filePath) {
		ArrayList<HikingTrail> trails = new ArrayList<>();

		// Try to open and read the file
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				// Read a line and validate it
				String line = scanner.nextLine();
				if (line.trim().isEmpty()) continue; // Skip empty lines

				// Split the line into columns
				String[] columns = line.split(",");
				if (columns.length < 7) {
					continue;
				}

				try {
					// Create a HikingTrail object
					HikingTrail trail = new HikingTrail(
							columns[0], // Trail Name
							Integer.parseInt(columns[1]), // Length in Feet
							Double.parseDouble(columns[2]), // Length in Miles
							Integer.parseInt(columns[3]), // Difficulty
							columns[4], // Description
							columns[5], // Park Name
							columns[6]  // Surface Types
					);

					// Add to the list
					trails.add(trail);
				} catch (NumberFormatException e) {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filePath);
		}

		return trails;
	}


	// Menu Method
	private static void runMenu(ArrayList<HikingTrail> trails) {
		Scanner scanner = new Scanner(System.in);

		boolean keepRunning = true;
		while (keepRunning) {
			// Display menu options
			System.out.println("\nHiking Trails Menu:");
			System.out.println("1. Display trails in Original Order");
			System.out.println("2. Display trails in Sorted Order");
			System.out.println("3. Display trails in Random Order");
			System.out.println("4. Exit");

			// Get user input
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			// Process the user's input
			switch (choice) {
				case 1:
					System.out.println("\nTrails in Original Order:");
					sortOriginalOrder(trails);
					break;

				case 2:
					System.out.println("\nTrails in Sorted Order:");
					sortSortedOrder(trails);
					break;

				case 3:
					System.out.println("\nTrails in Random Order:");
					sortRandomOrder(trails);
					break;

				case 4:
					System.out.println("Exiting the program. Goodbye!");
					keepRunning = false;
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}


	// Sort Data Method - Original Order
	private static void sortOriginalOrder(ArrayList<HikingTrail> trails) {
		// Simply display the trails in their original order
		for (HikingTrail trail : trails) {
			System.out.println(trail);
		}
	}

	// Sort Data Method - Sorted Order
	private static void sortSortedOrder(ArrayList<HikingTrail> trails) {
		// Create a new list to avoid modifying the original order
		ArrayList<HikingTrail> sortedTrails = new ArrayList<>(trails);

		// Sort the list based on trail length (miles); if equal, compare by feet
		sortedTrails.sort((t1, t2) -> {
			int compareMiles = Double.compare(t1.getLengthMiles(), t2.getLengthMiles());
			if (compareMiles == 0) {
				return Integer.compare(t1.getLengthFeet(), t2.getLengthFeet());
			}
			return compareMiles;
		});

		// Display the sorted list
		for (HikingTrail trail : sortedTrails) {
			System.out.println(trail);
		}
	}

	// Sort Data Method - Random Order
	private static void sortRandomOrder(ArrayList<HikingTrail> trails) {
		// Create a new list to avoid modifying the original order
		ArrayList<HikingTrail> randomTrails = new ArrayList<>(trails);

		// Shuffle the list randomly
		Collections.shuffle(randomTrails);

		// Display the shuffled list
		for (HikingTrail trail : randomTrails) {
			System.out.println(trail);
		}
	}
}
