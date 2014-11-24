package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Room {
public int RoomID;
public int MapID;
public int RoomNumber;
public String RoomType;
public int Item1;
public int Item2;
public int Item3;
public int Character1;
public int Character2;
public int Character3;
public int PuzzleID;
	
public Room(){}

public Room(int RoomID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Rooms WHERE RoomrID = '"+ RoomID +"'");
	while(rs.next())
	{
		RoomID = rs.getInt("RoomID");
		MapID = rs.getInt("MapID");
		RoomNumber = rs.getInt("RoomNumber");
		RoomType = rs.getString("RoomType");
		Item1 = rs.getInt("Item1ID");
		Item2 = rs.getInt("Item2ID");
		Item3 = rs.getInt("Item3ID");
		Character1 = rs.getInt("Character1ID");
		Character2 = rs.getInt("Character2ID");
		Character3 = rs.getInt("Character3ID");
		PuzzleID = rs.getInt("PuzzleID");
	}
	db.closeConnection();
}


public void CreateRoom() throws Exception
{
	Db db = new Db();
	db.getConnection();
	try {
		db.executeStmt("INSERT INTO Rooms VALUES(NULL," + MapID +"," + RoomNumber + ",'" + RoomType + "'," + Item1 + "," + Item2 + "," + Item3 + "," + Character1 + "," + Character2 + "," + Character3 + "," + PuzzleID +")" ) ;				
	} catch (SQLException e) {	
	}
	db.closeConnection();	
}

}
