import java.sql.ResultSet;


public class Items 
{
	private int ItemID;
	private String Name;
	private String Description;
	private String Type;
	private String Element;
	private String RivalElement;
	private boolean InventoryUse;
	private boolean IsBoss;
	private String PuzzleKeyword;
	private double BonusHealth;
	private int Possibility;
	
	public Items(String Name, String Description, int ItemID,
			String Type, String Element, String RivalElement, boolean InventoryUse,
			boolean IsBoss, String PuzzleKeyword, double BonusHealth, int Possibility)
	{
		super();
		this.ItemID = ItemID;
		this.Description = Description;
		this.Element = Element;
		this.InventoryUse = InventoryUse;
		this.Name = Name;
		this.RivalElement = RivalElement;
		this.IsBoss = IsBoss;
		this.PuzzleKeyword = PuzzleKeyword;
		this.Possibility = Possibility;
		
	}
	
	
	/**
	 * @return the itemID
	 * @throws Exception 
	 */
	public int getItemID() throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select getItemID from Items where ItemID = '"+ ItemID +"'");
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
	public void setItemID(int ItemID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set ItemID ='" + ItemID +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}
	
	public String getName(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Name from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			Name = rs.getString("Name");
			
		}
		db.closeConnection();
		return Name;
	}
	
	public void setName(String Name, int ItemID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set Name ='" + Name +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the type
	 * @throws Exception 
	 */
	public String getType(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Type from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			Type = rs.getString("Type");
		}
		db.closeConnection();
		return Type;
	}

	/**
	 * @param type the type to set
	 * @throws Exception 
	 */
	public void setType(String Type, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set Type ='" + Type +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the element
	 * @throws Exception 
	 */
	public String getElement(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Element from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			Element = rs.getString("Element");
			
		}
		db.closeConnection();
		return Element;
	}

	/**
	 * @param element the element to set
	 * @throws Exception 
	 */
	public void setElement(String Element, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set Element ='" + Element +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the rivalElement
	 * @throws Exception 
	 */
	public String getRivalElement(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select RivalElement from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			RivalElement = rs.getString("RivalElement");
			
		}
		db.closeConnection();
		return RivalElement;
	}

	/**
	 * @param rivalElement the rivalElement to set
	 * @throws Exception 
	 */
	public void setRivalElement(String RivalElement, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set RivalElement ='" + RivalElement +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the inventoryUse
	 * @throws Exception 
	 */
	public boolean isInventoryUse(String ItemID) throws Exception
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select InventoryUse from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			InventoryUse = rs.getBoolean("InventoryUse");
			
		}
		db.closeConnection();
		return InventoryUse;
	}

	/**
	 * @param inventoryUse the inventoryUse to set
	 * @throws Exception 
	 */
	public void setInventoryUse(boolean InventoryUse, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set InventoryUse ='" + InventoryUse +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}
	
	public String getDescription(String ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Description from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			Description = rs.getString("Description");
			
		}
		db.closeConnection();
		return Description;
	}
	
	public void setDescription(String Description, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set Description ='" + Description +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}
	
	/**
	 * @return the isBoss
	 * @throws Exception 
	 */
	public boolean isIsBoss(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select IsBoss from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			IsBoss = rs.getBoolean("IsBoss");
			
		}
		db.closeConnection();
		return IsBoss;
	}

	/**
	 * @param isBoss the isBoss to set
	 * @throws Exception 
	 */
	public void setIsBoss(boolean IsBoss, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set IsBoss ='" + IsBoss +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the puzzleKeyword
	 * @throws Exception 
	 */
	public String getPuzzleKeyword(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select PuzzleKeyword from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			PuzzleKeyword = rs.getString("PuzzleKeyword");
			
		}
		db.closeConnection();
		return PuzzleKeyword;
	}

	/**
	 * @param puzzleKeyword the puzzleKeyword to set
	 * @throws Exception 
	 */
	public void setPuzzleKeyword(String PuzzleKeyword, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set PuzzleKeyword ='" + PuzzleKeyword +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the bonusHealth
	 * @throws Exception 
	 */
	public double getBonusHealth(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select BonusHealth from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			BonusHealth = rs.getDouble("BonusHealth");
			
		}
		db.closeConnection();
		return BonusHealth;
	}

	/**
	 * @param bonusHealth the bonusHealth to set
	 * @throws Exception 
	 */
	public void setBonusHealth(double BonusHealth, int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set BonusHealth ='" + BonusHealth +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	/**
	 * @return the possibility
	 * @throws Exception 
	 */
	public int getPossibility(int ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Possibility from Items where ItemID = '"+ ItemID +"'");
		while(rs.next())
		{
			Possibility = rs.getInt("Possibility");
			
		}
		db.closeConnection();
		return Possibility;
	}

	/**
	 * @param possibility the possibility to set
	 * @throws Exception 
	 */
	public void setPossibility(int Possibility, String ItemID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Item set Possibility ='" + Possibility +"'where ItemID = '"+ ItemID +"'");
		db.closeConnection();
	}

	
	

}
