import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class RatingsFilter {
	public static void main(String[] args) throws FileNotFoundException {
		filterRatings();
	}
	public static void filterRatings() throws FileNotFoundException {
		File input = new File("ratings.txt");
		Scanner in = new Scanner(input);
		File output = new File("SFratings.txt");
		PrintWriter out = new PrintWriter(output);

		// Skip the first line
		String header = in.nextLine();
		out.println(header);
		
		int row = 2;
		Venues venues = new Venues();
		while (in.hasNextLine()) {
			//int user = 0;
			int venue  = 0;
			int rating = 0;

			// Parse numbers from line.
			in.nextInt();
			in.next();
			venue = in.nextInt();
			in.next();
			rating = in.nextInt();


			boolean inSF = venues.checkVenue(venue);
			
			// Write valid numbers to file.
			if (inSF) {
				out.println(venue+","+rating);
				//System.out.println("User: " + user);
			}
		
			in.nextLine();
			//System.out.println("Row #: " + row++);
		}

		// Close objects
		in.close();
		out.close();
	}
}