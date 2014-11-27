package knightstale;


public class KnightsTale 
{
	// global variable to help keep track of user status
	public static UserStatistics userstats = new UserStatistics();
	
	
	public static void main(String[] args) throws Exception 
	{		
		UserStatistics userstats = new Initialize().GetUserStats();
	}
		
}
