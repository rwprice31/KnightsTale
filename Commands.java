import java.sql.ResultSet;


public class Commands 
{
	private int CommandID;
	private String Command;
	private String Description;
	/**
	 * @return the commandID
	 * @throws Exception 
	 */
	public int getCommandID() throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select CommandID from Commands where CommandID = '"+ CommandID +"'");
		while(rs.next())
		{
			CommandID = rs.getInt("CommandID");
		}
		db.closeConnection();
		return CommandID;
	}
	/**
	 * @param commandID the commandID to set
	 * @throws Exception 
	 */
	public void setCommandID(int CommandID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Commands set CommandID ='" + CommandID +"'");
		db.closeConnection();
	}
	/**
	 * @return the command
	 * @throws Exception 
	 */
	public String getCommand(int CommandID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Command from Commands where CommandID = '"+ CommandID +"'");
		while(rs.next())
		{
			Command = rs.getString("Command");
		}
		db.closeConnection();
		return Command;
	}
	/**
	 * @param command the command to set
	 * @throws Exception 
	 */
	public void setCommand(String Command, int CommandID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Commands set Command ='" + Command +"'where CommandID = '"+ CommandID +"'");
		db.closeConnection();
	}
	/**
	 * @return the description
	 * @throws Exception 
	 */
	public String getDescription(int CommandID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select Description from Commands where ComamndID = '"+ CommandID +"'");
		while(rs.next())
		{
			Description = rs.getString("Description");
		}
		db.closeConnection();
		return Description;
	}
	/**
	 * @param description the description to set
	 * @throws Exception 
	 */
	public void setDescription(String Description, int CommandID) throws Exception 
	{
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
		db.getConnection();
		db.executeStmt("update Commands set Description ='" + Description +"'where CommandID = '"+ CommandID +"'");
		db.closeConnection();
	}

}
