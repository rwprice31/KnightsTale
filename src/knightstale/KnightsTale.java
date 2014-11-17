package knightstale;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;


public class KnightsTale 
{
	public static UserStatistics userstats = new UserStatistics();
	
	public static enum RoomType {
		None(0),
		Fight(1),
		Puzzle(2),
		Boss(3),
		Stair(4);
		
		public int value;
		RoomType(int p){
			value = p;
		}
		public int getValue(){
			return value;
		}
	}
	/*
	public static enum CharacterType{
		Hero(1),
		Monster(2)
	}
	public static enum ElementType{
		None(0),
		Earth(1),
		Fire(2),
		Water(3),
		Wind(4)
	}
	public static enum ItemType{
		Hero(1),
		Monster(2),
		Puzzle(3),
		Room(4)
	}*/
	
	
	
	public static void main(String[] args) throws Exception 
	{		
		boolean loggedIn = false;		
		
		System.out.println("Welcome to Knights Tale the game.");
		
		while (loggedIn == false)
		{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please enter your selection: (L)oad a game or start (N)ew game");
			String Choice = userInput.nextLine();		
			
			if(isValidSelection(Choice.trim()) == true)
			{				
				String username = "";
				while (username=="")
				{
					if (Choice.toUpperCase().equals("L"))
					{
						System.out.println("Please enter the username of the game you wish to load:");
						username = userInput.nextLine();	
						try
						{
							userstats = new UserStatistics(username);							
							loggedIn = true;
						}
						catch(Exception ex)
						{
							username = "";
							System.out.println("Unable to load the desired game.");
						}						
					}
					else 
					{
						username = "NewUser";
						CreateUserStats(username);
						userstats = new UserStatistics(username);						
						CreateMap(userstats.gameNumber);
						CreateRooms(userstats.gameNumber);
						//createrooms
						//createmonsters
						
					}
									
					try
					{
						userstats = new UserStatistics(username);
						loggedIn = true;
					}
					catch(Exception ex)
					{
						username = "";
						System.out.println("Unable to load the desired game.");
					}
				}
								
			}
			else
			{
				System.out.println("Please choose a valid selection.");
			}

		}
		
		//Start of game loops once the user logs in.
		while(loggedIn == true)
		{
			//PlayGame(userstats.gameNumber);
			
			// This will stop the game
			loggedIn = false;
		}
	}

	
	
	public static boolean isValidSelection(String Choice)
	{
		if (Choice.toUpperCase().equals("L") | Choice.toUpperCase().equals("N") ){
			return true;
		}
		else 		{
			return false;
		}
	}

	private static void CreateUserStats(String userID) throws Exception
	{
		userstats.CreateUserStatistics(userID, 1, 10, 1, 0);
	}
	
	private static void CreateMap(int gameNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		db.executeStmt("insert Into Maps values('"+ gameNumber +"'");
		db.closeConnection();
	}

	private static void CreateRooms(int gameNumber) 
	{
		// TODO auto generate 50 rooms specific to this gamenumber
		
		for(int x=0; x<5;x++) // 5 levels
		{
			for(int y=0; y<10; y++){
				//create room
				switch(GetRandomNumber(1,4))				
				{
				case 1:
					//Boss
					break;
				case 2:
					//Fight
					break;
				case 3:
					//Puzzle
					break;
				case 4:
					//Stair
					break;
				}
			}
			
		}
	}
	
	
	private static int GetRandomNumber(int min, int max)
	{		
		Random rn = new Random();
		int range = max - min;
		int rnd = rn.nextInt(range) + 1;	
		
		return rnd;
	}
	
	
}
