import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class GetIDfromCheckins {
	public static void main(String[] args) throws FileNotFoundException {
		//getID();
		finalVenues();
	}
	public static void getID() throws FileNotFoundException {
		File input = new File("SFcheckins.csv");
		Scanner in = new Scanner(input).useDelimiter("[,]+");
		final int SFCHECKINS = 27564;
		int[] checkinUsers = new int[SFCHECKINS];
		int[] checkinVenues = new int[SFCHECKINS];
		in.nextLine(); //skip header

		for(int i = 0; i < SFCHECKINS; ++i) {
			checkinUsers[i] = in.nextInt();
			//System.out.println(checkinUsers[i]);
			checkinVenues[i] = in.nextInt();
			//System.out.println(checkinVenues[i]);
			in.nextLine();
		}

		in.close();
		
		Arrays.sort(checkinUsers);
		Arrays.sort(checkinVenues);

		File userOutput = new File("checkinUsers.txt");
		File venueOutput = new File("checkinVenues.txt");
		PrintWriter userOut = new PrintWriter(userOutput);
		PrintWriter venueOut = new PrintWriter(venueOutput);

		//print unique
		for(int i = 1; i < SFCHECKINS; ++i) {
			if(checkinUsers[i] != checkinUsers[i-1])
				userOut.println(checkinUsers[i-1]);
			if(checkinVenues[i] != checkinVenues[i-1])
				venueOut.println(checkinVenues[i-1]);
		}


		userOut.close();
		venueOut.close();
	}

	public static void finalVenues() throws FileNotFoundException {
		File input = new File("finalCheckins.csv");
		Scanner in = new Scanner(input).useDelimiter("[,]+");
		final int SFCHECKINS = 7257;
		//int[] checkinUsers = new int[SFCHECKINS];
		int[] checkinVenues = new int[SFCHECKINS];
		in.nextLine(); //skip header

		for(int i = 0; i < SFCHECKINS; ++i) {
			in.nextInt();
			//System.out.println(checkinUsers[i]);
			checkinVenues[i] = in.nextInt();
			//System.out.println(checkinVenues[i]);
			in.nextLine();
		}

		in.close();
		
		//Arrays.sort(checkinUsers);
		Arrays.sort(checkinVenues);

		//File userOutput = new File("checkinUsers.txt");
		File venueOutput = new File("finalVenues.txt");
		//PrintWriter userOut = new PrintWriter(userOutput);
		PrintWriter venueOut = new PrintWriter(venueOutput);

		//print unique
		for(int i = 1; i < SFCHECKINS; ++i) {
			//if(checkinUsers[i] != checkinUsers[i-1])
			//	userOut.println(checkinUsers[i-1]);
			if(checkinVenues[i] != checkinVenues[i-1])
				venueOut.println(checkinVenues[i-1]);
		}


		//userOut.close();
		venueOut.close();
	}
}