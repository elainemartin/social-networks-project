import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class CheckinMatrix {

	public static void main(String[] args) throws FileNotFoundException {
		printMatrix(args[0], args[1]);
	}

	public static void printMatrix(String inputFile, String outputFile) throws FileNotFoundException {
		File userFile = new File("finalUsers.txt");
		Scanner row = new Scanner(userFile);
		File venueFile = new File("finalVenues.txt");
		Scanner column = new Scanner(venueFile);

		File checkins = new File(inputFile);
		Scanner in = new Scanner(checkins);//.useDelimiter("[,]+");
		File output = new File(outputFile);
		PrintWriter out = new PrintWriter(output);

		final int NUSERS = 2315;
		final int NVENUES = 1745;
		int[] users = new int[NUSERS];
		int[] venues = new int[NVENUES];
		ArrayList<Integer> userIDs = new ArrayList<Integer>();
		ArrayList<Integer> venueIDs = new ArrayList<Integer>();

		//read in data
		for (int i = 0; i < NUSERS; ++i) {
			users[i] = row.nextInt();
		}
		for (int i = 0; i < NVENUES; ++i) {			
			venues[i] = column.nextInt();
		}
		in.nextLine(); //skip header
		while(in.hasNextLine()) {
			userIDs.add(in.nextInt());
			venueIDs.add(in.nextInt());
			//System.out.println(in.nextInt());
			//System.out.println(in.next());
			//in.nextLine();
		}

		in.close();
		row.close();
		column.close();

		for (int i = 0; i < NUSERS; ++i) {
			for (int j = 0; j < NVENUES; ++j) {				
				int found = findPair(users[i], venues[j], userIDs, venueIDs);
				if (found != -1) {
					//System.out.println(users[i]+" "+uniqueFriends[j]);
					out.print("1 ");
					userIDs.remove(found);
					venueIDs.remove(found);
					System.out.println(userIDs.size());
				} else 
					out.print("0 ");
			}
			out.println();
			//System.out.println(i);
		}
		out.close();
	}

	public static int findPair(int userID, int venueID, ArrayList<Integer> userIDs, ArrayList<Integer> venueIDs) {
		for (int i = 0; i < userIDs.size(); ++i) {
			if (userID == userIDs.get(i) && venueID == venueIDs.get(i))
				return i;
			}
		return -1;
	}
}