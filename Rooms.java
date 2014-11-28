import java.sql.ResultSet;


public class Rooms 
{
	private int RoomID;
	private String UserName;
	private int RoomNumber;
	private String RoomType;
	private String Item1;
	private String Item2;
	private String Item3;
	private int PuzzleID;
	private boolean Visited;
	/**
	 * @return the roomID
	 * @throws Exception 
	 */
	public int getRoomID() throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select RoomID from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			RoomID = rs.getInt("RoomID");
		}
		db.closeConnection();
		return RoomID;
	}
	/**
	 * @param roomID the roomID to set
	 * @throws Exception 
	 */
	public void setRoomID(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the userName
	 * @throws Exception 
	 */
	public String getUserName(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select UserName from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			UserName = rs.getString("UserName");
		}
		db.closeConnection();
		return UserName;
	}
	/**
	 * @param userName the userName to set
	 * @throws Exception 
	 */
	public void setUserName(String UserName, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set UserName ='" + UserName +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the roomNumber
	 * @throws Exception 
	 */
	public int getRoomNumber(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select RoomNumber from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			RoomNumber = rs.getInt("RoomNumber");
		}
		db.closeConnection();
		return RoomNumber;
	}
	/**
	 * @param roomNumber the roomNumber to set
	 * @throws Exception 
	 */
	public void setRoomNumber(int RoomNumber, int RoomID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set RoomNumber ='" + RoomNumber +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the roomType
	 * @throws Exception 
	 */
	public String getRoomType(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select RoomType from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			RoomType = rs.getString("RoomType");
		}
		db.closeConnection();
		return RoomType;
	}
	/**
	 * @param roomType the roomType to set
	 * @throws Exception 
	 */
	public void setRoomType(String RoomType, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set RoomType ='" + RoomType +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the item1
	 * @throws Exception 
	 */
	public String getItem1(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Item1 from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			Item1 = rs.getString("Item1");
		}
		db.closeConnection();
		return Item1;
	}
	/**
	 * @param item1 the item1 to set
	 * @throws Exception 
	 */
	public void setItem1(String Item1, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms setItem1 ='" + Item1 +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the item2
	 * @throws Exception 
	 */
	public String getItem2(int RoomID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select UserName from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			Item2 = rs.getString("Item2");
		}
		db.closeConnection();
		return Item2;
	}
	/**
	 * @param item2 the item2 to set
	 * @throws Exception 
	 */
	public void setItem2(String Item2, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms setItem2 ='" + Item2 +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the item3
	 * @throws Exception 
	 */
	public String getItem3(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Item3 from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			Item3 = rs.getString("Item3");
		}
		db.closeConnection();
		return Item3;
	}
	/**
	 * @param item3 the item3 to set
	 * @throws Exception 
	 */
	public void setItem3(String Item3, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set Item3 ='" + Item3 +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the puzzleID
	 * @throws Exception 
	 */
	public int getPuzzleID(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select PuzzleID from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			PuzzleID = rs.getInt("PuzzleID");
		}
		db.closeConnection();
		return PuzzleID;
	}
	/**
	 * @param puzzleID the puzzleID to set
	 * @throws Exception 
	 */
	public void setPuzzleID(int PuzzleID, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set PuzzleID ='" + PuzzleID +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}
	/**
	 * @return the visited
	 * @throws Exception 
	 */
	public boolean isVisited(int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Visited from Rooms where RoomID = '"+ RoomID +"'");
		while(rs.next())
		{
			Visited = rs.getBoolean("Visited");
		}
		db.closeConnection();
		return Visited;
	}
	/**
	 * @param visited the visited to set
	 * @throws Exception 
	 */
	public void setVisited(boolean Visited, int RoomID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Rooms set Visited ='" + Visited +"'where RoomID = '"+ RoomID +"'");
		db.closeConnection();
	}

}
