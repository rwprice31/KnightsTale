import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author JosephROG
 *
 */
public class UserStatistics
{
int gameNumber ;
String userID ;
int currentRoom ;
int currentHealth ;
int currentItem ;
int previousRoomNumber;

public UserStatistics()
{
	
}
/**
 * @param gameNumber
 * @param userID
 * @param currentRoom
 * @param currentHealth
 * @param currentItem
 * @param previousRoomNumber
 * @author JosephROG
 */
public UserStatistics(int gameNumber, String userID, int currentRoom,
		int currentHealth, int currentItem, int previousRoomNumber)
{
	super();
	this.gameNumber = gameNumber;
	this.userID = userID;
	this.currentRoom = currentRoom;
	this.currentHealth = currentHealth;
	this.currentItem = currentItem;
	this.previousRoomNumber = previousRoomNumber;
}
/**
 * @return the userID
 * @author JosephROG
 */
public String getUserID()
{
	return userID;
}
/**
 * @param userID the userID to set
 * @author JosephROG
 */
public void setUserID(String userID)
{
	this.userID = userID;
}
/**
 * @return the currentRoom
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentRoom(String userID) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentRoom from UserStatistics where UserID = '"+ userID +"'");
	while(rs.next())
	{
		currentRoom = rs.getInt("CurrentRoom");
	}
	db.closeConnection();
	return currentRoom;
}
/**
 * @param currentRoom the currentRoom to set
 * @throws Exception 
 * @author JosephROG
 */
public void setCurrentRoom(int currentRoom, String userID) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentRoom ='" + currentRoom +"'where UserID = '"+ userID +"'");
	db.closeConnection();
}
/**
 * @return the currentHealth
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentHealth(String userID) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentHealth from UserStatistics where UserID = '"+ userID +"'");
	while(rs.next())
	{
		currentHealth = rs.getInt("CurrentHealth");
	}
	db.closeConnection();

	return currentHealth;
}
/**
 * @param currentHealth the currentHealth to set
 * @throws Exception 
 * @author JosephROG
 */
public void setCurrentHealth(int currentHealth, String userID) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentHealth ='" + currentHealth +"'where UserID = '"+ userID +"'");
	db.closeConnection();
}
/**
 * @return the currentItem
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentItem(String userID) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentItem from UserStatistics where UserID = '"+ userID +"'");
	while(rs.next())
	{
		currentItem = rs.getInt("CurrentItem");
	}
	db.closeConnection();

	return currentItem;
}
/**
 * @param currentItem the currentItem to set
 * @throws Exception 
 * @author JosephROG
 */
public void setCurrentItem(int currentItem, String userID) throws Exception
{
	Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/AKnightTale.db");
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentItem ='" + currentItem +"'where UserID = '"+ userID +"'");
	db.closeConnection();
}
/**
 * @return the previousRoomNumber
 * @author JosephROG
 * I am not sure we really need this but included since in DB
 */
public int getPreviousRoomNumber(String userID)
{

	return previousRoomNumber;
}
/**
 * @param previousRoomNumber the previousRoomNumber to set
 * @author JosephROG
 * I am not sure we really need this but included since in DB
 */
public void setPreviousRoomNumber(int previousRoomNumber, String userID)
{
	this.previousRoomNumber = previousRoomNumber;
}
}
