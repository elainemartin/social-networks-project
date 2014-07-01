import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FriendshipFilter {
	public static void main(String[] args) throws FileNotFoundException {
		//filterFriends();
		filterFriends2();

	}
	public static void filterFriends() throws FileNotFoundException {
		File friendships = new File("socialgraph.txt");
		Scanner in = new Scanner(friendships);
		File output = new File("SFfriendships.txt");
		PrintWriter out = new PrintWriter(output);

		Users users = new Users("SFusers.txt");
		in.nextLine(); //skip header
		while(in.hasNextLine()){

			int userID1 = in.nextInt();
			in.next();
			int userID2 = in.nextInt();

			boolean inSF1 = users.checkUser(userID1);
			boolean inSF2 = users.checkUser(userID2);

			if (inSF1 && inSF2)
				out.println(userID1+" "+userID2);
		}
		in.close();
		out.close();
	}
	public static void filterFriends2() throws FileNotFoundException {
		File friendships = new File("SFfriendships.txt");
		Scanner in = new Scanner(friendships);
		File output = new File("finalFriends.txt");
		PrintWriter out = new PrintWriter(output);

		Users users = new Users("finalUsers.txt");
		//in.nextLine(); //skip header
		while(in.hasNextLine()){

			int userID1 = in.nextInt();
			int userID2 = in.nextInt();
			in.nextLine();
			String reverse = in.nextLine();

			boolean inSF1 = users.checkUser(userID1);
			boolean inSF2 = users.checkUser(userID2);

			if (inSF1 && inSF2) {				
				out.println(userID1+" "+userID2);
				out.println(reverse);
			}
		}
		in.close();
		out.close();
	}
}