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
public int isVisited;
	
public Room(){}

public Room(String user_name, int RoomNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Rooms WHERE RoomNumber = '"+ RoomNumber +"' AND user_name = '" + user_name +"'");
	while(rs.next())
	{
		RoomID = rs.getInt("RoomID");
		this.user_name = rs.getString("user_name");
		this.RoomNumber = rs.getInt("RoomNumber");
		RoomType = rs.getString("RoomType");
		Item1 = rs.getString("Item1");
		Item2 = rs.getString("Item2");
		Item3 = rs.getString("Item3");		
		PuzzlePassword = rs.getString("PuzzlePassword");
		isVisited = rs.getInt("Visited");
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
