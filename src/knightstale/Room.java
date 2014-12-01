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

public Room(String _user_name, int _RoomNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Rooms WHERE RoomNumber = '"+ _RoomNumber +"' AND user_name = '" + _user_name +"'");
	while(rs.next())
	{
		this.RoomID = rs.getInt("RoomID");
		this.user_name = rs.getString("user_name");
		this.RoomNumber = rs.getInt("RoomNumber");
		this.RoomType = rs.getString("RoomType");
		this.Item1 = rs.getString("Item1");
		this.Item2 = rs.getString("Item2");
		this.Item3 = rs.getString("Item3");		
		this.PuzzlePassword = rs.getString("PuzzlePassword");
		this.isVisited = rs.getInt("Visited");
	}
	db.closeConnection();
}

@Override public String toString()
{
	String rtn = "";
	String[] temp;
	
	try {
		temp = Dialog.GetRoomDialog("dave",  1);
		for(int y=0;y<temp.length;y++)
		{
			rtn += temp[y] + "\n ";
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	

	
	return rtn;
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
