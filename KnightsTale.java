import java.sql.ResultSet;
import java.util.Scanner;



public class KnightsTale 
{

	private static String currentUser = null;

	public static void main(String[] args) throws Exception 
	{
		
		//Loop to login the user and set their user name to currentUser.
		boolean loggedIn = false;
		while (loggedIn == false)
		{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Welcome to Knights Tale, Please enter your username");
			String username = userInput.nextLine();
			System.out.println("Please enter your password");
			String userPassword = userInput.nextLine();

			//Checks to see if user name and password match.
			if(login(username, userPassword) == true)
			{
				setCurrentUser(username);
				loggedIn = true;
			}
			else
			{
				System.out.println("Incorrect Login Information");
			}

		}
		
		//Start of game loops once the user logs in.
		while(loggedIn == true)
		{
			System.out.println("blah blah blah");
			
			// This will stop the game
			loggedIn = false;
		}
	}

	//Method to check login and make sure the username and password match.
	public static boolean login(String userName, String enteredPassword) throws Exception
	{
		String userPassword = null;
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/game.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select user_password from login where user_name = '" + userName +"'");
		while(rs.next())
		{
			userPassword = rs.getString("user_password");
		}
		db.closeConnection();
		if (enteredPassword.equals(userPassword))
		{
			return true;
		}
		//Returns False if Password is Wrong
		else
		{
			return false;
		}

	}

	/**
	 * @return the currentUser
	 */
	public String getCurrentUser()
	{
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public static void setCurrentUser(String currUser)
	{
		currUser = currentUser;
	}


}
