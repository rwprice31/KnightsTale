package knightstale;
import java.sql.ResultSet;


public class Monster {
public int CharacterID;
public String CharacterType = "Monster";
public String Name;
public String ElementType;
public int InitialHealth;
public boolean isBoss;
	
public Monster(){}

public Monster(int CharacterID) throws Exception
{
	Db db = new Db();
	db.getConnection();
	ResultSet rs = db.executeQry("select CharacterID,CharacterType,Name,ElementType,InitialHealth,isBoss from Characters where UserID = '"+ CharacterID +"'");
	while(rs.next())
	{
		CharacterID = rs.getInt("CharactrID");
		CharacterType = rs.getString("CharacterType");
		Name = rs.getString("Name");
		ElementType = rs.getString("ElementType");
		InitialHealth = rs.getInt("InitialHealth");
		isBoss = rs.getBoolean("isBoss");
	}
	db.closeConnection();
}

}
