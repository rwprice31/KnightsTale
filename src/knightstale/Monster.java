package knightstale;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Monster {
public int CharacterID;
public String user_name;
public int RoomNumber;
public String Name;
public String ElementType;
public int Health;
public int isBoss;
public String ItemName;
	
public Monster(){}

public Monster(int CharacterID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT CharacterID,CharacterType,Name,ElementType,InitialHealth,isBoss FROM Characters WHERE CharacterID = "+ CharacterID );
	while(rs.next())
	{
		CharacterID = rs.getInt("CharacterID");
		user_name = rs.getString("user_name");
		RoomNumber = rs.getInt("RoomNumber");		
		Name = rs.getString("Name");
		ElementType = rs.getString("ElementType");
		Health = rs.getInt("Health");
		isBoss = rs.getInt("isBoss");
		ItemName = rs.getString("ItemName");
	}
	db.closeConnection();
}

public Monster(String MonsterName) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT CharacterID,user_name,RoomNumber,Name,ElementType,Health,isBoss,ItemName FROM Characters WHERE name = '" + MonsterName +"'");
	while(rs.next())
	{
		CharacterID = rs.getInt("CharacterID");
		user_name = rs.getString("user_name");
		RoomNumber = rs.getInt("RoomNumber");		
		Name = rs.getString("Name");
		ElementType = rs.getString("ElementType");
		Health = rs.getInt("Health");
		isBoss = rs.getInt("isBoss");
		ItemName = rs.getString("ItemName");
	}
	db.closeConnection();
}

public void CreateMonster() throws Exception
{
	Db db = new Db();
	db.getConnection();
	try {
		String statement = "INSERT INTO Characters VALUES(NULL,'" + user_name + "'," + RoomNumber + ",'" + Name + "','" + ElementType + "'," + Health + "," + isBoss + ",'" + ItemName + "')";
		db.executeStmt(statement) ;				
	} catch (SQLException e) {	
	}
	db.closeConnection();
}


}
