import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserFilter {
	public static void main(String[] args) throws FileNotFoundException {
		File original = new File("users.txt");
		File output = new File("SFusers.txt");

		// System.out.println("Row count: " + checkLineCount(original));
		filterUsers(original, output);
	}

	public static final double MINLAT  = 37.707;
	public static final double MAXLAT  = 37.810;
	public static final double MINLONG = -122.520;
	public static final double MAXLONG = -122.355;

	public static void filterUsers(File original, File output) throws FileNotFoundException {
		Scanner in = new Scanner(original);
		PrintWriter out = new PrintWriter(output);

		// Skip the first line
		String header = in.nextLine();
		out.println(header);
		
		int row = 2;
		while (in.hasNextLine()) {
			int user = 0;
			double latitude  = 0;
			double longitude = 0;

			// Parse numbers from line.
			if (in.hasNextInt())
				user = in.nextInt();
			in.next();
			if (in.hasNextDouble())		
				latitude  = in.nextDouble();
			in.next();
			if (in.hasNextDouble())
				longitude = in.nextDouble();
			
			// Write valid numbers to file.
			if (latitude > MINLAT && latitude < MAXLAT && longitude > MINLONG && longitude < MAXLONG) {
				out.println(user);
				//System.out.println("User: " + user);
			}
		
			in.nextLine();
			//System.out.println("Row #: " + row++);
		}

		// Close objects
		in.close();
		out.close();
	}


	public static int checkLineCount(File file) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(file);
		int rowCount = 0;

		while (fileScanner.hasNextLine()) {
			++rowCount;
			fileScanner.nextLine();
		}

		fileScanner.close();
		return rowCount;
	}
}
