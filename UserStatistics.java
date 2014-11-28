import java.sql.ResultSet;


/**
 * @author JosephROG
 *
 */
public class UserStatistics
{
String UserName ;
int CurrentRoom ;
int CurrentHealth ;
int CurrentItem ;
int PreviousRoomNumber;

public UserStatistics (String UserName, int CurrentRoom,
		int CurrentHealth, int CurrentItem, int PreviousRoomNumber)
{
	super();
	this.UserName = UserName;
	this.CurrentRoom = CurrentRoom;
	this.CurrentHealth = CurrentHealth;
	this.CurrentItem = CurrentItem;
	this.PreviousRoomNumber = PreviousRoomNumber;
}
/**
 * @return the UserName
 * @author JosephROG
 */
public String getUserID()
{
	return UserName;
}
/**
 * @param UserName the UserName to set
 * @author JosephROG
 */
public void setUserID(String UserName)
{
	this.UserName = UserName;
}
/**
 * @return the currentRoom
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentRoom(String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentRoom from UserStatistics where UserID = '"+ UserName +"'");
	while(rs.next())
	{
		CurrentRoom = rs.getInt("CurrentRoom");
	}
	db.closeConnection();
	return CurrentRoom;
}
/**
 * @param currentRoom the currentRoom to set
 * @throws Exception 
 * @author JosephROG
 */
public void setCurrentRoom(int CurrentRoom, String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentRoom ='" + CurrentRoom +"'where UserName = '"+ UserName +"'");
	db.closeConnection();
}
/**
 * @return the currentHealth
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentHealth(String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentHealth from UserStatistics where UserID = '"+ UserName +"'");
	while(rs.next())
	{
		CurrentHealth = rs.getInt("CurrentHealth");
	}
	db.closeConnection();

	return CurrentHealth;
}
/**
 * @param currentHealth the currentHealth to set
 * @throws Exception 
 * @author JosephROG
 */
public void setCurrentHealth(int CurrentHealth, String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentHealth ='" + CurrentHealth +"'where UserID = '"+ UserName +"'");
	db.closeConnection();
}
/**
 * @return the currentItem
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentItem(String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/Desktop/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentItem from UserStatistics where UserID = '"+ UserName +"'");
	while(rs.next())
	{
		CurrentItem = rs.getInt("CurrentItem");
	}
	db.closeConnection();
	return CurrentItem;
}
/**
 * @param currentItem the currentItem to set
 * @throws Exception 
 * @author JosephROG
 */
public void setCurrentItem(int currentItem, String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentItem ='" + currentItem +"'where UserName = '"+ UserName +"'");
	db.closeConnection();
}
/**
 * @return the previousRoomNumber
 * @author JosephROG
 * I am not sure we really need this but included since in DB
 * @throws Exception 
 */
public int getPreviousRoomNumber(String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/Desktop/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select PreviousRoomNumber from UserStatistics where UserName = '"+ UserName +"'");
	while(rs.next())
	{
		CurrentItem = rs.getInt("CurrentItem");
	}
	db.closeConnection();
	return PreviousRoomNumber;
}
/**
 * @param previousRoomNumber the previousRoomNumber to set
 * @author JosephROG
 * I am not sure we really need this but included since in DB
 * @throws Exception 
 */
public void setPreviousRoomNumber(int PreviousRoomNumber, String UserName) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set PreviousRoomNumber ='" + PreviousRoomNumber +"'where UserName = '"+ UserName +"'");
	db.closeConnection();
}
}