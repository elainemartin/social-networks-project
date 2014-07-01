import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class CheckinFilter {
	public static void main(String[] args) throws FileNotFoundException {
		//filterCheckins();
		filterAgain();
	}
	/*public static void filterCheckins() throws FileNotFoundException {
		File original = new File("checkins.txt");
		Scanner in = new Scanner(original);//.useDelimiter("[|\\s]+");
		File output = new File("SFcheckins.txt");
		PrintWriter out = new PrintWriter(output);
		/*final double MINLAT = 37.707;
		final double MAXLAT = 37.810;
		final double MINLONG = -122.520;
		final double MAXLONG = -122.355;
		String header = in.nextLine();
		out.println(header);
		Users users = new Users();
		Venues venues = new Venues();
		int row = 2;
		while (in.hasNextLine()) {			
			int checkinID = in.nextInt();
				in.next();
			int userID = in.nextInt();
				in.next();
			int venueID = in.nextInt();
				in.next();
			boolean sfVenue = venues.checkVenue(venueID);
			boolean sfUser = users.checkUser(userID);
			if (!sfVenue && !sfUser) {
				in.nextLine();
				System.out.println(row);
			}
			else {	
				if(in.hasNextDouble()) {						
					in.nextDouble();
					in.next();
					in.nextDouble();
					in.next();
				}
				else {
					in.next();
					in.next();
				}
				String date = in.next();
				String time = in.next();
				out.println(userID+","+venueID+","+date);//+","+time);
				in.nextLine();
				System.out.println(row);	
			}		
		} 
		in.close();
		out.close();
	} */
	public static void filterAgain() throws FileNotFoundException {
		File original = new File("SFcheckins.csv");
		Scanner in = new Scanner(original).useDelimiter("[,\\n]+");
		File output = new File("finalCheckins.txt");
		PrintWriter out = new PrintWriter(output);

		String header = in.nextLine();
		out.println(header);
		Users users = new Users("finalUsers.txt");
		//Venues venues = new Venues();
		//int row = 2;
		while (in.hasNextLine()) {			
			//int checkinID = in.nextInt();
			//	in.next();
			int userID = in.nextInt();
			//	in.next();
			String rest = in.nextLine();
			//	in.next();
			//boolean sfVenue = venues.checkVenue(venueID);
			boolean sfUser = users.checkUser(userID);
			if (sfUser) {
				/*if(in.hasNextDouble()) {						
					in.nextDouble();
					in.next();
					in.nextDouble();
					in.next();
				}
				else {
					in.next();
					in.next();
				}*/
				//String date = in.next();
				//String time = in.next();
				out.println(userID+rest);//+","+time);
				//in.nextLine();
				//System.out.println(row);	
			}		
		} 
		in.close();
		out.close();
	} 

}