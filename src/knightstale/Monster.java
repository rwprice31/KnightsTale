package knightstale;
import java.sql.ResultSet;


public class Monster {
public int CharacterID;
public String user_name;
public int RoomNumber;
public String Name;
public String ElementType;
public int Health;
public boolean isBoss;
public String ItemName;
	
public Monster(){}

public Monster(int CharacterID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select CharacterID,CharacterType,Name,ElementType,InitialHealth,isBoss from Characters where UserID = '"+ CharacterID +"'");
	while(rs.next())
	{
		CharacterID = rs.getInt("CharactrID");
		user_name = rs.getString("user_name");
		RoomNumber = rs.getInt("RoomNumber");		
		Name = rs.getString("Name");
		ElementType = rs.getString("ElementType");
		Health = rs.getInt("Health");
		isBoss = rs.getBoolean("isBoss");
		ItemName = rs.getString("ItemName");
	}
	db.closeConnection();
}

}
