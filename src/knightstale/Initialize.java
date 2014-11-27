package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Initialize {
	private static UserStatistics _userStats = new UserStatistics();
	
	public Initialize(){}
	
	// Method use to load a previously saved game or create a new game using passed credentials.
	@SuppressWarnings("unused")
	public Initialize(String user_name) throws Exception
	{			
		//if user_name exists in UserStatistics table
		if (new UserStatistics(user_name).userID != "")
		{//	Load UserStats class and return it
			try {
				_userStats = new UserStatistics(user_name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else
		{//
			// setup all needed userstats/maps/rooms/monsters to have all info for a new game.			
			try {
				CreateUserStats(user_name);
				CreateRooms(user_name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
	}
	
	//  Method use to access the internal UserStatistics object
	public UserStatistics GetUserStats()
	{		
		return _userStats;
	}

	
	
	
	
	

	// Method to create the userstats for new game
	private static void CreateUserStats(String user_name) throws Exception
	{
		_userStats.CreateUserStatistics(user_name, 1, 10, "Bronze Sword", 0);
	}
	
	// Method use to create all rooms to be populated in the map layout of the game.
	private static void CreateRooms(String user_name) throws Exception 
	{
		// auto generate 50 rooms specific to this user_name
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
					
					//get random room objects
					insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType);
					insertRoom.Item2 = getRandomRoomItem(insertRoom.RoomType);
					insertRoom.Item3 = getRandomRoomItem(insertRoom.RoomType);
					
					insertRoom.CreateRoom();
					break;
				case 2:
					//Fight
					insertRoom.RoomType="Fight";
					
					//get random room objects
					insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType);
					insertRoom.Item2 = getRandomRoomItem(insertRoom.RoomType);
					insertRoom.Item3 = getRandomRoomItem(insertRoom.RoomType);
					
					insertRoom.CreateRoom();
					break;
				case 3:
					//Puzzle
					insertRoom.RoomType="Puzzle";
										
					//get random room objects
					insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType);
					insertRoom.Item2 = getRandomRoomItem(insertRoom.RoomType);
					insertRoom.Item3 = getRandomRoomItem(insertRoom.RoomType);
					
					insertRoom.CreateRoom();
					break;
				case 4:
					//Chest
					insertRoom.RoomType = "Chest";
					break;
				}
			}
			
			// room 9 = puzzle room
			insertRoom = new Room();
			insertRoom.RoomNumber = r;
			insertRoom.RoomType="Puzzle";
						
			insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType);
			insertRoom.Item2 = getRandomRoomItem(insertRoom.RoomType);
			insertRoom.Item3 = getRandomRoomItem(insertRoom.RoomType);
			insertRoom.CreateRoom();
			r++;
			
			// room 10 = stair room
			insertRoom = new Room();
			insertRoom.RoomNumber = r;
			insertRoom.RoomType="Stair";
;			
			insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType);
			insertRoom.Item2 = getRandomRoomItem(insertRoom.RoomType);
			insertRoom.Item3 = getRandomRoomItem(insertRoom.RoomType);
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
	private static String getRandomRoomItem(String RoomType) throws Exception
	{
		int[]items = new int[50];
		int x=0;
		String rtn = "";
		
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
