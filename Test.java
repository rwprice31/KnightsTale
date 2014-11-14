import java.sql.ResultSet;



public class Test 
{
	public static void main(String[] args) throws Exception
	{
		//Replace the second string with your database path
		Db db = new Db("org.sqlite.JDBC", "jdbc:sqlite:C:/SQL/game.db");
		db.getConnection();
		ResultSet rs = db.executeQry("select user_password from login where user_name = '" + "joe" +"'");
		while(rs.next())
		{
			System.out.println(rs.getString("user_password"));
		}
		db.closeConnection();
	}

}
