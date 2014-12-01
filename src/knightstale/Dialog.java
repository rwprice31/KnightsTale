package knightstale;
import java.sql.ResultSet;

public class Dialog {

	
public static String[] GetRoomDialog(String user_name, int RoomNumber) throws Exception
{	
	Room room = new Room(user_name, RoomNumber);
	Monster monster = new Monster(user_name, RoomNumber);
	
	
	// get dialog from database
	String[] rtn = new String[5];	
	int x = 0;
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Dialog WHERE RoomType = '" + room.RoomType +"' ORDER BY SequenceNumber asc");
	while(rs.next())
	{
		rtn[x] = rs.getString("Dialog");
		x++;
	}
	db.closeConnection();
	
	
	String [] _rtn = new String[x];
	
	for(int z = 0;z<x;z++)
	{
		_rtn[z] = rtn[z];
		_rtn[z] = _rtn[z].replace("[ROOM]", Integer.toString(room.RoomNumber));
		_rtn[z] = _rtn[z].replace("[ELEMENT]", room.RoomType);
		_rtn[z] = _rtn[z].replace("[ITEM1]", room.Item1);
		_rtn[z] = _rtn[z].replace("[ITEM2]", room.Item2);
		_rtn[z] = _rtn[z].replace("[ITEM3]", room.Item3);
		_rtn[z] = _rtn[z].replace("[MONSTER]", monster.Name);
	}

	return _rtn;
}


}
