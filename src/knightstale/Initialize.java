package knightstale;
import java.sql.ResultSet;
import java.util.Random;

public class Initialize {
	
	public Initialize(){}
	
	
	// Method use to create all rooms to be populated in the map layout of the game.
	public static boolean CreateRooms(String user_name) throws Exception 
	{
		boolean rtn = false;
		
		try
		{
			// auto generate 50 rooms specific to this user_name
			int r = 1; //room #
			String floor = "";
			
			for(int x=0; x<5;x++) // 5 levels
			{		
				switch(x+1)
				{
				case 1:
					floor = "Fire";
					break;
				case 2:
					floor = "Water";
					break;
				case 3:
					floor = "Earth";
					break;
				case 4:
					floor = "Wind";
					break;
				case 5:
					floor = "All";
					break;
				}			
				
				Room insertRoom = new Room();			
				// first 8 random rooms
				for(int y=1; y<=8; y++,r++){
					insertRoom = new Room();
					insertRoom.RoomNumber = r;								
					insertRoom.user_name = user_name; 
					
					if (x+1 == 5){
						switch (GetRandomNumber(0,4))
						{
						case 1:
							floor = "Fire";
							break;
						case 2:
							floor = "Water";
							break;
						case 3:
							floor = "Earth";
							break;
						case 4:
							floor = "Wind";
							break;
						}
					}
					
					
					//create room
					switch(GetRandomNumber(0,4))				
					{
					case 1:
						//Boss
						insertRoom.RoomType="Boss";
						
						//get random room objects
						insertRoom.Item1 = getRandomRoomItem("Room")[0][0];
						insertRoom.Item2 = getRandomRoomItem("Room")[0][0];
						insertRoom.Item3 = getRandomRoomItem("Room")[0][0];					
						insertRoom.CreateRoom();
						
						//Create Monster
						CreateRandomMonster(floor, 1, user_name, r);
						
						break;
					case 2:
						//Fight
						insertRoom.RoomType="Fight";
						
						//get random room objects
						insertRoom.Item1 = getRandomRoomItem("Room")[0][0];
						insertRoom.Item2 = getRandomRoomItem("Room")[0][0];
						insertRoom.Item3 = getRandomRoomItem("Room")[0][0];					
						insertRoom.CreateRoom();
						
						//Create Monster
						CreateRandomMonster(floor, 0, user_name, r);
						
						break;
					case 3:
						//Puzzle
						insertRoom.RoomType="Puzzle";
											
						//get random room objects
						String[][] arr1 = getRandomRoomItem(insertRoom.RoomType);
						String[][] arr2 = getRandomRoomItem(insertRoom.RoomType);
						String[][] arr3 = getRandomRoomItem(insertRoom.RoomType);					
						insertRoom.Item1 = arr1[0][0];
						insertRoom.Item2 = arr2[0][0];
						insertRoom.Item3 = arr3[0][0];
						insertRoom.PuzzlePassword = arr1[0][1] + " " + arr2[0][1] + " " + arr3[0][1];
						insertRoom.CreateRoom();
						
						//Create Monster
						//CreateRandomMonster(floor, 0, user_name, r);
						
						break;
					case 4:
						//Chest
						insertRoom.RoomType = "Chest";
						
						//get random room objects
						insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType)[0][0];
						insertRoom.Item2 = getRandomRoomItem(insertRoom.RoomType)[0][0];
						insertRoom.Item3 = getRandomRoomItem(insertRoom.RoomType)[0][0];					
						insertRoom.CreateRoom();					
						
						//Create Monster
						CreateRandomMonster(floor, 0, user_name, r);
						
						break;
					}
				}
				
				// room 9 = puzzle room
				insertRoom = new Room();
				insertRoom.user_name = user_name;
				insertRoom.RoomNumber = r;
				insertRoom.RoomType="Puzzle";
							
				String[][] arr1 = getRandomRoomItem(insertRoom.RoomType);
				String[][] arr2 = getRandomRoomItem(insertRoom.RoomType);
				String[][] arr3 = getRandomRoomItem(insertRoom.RoomType);					
				insertRoom.Item1 = arr1[0][0];
				insertRoom.Item2 = arr2[0][0];
				insertRoom.Item3 = arr3[0][0];
				insertRoom.PuzzlePassword = arr1[0][1] + " " + arr2[0][1] + " " + arr3[0][1];
				insertRoom.CreateRoom();
				//Create Monster
				//CreateRandomMonster(floor, 0, user_name, r);			
				r++;
				
				// room 10 = stair room
				insertRoom = new Room();
				insertRoom.user_name = user_name;
				insertRoom.RoomNumber = r;
				insertRoom.RoomType="Stair";
				
				insertRoom.Item1 = getRandomRoomItem(insertRoom.RoomType)[0][0];
				insertRoom.CreateRoom();
				//Create Monster
				//CreateRandomMonster(floor, 0, user_name, r);			
				r++;
			}
			
			rtn = true;
		}
		catch (Exception ex)
		{
			rtn = false;
		}
		return rtn;
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
	private static void CreateRandomMonster(String floor, int isBoss, String user_name, int roomNumber) throws Exception
	{	
		String[]items = new String[25];
		String tempBoss = "";
		int x=0;
		
		Db db = new Db();
		
		Monster monster = new Monster();
		monster.ElementType = floor;
		if (isBoss == 1){
			monster.Health = 10;
			monster.Name = "Boss " + floor + " Monster";} 
		else {
			monster.Health = 5;
			monster.Name =  floor + " Monster";
			tempBoss = " AND isBoss = '0'";}
		monster.isBoss = isBoss;
		monster.RoomNumber = roomNumber;
		monster.user_name = user_name;		
		
		try 
		{			
			db.getConnection();	
			String statement = "SELECT * FROM items WHERE Type = '" + floor + " Monster' " + tempBoss;
			ResultSet rs = db.executeQry(statement);
			while(rs.next())
			{
				items[x] = rs.getString("Name");
				x++;
			}
			
			while(monster.ItemName == null)
			{
				monster.ItemName =  items[GetRandomNumber(0,x)];			
			}
			
			monster.CreateMonster();
		}
		catch(Exception ex){}
		finally
		{
			db.closeConnection();
		}
			
	}
	
	// generate random room items 
	private static String[][] getRandomRoomItem(String RoomType) throws Exception
	{
		String[][]items = new String[50][2];
		int x=0;
		String[][] rtn = new String[1][2];
		
		Db db = new Db();
		
		try 
		{			
			db.getConnection();								
			ResultSet rs = db.executeQry("SELECT * FROM Items WHERE type = '" + RoomType + "'" ) ;
			while(rs.next())
			{
				items[x][0] = rs.getString("Name");
				items[x][1] = rs.getString("PuzzleKeyword");
				x++;
			}
			
			while(rtn[0][0] == null)
			{
				rtn[0] = items[GetRandomNumber(0,x)];				
			}
		}
		catch(Exception ex){}
		finally
		{
			db.closeConnection();
		}
			
		return rtn;
	}
	
}