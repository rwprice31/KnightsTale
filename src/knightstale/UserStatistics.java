package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatistics
{
public int gameNumber ;
public String userID ;
public int currentRoom ;
public int currentHealth ;
public String currentItem ;
public int previousRoomNumber;

public UserStatistics(){}


public UserStatistics(String userid) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select gameNumber, userID, currentRoom, currentHealth,currentItem,previousRoomNumber,MapID from UserStatistics where UserID = '"+ userid +"'");
	while(rs.next())
	{
		gameNumber = rs.getInt("gameNumber");
		userID = rs.getString("userID");
		currentHealth = rs.getInt("CurrentHealth");
		currentRoom = rs.getInt("CurrentRoom");
		currentItem = rs.getString("CurrentItem");
		previousRoomNumber = rs.getInt("previousRoomNumber");
	}
	db.closeConnection();
}

public void CreateUserStatistics(String userID, int currentRoom, int currentHealth, String currentItem, int previousRoomNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	try {
		db.executeStmt("insert into UserStatistics values(NULL,'" + userID +"'," + currentRoom + "," + currentHealth + ","+ currentItem + "," + previousRoomNumber +")" ) ;				
	} catch (SQLException e) {	
	}
	db.closeConnection();	
}

public void setCurrentRoom(int currentRoom, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("UPDATE UserStatistics SET CurrentRoom =" + currentRoom + " WHERE UserID = '"+ userID +"'");
	db.closeConnection();
}

public void setCurrentHealth(int currentHealth, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("UPDATE UserStatistics SET CurrentHealth =" + currentHealth +" WHERE UserID = '"+ userID +"'");
	db.closeConnection();
}

public void setCurrentItem(int currentItem, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("UPDATE UserStatistics SET CurrentItem ='" + currentItem +"' WHERE UserID = '"+ userID +"'");
	db.closeConnection();
}

public void setPreviousRoomNumber(int previousRoomNumber, String userID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	db.executeStmt("UPDATE UserStatistics SET PreviousRoom ='" + previousRoomNumber +"' WHERE UserID = '"+ userID +"'");
	db.closeConnection();
}


}

