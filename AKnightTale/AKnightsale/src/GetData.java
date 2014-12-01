import java.sql.ResultSet;
import java.util.ArrayList;


public class GetData
{

	static String roomType;
	static String puzzleItemOne;
	static String puzzleItemTwo;
	static String puzzleItemThree;
	static String useableItemOne;
	static String useableItemTwo;
	static String useableItemThree;
	static String puzzleItemOneQuantity;
	static String puzzleItemTwoQuantity;
	static String puzzleItemThreeQuantity;
	static String puzzlePassword;

	public static void main(String[] args) throws Exception
	{

		System.out.println(getRoomType("joe",3));

	}

	public static String  getRoomType(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			roomType = rs.getString("RoomType");

		}
		db.closeConnection();

		return roomType;

	}
	public String  getRoomPuzzleItemOne(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			puzzleItemOne = rs.getString("puzzleItemOne");
			puzzleItemTwo = rs.getString("puzzleItemTwo");
			puzzleItemThree = rs.getString("puzzleItemThree");

		}
		db.closeConnection();

		return puzzleItemOne;

	}
	public String  getRoomPuzzleItemTwo(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			puzzleItemTwo = rs.getString("puzzleItemTwo");
		}
		db.closeConnection();

		return puzzleItemTwo;

	}
	public String  getRoomPuzzleItemThree(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{

			puzzleItemThree = rs.getString("puzzleItemThree");

		}
		db.closeConnection();

		return puzzleItemThree;

	}
	public String  getRoomPuzzleItemOneQuantity(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			puzzleItemOneQuantity = rs.getString("Item1Quantity");


		}
		db.closeConnection();

		return puzzleItemOneQuantity;

	}
	public String  getRoomPuzzleItemTwoQuantity(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			puzzleItemTwoQuantity = rs.getString("Item2Quantity");
		}
		db.closeConnection();

		return puzzleItemTwoQuantity;

	}
	public String  getRoomPuzzleItemThreeQuantity(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{

			puzzleItemThreeQuantity = rs.getString("Item3Quantity");

		}
		db.closeConnection();

		return puzzleItemThreeQuantity;

	}
	public String  getRoomPuzzleSolution(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{

			puzzlePassword = rs.getString("PuzzlePassword");

		}
		db.closeConnection();

		return puzzlePassword;
	}
	public void  getRoomUseableItems(String username, int roomNumber)
	{

	}
	public String  getUseableItemOne(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			useableItemOne = rs.getString("Item1");


		}
		db.closeConnection();

		return useableItemOne;

	}
	public String  getUseableItemTwo(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{
			useableItemTwo = rs.getString("Item2");
		}
		db.closeConnection();

		return useableItemTwo;

	}
	public String  getUseableItemThree(String username, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select * from Rooms where user_name = '"+ username +"' AND RoomNumber =  '"+ roomNumber +"'");
		while(rs.next())
		{

			useableItemThree = rs.getString("Item3");

		}
		db.closeConnection();

		return useableItemThree;

	}

}
