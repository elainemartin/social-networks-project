import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Venues {
	private static int[] venues = new int[12974];

	public Venues() throws FileNotFoundException {
		venues = getVenues();
	}

	public static int[] getVenues() throws FileNotFoundException {
		File venueFile = new File("SFvenues.txt");
		Scanner in = new Scanner(venueFile);
		for(int i = 0; i<12974; ++i) {
			venues[i] = in.nextInt();
		}
		Arrays.sort(venues);
		return venues;
	}

	public static boolean checkVenue(int venueID) throws FileNotFoundException {
		boolean found = false;
		int low = 0;
		int position = 0;
		int high = venues.length - 1;
		while (low <= high && !found) {
			position = (low + high) / 2;
			if (venues[position] == venueID)
				found = true;
			else if (venues[position] < venueID)
				low = position + 1;
			else high = position - 1;
		}
		if (found)
			return true;
		else
			return false;
	}	
}