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

public Monster(String user_name, int RoomNumber) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Characters WHERE user_name = '"+ user_name + "' AND RoomNumber = " + RoomNumber  );
	while(rs.next())
	{
		this.CharacterID = rs.getInt("CharacterID");
		this.user_name = rs.getString("user_name");
		this.RoomNumber = rs.getInt("RoomNumber");		
		this.Name = rs.getString("Name");
		this.ElementType = rs.getString("ElementType");
		this.Health = rs.getInt("Health");
		this.isBoss = rs.getInt("isBoss");
		this.ItemName = rs.getString("ItemName");
	}
	db.closeConnection();
}

public Monster(String MonsterName) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("SELECT * FROM Characters WHERE name = '" + MonsterName +"'");
	while(rs.next())
	{
		this.CharacterID = rs.getInt("CharacterID");
		this.user_name = rs.getString("user_name");
		this.RoomNumber = rs.getInt("RoomNumber");		
		this.Name = rs.getString("Name");
		this.ElementType = rs.getString("ElementType");
		this.Health = rs.getInt("Health");
		this.isBoss = rs.getInt("isBoss");
		this.ItemName = rs.getString("ItemName");
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
