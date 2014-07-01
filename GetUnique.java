import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class GetUnique {
	public static void main(String[] args) throws FileNotFoundException {
		//printUnique();
		sortUnique();
	}

	public static void sortUnique() throws FileNotFoundException {
		File input = new File("uniqueFriends.txt");
		Scanner in = new Scanner(input);
		final int UNIQUE = 9706;
		int[] uniqueFriends = new int[UNIQUE];
		for (int i = 0; i < UNIQUE; ++i) {
			uniqueFriends[i] = in.nextInt();
		}
		Arrays.sort(uniqueFriends);
		in.close();
		
		File output = new File("uniqueFriends.txt");
		PrintWriter out = new PrintWriter(output);
		for(int userID:uniqueFriends) {
			out.println(userID);
		}
		out.close();
	}

	public static void printUnique() throws FileNotFoundException {
		File friendships = new File("SFfriendships.txt");
		Scanner in = new Scanner(friendships);
		final int SIZE = 68812;
		int[] friend1 = new int[SIZE/2];
		int[] friend2 = new int[SIZE/2];		

		for(int i = 0; i < SIZE/2; ++i){
				friend1[i] = in.nextInt();
				friend2[i] = in.nextInt();
				in.nextLine();
			//while(in.hasNextLine()) {			
				in.nextLine(); //skip line
			//}
		}

		Arrays.sort(friend1);
		Arrays.sort(friend2);

		File output = new File("uniqueFriends.txt");
		PrintWriter out = new PrintWriter(output);

		for(int i = 1; i < SIZE/2; ++i){
			if(friend1[i] != friend1[i-1])
				out.println(friend1[i-1]);
			boolean inBoth = checkBoth(friend2[i-1], friend1);
			if(friend2[i] != friend2[i-1] && !inBoth)
				out.println(friend2[i-1]);
							//System.out.println(i);
		}
		in.close();
		out.close();

	}

	public static boolean checkBoth(int userID2, int[] friend1) {
		boolean found = false;
		int low = 0;
		int position = 0;
		int high = friend1.length - 1;
		while (low <= high && !found) {
			position = (low + high) / 2;
			if (friend1[position] == userID2)
				found = true;
			else if (friend1[position] < userID2)
				low = position + 1;
			else high = position - 1;
		}
		if (found)
			return true;
		else
			return false;
	}
}