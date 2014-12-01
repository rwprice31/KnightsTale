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
 * @return 
 * @throws Exception 
 */
public void createUserStatistics(String userID, String password) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("insert into UserStatistics (user_name,CurrentRoom,CurrentHealth, CurrentItem)"
			+ "VALUES ('" + userID + "',1,100,'Bronze Sword')");
	db.executeStmt("insert into Login (user_name,user_password)"
			+ "VALUES ('" + userID + "','" + password + "')");
	db.closeConnection();
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
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentRoom from UserStatistics where user_name = '"+ userID +"'");
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
	Db db = new Db();
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentRoom ='" + currentRoom +"'where user_name = '"+ userID +"'");
	db.closeConnection();
}
/**
 * @return the currentHealth
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentHealth(String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentHealth from UserStatistics where user_name = '"+ userID +"'");
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
	Db db = new Db();
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentHealth ='" + currentHealth +"'where user_name = '"+ userID +"'");
	db.closeConnection();
}
/**
 * @return the currentItem
 * @throws Exception 
 * @author JosephROG
 */
public int getCurrentItem(String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select CurrentItem from UserStatistics where user_name = '"+ userID +"'");
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
	Db db = new Db();
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentItem ='" + currentItem +"'where user_name = '"+ userID +"'");
	db.closeConnection();
}
/**l
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
