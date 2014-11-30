package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Room {
public int RoomID;
public String user_name;
public int RoomNumber;
public String RoomType;
public String Item1;
public String Item2;
public String Item3;
public String PuzzlePassword;
	
public Room(){}

public Room(int RoomID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Rooms WHERE RoomrID = '"+ RoomID +"'");
	while(rs.next())
	{
		RoomID = rs.getInt("RoomID");
		RoomNumber = rs.getInt("RoomNumber");
		RoomType = rs.getString("RoomType");
		Item1 = rs.getString("Item1ID");
		Item2 = rs.getString("Item2ID");
		Item3 = rs.getString("Item3ID");		
		PuzzlePassword = rs.getString("PuzzlePassword");
	}
	db.closeConnection();
}


public void CreateRoom() throws Exception
{
	Db db = new Db();
	db.getConnection();
	try {
		String statement = "INSERT INTO Rooms VALUES(NULL,'" + user_name + "'," + RoomNumber + ",'" + RoomType + "','" + Item1 + "','" + Item2 + "','" + Item3 + "','"  + PuzzlePassword + "', 0)";
		db.executeStmt(statement) ;				
	} catch (SQLException e) {	
	}
	db.closeConnection();	
}

}
