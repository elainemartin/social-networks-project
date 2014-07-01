import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Users {
	private static int[] users = new int[2315];

	public Users(String inputFile) throws FileNotFoundException {
		users = getUsers(inputFile);
	}

	public static int[] getUsers(String inputFile) throws FileNotFoundException {
		File userFile = new File(inputFile);
		Scanner in = new Scanner(userFile);
		for(int i = 0; i<2315; ++i) {
			users[i] = in.nextInt();
		}
		Arrays.sort(users);
		return users;
	}

	public static boolean checkUser(int userID) throws FileNotFoundException {
		boolean found = false;
		int low = 0;
		int position = 0;
		int high = users.length - 1;
		while (low <= high && !found) {
			position = (low + high) / 2;
			if (users[position] == userID)
				found = true;
			else if (users[position] < userID)
				low = position + 1;
			else high = position - 1;
		}
		if (found)
			return true;
		else
			return false;
	}	
}