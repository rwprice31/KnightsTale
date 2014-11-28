import java.sql.ResultSet;


public class Characters 
{
	private int CharacterID;
	private String ItemName;
	private String Name;
	private String ElementType;
	private int Health;
	private boolean Boss;
	private int RoomNumber;
	private String UserName;
	
	public Characters(int CharacterID, String ItemName, String Name,
			String ElementType, int Health, boolean Boss, int RoomNumber)
	{
		super();
		this.CharacterID = CharacterID;
		this.ItemName = ItemName;
		this.Name = Name;
		this.Health = Health;
		this.Boss = Boss;
		this.RoomNumber = RoomNumber;
	}
	
	
	/**
	 * @return the characterID
	 * @throws Exception 
	 */
	public int getCharacterID() throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getCharacterID from Characters where CharacterID = '"+ CharacterID +"'");
		while(rs.next())
		{
			CharacterID = rs.getInt("CharacterID");
		}
		db.closeConnection();
		return CharacterID;
	}
	/**
	 * @param characterID the characterID to set
	 * @throws Exception 
	 */
	public void setCharacterID(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set CharacterID ='" + CharacterID +"'");
		db.closeConnection();
	}
	/**
	 * @return the characterType
	 * @throws Exception 
	 */
	public String getItemName(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getItemName from Characters where CharacterID = '"+ CharacterID +"'");
		while(rs.next())
		{
			ItemName = rs.getString("ItemName");
		}
		db.closeConnection();
		return ItemName;
	}
	/**
	 * @param characterType the characterType to set
	 * @throws Exception 
	 */
	public void setItemName(String ItemName, int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set ItemName ='" + ItemName +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}
	/**
	 * @return the name
	 * @throws Exception 
	 */
	public String getName(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getName from Characters where CharacterID = '"+ CharacterID +"'");
		while(rs.next())
		{
			Name = rs.getString("Name");
		}
		db.closeConnection();
		return Name;
	}
	/**
	 * @param name the name to set
	 * @throws Exception 
	 */
	public void setName(String Name, int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set Name ='" + Name +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}
	/**
	 * @return the elementType
	 * @throws Exception 
	 */
	public String getElementType(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getElementType from Characters where CharacterID = '"+ CharacterID +"'");
		while(rs.next())
		{
			ElementType = rs.getString("ElementType");
		}
		db.closeConnection();
		return ElementType;
	}
	/**
	 * @param elementType the elementType to set
	 * @throws Exception 
	 */
	public void setElementType(String ElementType, int CharacterID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set ElementType ='" + ElementType +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}
	/**
	 * @return the initialHealth
	 * @throws Exception 
	 */
	public int getHealth(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getName from Characters where CharacterID = '"+ CharacterID +"'");
		while(rs.next())
		{
			Health = rs.getInt("Health");
		}
		db.closeConnection();
		return Health;
	}
	/**
	 * @param initialHealth the initialHealth to set
	 * @throws Exception 
	 */
	public void setHealth(int CharacterID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set Health ='" + Health +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}
	/**
	 * @return the Boss
	 * @throws Exception 
	 */
	public boolean Boss(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Boss from Characters where CharacterID = '"+ CharacterID +"'");
		while(rs.next())
		{
			Boss = rs.getBoolean("Boss");
		}
		db.closeConnection();
		return Boss;
	}
	/**
	 * @param Boss the Boss to set
	 * @throws Exception 
	 */
	public void setBoss(boolean Boss, int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set Boss ='" + Boss +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}


	/**
	 * @return the roomNumber
	 * @throws Exception 
	 */
	public int getRoomNumber(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getName from Characters where CharacterID = '"+ CharacterID +"'");
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
	public void setRoomNumber(int RoomNumber, int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set RoomNumber ='" + RoomNumber +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}


	/**
	 * @return the userName
	 * @throws Exception 
	 */
	public String getUserName(int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getUserName from Characters where CharacterID = '"+ CharacterID +"'");
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
	public void setUserName(String UserName, int CharacterID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Character set UserName ='" + UserName +"'where CharacterID = '"+ CharacterID +"'");
		db.closeConnection();
	}
	
	

}

