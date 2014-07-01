import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FriendshipMatrix {

	public static void main(String[] args) throws FileNotFoundException {
		printMatrix();
	}

	public static void printMatrix() throws FileNotFoundException {
		File header = new File("finalUsers.txt");
		Scanner column = new Scanner(header);
		File friendships = new File("finalFriends.txt");
		Scanner in = new Scanner(friendships);
		File output = new File("FriendshipMatrix.txt");
		PrintWriter out = new PrintWriter(output);

		final int UNIQUE = 2315;
		int sfriends = 10632;
		int[] uniqueFriends = new int[UNIQUE];
		int[][] friends = new int[sfriends][2];

		//read in data
		for (int i = 0; i < UNIQUE; ++i) {
			uniqueFriends[i] = column.nextInt();
		}
		for (int i = 0; i < sfriends; ++i) {			
			friends[i][0] = in.nextInt();
			friends[i][1] = in.nextInt();
		}
		in.close();
		column.close();

		for (int i = 0; i < UNIQUE; ++i) {
			for (int j = 0; j < UNIQUE; ++j) {
				if (uniqueFriends[i] == uniqueFriends[j]) {
					out.print("0 ");
				} else {					
					int found = findFriendship(uniqueFriends[i], uniqueFriends[j], friends);
					if (found != -1) {
						//System.out.println(uniqueFriends[i]+" "+uniqueFriends[j]);
						out.print("1 ");
						friends[found][0] = friends[sfriends-1][0];
						friends[found][1] = friends[sfriends-1][1];
						--sfriends;
						System.out.println(sfriends);
					} else 
						out.print("0 ");
				}
			}
			out.println();
			//System.out.println(i);
		}
		out.close();
	}

	public static int findFriendship(int userID1, int userID2, int[][] friends) {
		for (int i = 0; i < friends.length; ++i) {
			if (userID1 == friends[i][0] && userID2 == friends[i][1])
				return i;
			}
		return -1;
	}
}