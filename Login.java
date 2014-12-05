import java.sql.ResultSet;


public class Login
{
	//Method to check login and make sure the username and password match.
	public static boolean login(String userName, String enteredPassword) throws Exception
	{
		String userPassword = null;
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("select user_password from login where user_name = '" + userName +"'");
		while(rs.next())
		{
			userPassword = rs.getString("user_password");
		}
		db.closeConnection();
		if (enteredPassword.equals(userPassword))
		{
			return true;
		}
		//Returns False if Password is Wrong
		else
		{
			return false;
		}

	}
}
