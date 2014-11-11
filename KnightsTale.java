import java.util.Scanner;



public class KnightsTale
{
	
	public static int Floor;
	public static int Room;
	public static Boolean gameStart = true;

	public static void main(String[] args) throws ClassNotFoundException
	{
		
		Scanner userIn = new Scanner(System.in);
		String userName;
		String userPassword;
		
		while (gameStart = true)
		{
			
			System.out.println("Please enter your username:");
			userName = userIn.nextLine();
			System.out.println("Please enter your password:");
			userPassword = userIn.nextLine();
			Login login = new Login();
			
			if(login.UserAuthentication(userName, userPassword) == true)
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("Please try again");	
			}
			
			
			
		}
	}

}
