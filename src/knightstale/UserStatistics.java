package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserStatistics
{
public String user_name ;
public int currentRoom ;
public int currentHealth ;
public String currentItem ;
public int previousRoomNumber;

public UserStatistics(){}


public UserStatistics(String _user_name) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM UserStatistics WHERE user_name = '"+ _user_name +"'");
	while(rs.next())
	{
		this.user_name = rs.getString("user_name");
		this.currentHealth = rs.getInt("CurrentHealth");
		this.currentRoom = rs.getInt("CurrentRoom");
		this.currentItem = rs.getString("CurrentItem");
		this.previousRoomNumber = rs.getInt("previousRoomNumber");
	}
	db.closeConnection();
}
@Override public String toString()
{
	String rtn = "";
	
	rtn += "  [Current Health] = "+ this.currentHealth;
	rtn += "  [Current Room] = " + this.currentRoom;
	rtn += "  [Current Item] = " + this.currentItem;
	rtn += "  [Prev Room] =  " + this.previousRoomNumber;
	
	return rtn;
}

public void CreateUserStatistics(String user_name, int currentRoom, int currentHealth, String currentItem, int previousRoomNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	try {
		db.executeStmt("insert into UserStatistics values(NULL,'" + user_name +"'," + currentRoom + "," + currentHealth + ","+ currentItem + "," + previousRoomNumber +")" ) ;				
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

