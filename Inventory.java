import java.sql.ResultSet;


public class Inventory 
{
	private int InventoryID;
	private int UserName;
	private int ItemID;
	
	public Inventory(int InventoryID, int UserName, int ItemID)
	{
		super();
		this.InventoryID = InventoryID;
		this.UserName = UserName;
		this.ItemID = ItemID;
	}

	/**
	 * @return the InventoryID
	 * @throws Exception 
	 */
	public int getInventoryID() throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select InventoryID from Inventory where InventoryID = '"+ InventoryID +"'");
		while(rs.next())
		{
			InventoryID = rs.getInt("InventoryID");
		}
		db.closeConnection();
		return InventoryID;
	}

	/**
	 * @param InventoryID the InventoryID to set
	 * @throws Exception 
	 */
	public void setInventoryID(int InventoryID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Inventory set InventoryID ='" + InventoryID + "'");
		db.closeConnection();
	}

	/**
	 * @return the UserName
	 * @throws Exception 
	 */
	public int getUserName(int InventoryID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select InventoryID from Inventory where InventoryID = '"+ InventoryID +"'");
		while(rs.next())
		{
			UserName = rs.getInt("UserName");
		}
		db.closeConnection();
		return UserName;
	}

	/**
	 * @param UserName the UserName to set
	 * @throws Exception 
	 */
	public void setUserName(int UserName, int InventoryID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Inventory set UserName ='" + UserName +"'where InventoryID = '"+ InventoryID +"'");
		db.closeConnection();
	}

	/**
	 * @return the itemID
	 * @throws Exception 
	 */
	public int getItemID(int InventoryID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select ItemID from Inventory where InventoryID = '"+ InventoryID +"'");
		while(rs.next())
		{
			ItemID = rs.getInt("ItemID");
		}
		db.closeConnection();
		return ItemID;
	}

	/**
	 * @param itemID the itemID to set
	 * @throws Exception 
	 */
	public void setItemID(int ItemID, int InventoryID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Inventory set ItemID ='" + ItemID +"'where InventoryID = '"+ InventoryID +"'");
		db.closeConnection();
	}
	
	

}
