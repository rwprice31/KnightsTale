package knightstale;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;


public class KnightsTale 
{
	// global variable to help keep track of user status
	public static UserStatistics userstats = new UserStatistics();
	
	
	public static void main(String[] args) throws Exception 
	{		
		boolean loggedIn = false;		
		
		System.out.println("Welcome to Knights Tale the game.");
		
		// first loop - wait for user to enter a selection of load an old game or create a new game.
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
					// if the desire choise is to LOAD, then user must specify a saved name to load
					if (Choice.toUpperCase().equals("L"))
					{
						System.out.println("Please enter the username of the game you wish to load:");
						username = userInput.nextLine();	
						try
						{
							//load userstats with contents from DB
							userstats = new UserStatistics(username);							
							loggedIn = true;
						}
						catch(Exception ex)
						{
							username = "";
							System.out.println("Unable to load the desired game.");
						}						
					}
					// if selected to Start a new game 
					else 
					{
						try
						{
							// setup all needed userstats/maps/rooms/monsters to have all info for a new game.
							username = "NewUser";
							CreateUserStats(username);
							userstats = new UserStatistics(username);						
							CreateMap();
							userstats = new UserStatistics(username);
							CreateRooms();
							loggedIn = true;
						}
						catch (Exception ex) 
						{
							username = "";
							System.out.println("Unable to initiate a new game.");
						}
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

	
	
	
	
	// Method used to check user entered choices to ensure 
	// the selection is valid
	public static boolean isValidSelection(String Choice)
	{
		if (Choice.toUpperCase().equals("L") | Choice.toUpperCase().equals("N") ){
			return true;
		}
		else 		{
			return false;
		}
	}

	// Method to create the user stats for new game
	private static void CreateUserStats(String userID) throws Exception
	{
		userstats.CreateUserStatistics(userID, 1, 10, 1, 0, 0);
	}
	
	// Method use to create a map for new game
	private static void CreateMap() throws Exception
	{
		Db db = new Db();
		db.getConnection();
		
		db.executeStmt("INSERT INTO Maps VALUES(NULL," + userstats.gameNumber + ")" );
		ResultSet rs = db.executeQry("SELECT MapID FROM Maps WHERE gameNumber = " + userstats.gameNumber);
		
		//update userstats with mapid
		try 
		{ 
			int tmp_mapid = rs.getInt("MapID");
			db.executeStmt("UPDATE UserStatistics SET MapID = " + tmp_mapid + " WHERE gameNumber = "+ userstats.gameNumber);
		}
		catch(Exception ex){}
		
		db.closeConnection();		
	}

	// Method use to create all rooms to be populated in the map layout of the game.
	private static void CreateRooms() throws Exception 
	{
		// TODO auto generate 50 rooms specific to this gamenumber
		int r = 1; //room #
		for(int x=0; x<5;x++) // 5 levels
		{		
			Room insertRoom = new Room();
			// first 8 random rooms
			for(int y=1; y<=8; y++,r++){
				insertRoom = new Room();
				insertRoom.RoomNumber = r;
				
				//create room
				switch(GetRandomNumber(0,3))				
				{
				case 1:
					//Boss
					insertRoom.RoomType="Boss";
					insertRoom.MapID = userstats.mapID;
					//get 3 different monsters (character ID)
					insertRoom.Character1 = getRandomCharacter(true);
					//character2id = getRandomCharacter(true);
					//character3id = getRandomCharacter(true);
					
					//get random room objects
					insertRoom.Item1 = getRandomRoomItem();
					insertRoom.Item2 = getRandomRoomItem();
					insertRoom.Item3 = getRandomRoomItem();
					
					insertRoom.CreateRoom();
					break;
				case 2:
					//Fight
					insertRoom.RoomType="Fight";
					insertRoom.MapID = userstats.mapID;
					//get 3 different monsters (character ID)
					insertRoom.Character1 = getRandomCharacter(false);
					//character2id = getRandomCharacter(false);
					//character3id = getRandomCharacter(false);
					
					//get random room objects
					insertRoom.Item1 = getRandomRoomItem();
					insertRoom.Item2 = getRandomRoomItem();
					insertRoom.Item3 = getRandomRoomItem();
					
					insertRoom.CreateRoom();
					break;
				case 3:
					//Puzzle
					insertRoom.RoomType="Puzzle";
					insertRoom.MapID = userstats.mapID;
					//get 3 different monsters (character ID)
					insertRoom.Character1 = getRandomCharacter(false);
					//character2id = getRandomCharacter(false);
					//character3id = getRandomCharacter(false);
					
					//get random room objects
					insertRoom.Item1 = getRandomRoomItem();
					insertRoom.Item2 = getRandomRoomItem();
					insertRoom.Item3 = getRandomRoomItem();
					
					insertRoom.CreateRoom();
					break;
				//case 4:
					//Stair
					//break;
				}
			}
			
			// room 9 = puzzle room
			insertRoom = new Room();
			insertRoom.RoomNumber = r;
			insertRoom.RoomType="Puzzle";
			insertRoom.MapID = userstats.mapID;
			insertRoom.Character1 = getRandomCharacter(false);			
			insertRoom.Item1 = getRandomRoomItem();
			insertRoom.Item2 = getRandomRoomItem();
			insertRoom.Item3 = getRandomRoomItem();
			insertRoom.CreateRoom();
			r++;
			
			// room 10 = stair room
			insertRoom = new Room();
			insertRoom.RoomNumber = r;
			insertRoom.RoomType="Stair";
			insertRoom.MapID = userstats.mapID;
			insertRoom.Character1 = getRandomCharacter(false);			
			insertRoom.Item1 = getRandomRoomItem();
			insertRoom.Item2 = getRandomRoomItem();
			insertRoom.Item3 = getRandomRoomItem();
			insertRoom.CreateRoom();
			r++;
		}
	}
	
	// General method used to generate any random numbers
	private static int GetRandomNumber(int min, int max)
	{		
		Random rn = new Random();
		int range = max - min;
		int rnd = rn.nextInt(range) + 1;	
		
		return rnd;
	}
	
	// Method use to get the character list from DB and generate a random monster to use in the rooms
	private static int getRandomCharacter(boolean _isBoss) throws Exception
	{
		//
		int isBoss = 0;
		if(_isBoss) { isBoss = 1;}
		int[]characters = new int[4];
		int x=0,rtn=0;
		
		Db db = new Db();
		
		try 
		{			
			db.getConnection();								
			ResultSet rs = db.executeQry("SELECT * FROM Characters WHERE CharacterType = 'Monster' and isBoss = " + isBoss);
			while(rs.next())
			{
				characters[x] = rs.getInt("CharacterID");
				x++;
			}
			rtn = characters[GetRandomNumber(0,characters.length)];			
		}
		catch(Exception ex){}
		finally
		{
			db.closeConnection();
		}
			
		return rtn;
	}
	
	// generate random room items 
	private static int getRandomRoomItem() throws Exception
	{
		int[]items = new int[25];
		int x=0,rtn=0;
		
		Db db = new Db();
		
		try 
		{			
			db.getConnection();								
			ResultSet rs = db.executeQry("SELECT * FROM Items WHERE Name <> 'Sword'");
			while(rs.next())
			{
				items[x] = rs.getInt("ItemID");
				x++;
			}
			rtn = items[GetRandomNumber(0,x)];			
		}
		catch(Exception ex){}
		finally
		{
			db.closeConnection();
		}
			
		return rtn;
	}
	
}
