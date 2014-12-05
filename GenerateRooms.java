import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.TooManyListenersException;


public class GenerateRooms
{

	public static ArrayList<String> getPuzzleItems() throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = db.executeQry("select Name from Items where Type = 'Puzzle'");
		while(rs.next())
		{
			//int itemID = rs.getInt("ItemID");
			String itemName = rs.getString("Name");
			al.add(itemName);

		}
		db.closeConnection();	
		return al;
	}
	public static ArrayList<String> getOtherItems() throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = db.executeQry("select Name from Items where Type = 'Chest' ");
		while(rs.next())
		{
			//int itemID = rs.getInt("ItemID");
			String itemName = rs.getString("Name");
			al.add(itemName);

		}
		db.closeConnection();	
		return al;
	}
	public static ArrayList<String> getRoomItems() throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = db.executeQry("select Name from Items where Type = 'Room' ");
		while(rs.next())
		{
			//int itemID = rs.getInt("ItemID");
			String itemName = rs.getString("Name");
			al.add(itemName);

		}
		db.closeConnection();	
		return al;
	}
	
	
	public static void createRooms(String user_name) throws Exception
	{
		ArrayList<String> items = new ArrayList<String>();
		items = getOtherItems();
		ArrayList<String> puzzleItems = new ArrayList<String>();
		puzzleItems = getPuzzleItems();
		ArrayList<String> roomItems = new ArrayList<String>();
		roomItems = getRoomItems();
		ArrayList<String> roomType = new ArrayList<String>();
		roomType.add("Fight");


		
		Db db = new Db();
		db.getConnection();
		for(int i = 1; i <51; i++)
		{
			String roomtype = roomType.get(GetRandomNumber(roomType.size()));
			String itemOne = items.get(GetRandomNumber(items.size()));
			String itemTwo = items.get(GetRandomNumber(items.size()));
			String itemThree = items.get(GetRandomNumber(items.size()));
			String roomItemOne = roomItems.get(GetRandomNumber(roomItems.size()));
			String roomItemTwo = roomItems.get(GetRandomNumber(roomItems.size()));
			String roomItemThree = roomItems.get(GetRandomNumber(roomItems.size()));
			String roomItemFour = roomItems.get(GetRandomNumber(roomItems.size()));
			String puzzleItemOne = puzzleItems.get(GetRandomNumber(puzzleItems.size()));
			String puzzleItemTwo = puzzleItems.get(GetRandomNumber(puzzleItems.size()));
			String puzzleItemThree = puzzleItems.get(GetRandomNumber(puzzleItems.size()));
			
			
			
			int itemOneQuantity = GetRandomNumber(9)+1;
			int itemTwoQuantity = GetRandomNumber(9)+1;
			int itemThreeQuantity = GetRandomNumber(9)+1;
			int ppassword = (itemOneQuantity+itemTwoQuantity+itemThreeQuantity);
			
			//Stair Room
			if ( i == 4 || i ==14 || i ==24 || i ==34 || i ==44 )
			{
				db.executeStmt("insert into Rooms (user_name,RoomNumber,RoomType,Visited)"
						+ "VALUES ('" + user_name + "','" + i + "','Stair','false')");
				
			}
			//Boss Room
			else if( i == 7 || i ==17 || i ==27 || i ==37|| i == 47 )
			{
				db.executeStmt("insert into Rooms (user_name,RoomNumber,RoomType, Item1,Item2,Item3,Visited)"
						+ "VALUES ('" + user_name + "','" + i + "','Boss','" + itemOne + "','" + itemTwo + "','" + itemThree + "','false')");
			}
			// Chest
			else if(i % 5 == 0  )
			{
				db.executeStmt("insert into Rooms (user_name,RoomNumber,RoomType, Item1,Item1Quantity,Item2,Item2Quantity,Item3,Item3Quantity,Visited,PuzzlePassword,PuzzleItemOne,PuzzleItemTwo,PuzzleItemThree)"
						+ "VALUES ('" + user_name + "','" + i + "','Chest','" + itemOne + "','" + itemOneQuantity + "','" + itemTwo + "','" + itemTwoQuantity + "','" + itemThree + "','" + itemThreeQuantity + "','false','" + ppassword + "','" + puzzleItemOne + "','" + puzzleItemTwo + "','" + puzzleItemThree + "')");
			}
			//Fight room
			else
			{
				db.executeStmt("insert into Rooms (user_name,RoomNumber,RoomType, Item1,Item2,Item3,Visited,RoomItem1,RoomItem2,RoomItem3,RoomItem4)"
						+ "VALUES ('" + user_name + "','" + i + "','" + roomtype + "','" + itemOne + "','" + itemTwo + "','" + itemThree + "','false','" + roomItemOne + "','" + roomItemTwo + "','" + roomItemThree + "','" + roomItemFour + "')");
			}


		
			
			
		}
		db.closeConnection();
	}

	// General method used to generate any random numbers
	private static int GetRandomNumber(int number)
	{		
		Random rn = new Random();
		int rnd = rn.nextInt(number);	

		return rnd;
	}}
