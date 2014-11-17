package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatistics
{
int gameNumber ;
String userID ;
int currentRoom ;
int currentHealth ;
int currentItem ;
int previousRoomNumber;

public UserStatistics(){}

public UserStatistics(int gameNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select gameNumber, userID, currentRoom, currentHealth,currentItem,previousRoomNumber from UserStatistics where gameNumber = '"+ gameNumber +"'");
	while(rs.next())
	{
		gameNumber = rs.getInt("gameNumber");
		userID = rs.getString("userID");
		currentRoom = rs.getInt("CurrentRoom");
		currentItem = rs.getInt("CurrentItem");
		previousRoomNumber = rs.getInt("previousRoomNumber");
	}
	db.closeConnection();
}

public UserStatistics(String userid) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select gameNumber, userID, currentRoom, currentHealth,currentItem,previousRoomNumber from UserStatistics where UserID = '"+ userid +"'");
	while(rs.next())
	{
		gameNumber = rs.getInt("gameNumber");
		userID = rs.getString("userID");
		currentRoom = rs.getInt("CurrentRoom");
		currentItem = rs.getInt("CurrentItem");
		previousRoomNumber = rs.getInt("previousRoomNumber");
	}
	db.closeConnection();
}

public void CreateUserStatistics(String userID, int currentRoom, int currentHealth, int currentItem, int previousRoomNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	try {
		db.executeStmt("insert into UserStatistics values('" + userID +"','" + currentRoom + "','" + currentHealth + "','"+ currentItem + "','" + previousRoomNumber +"')" ) ;				
	} catch (SQLException e) {	
	}
	db.closeConnection();	
}

public void setCurrentRoom(int currentRoom, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentRoom ='" + currentRoom +"'where UserID = '"+ userID +"'");
	db.closeConnection();
}

public void setCurrentHealth(int currentHealth, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentHealth ='" + currentHealth +"'where UserID = '"+ userID +"'");
	db.closeConnection();
}

public void setCurrentItem(int currentItem, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("update UserStatistics set CurrentItem ='" + currentItem +"'where UserID = '"+ userID +"'");
	db.closeConnection();
}

public void setPreviousRoomNumber(int previousRoomNumber, String userID)
{
	this.previousRoomNumber = previousRoomNumber;
}


}

