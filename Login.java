/**Class: Login.Java
 * @author Joseph Cox
 * @version 1.0 
 * Written: November 7 2014
 * 
 * This class – Connects to the database, matches the user name and password to the ones entered. It returns true if they match
 * false if they do not.
 *  
 * Purpose –  Matches user name and password
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login
{

	static boolean UserAuthentication(String userName, String enteredPassword) throws ClassNotFoundException
	{
		String userPassword = null;
		
		// load the sqlite-JDBC driver using the current class loader
				Class.forName("org.sqlite.JDBC");
				
				String path = "C:/Users/Joseph/Documents/SQL/game.db";
				Connection connection = null;
				try
				{
					// create a database connection
					connection = DriverManager.getConnection("jdbc:sqlite:" + path);
					Statement statement = connection.createStatement();
					statement.setQueryTimeout(30);  // set timeout to 30 sec.
					
					//Get Password For A User From DataBase
					ResultSet rs = statement.executeQuery("select user_password from login where user_name = '" + userName +"'");
					while(rs.next())
					{
						userPassword = rs.getString("user_password");
					}
				}
				catch(SQLException e)
				{
					// if the error message is "out of memory", 
					// it probably means no database file is found
					System.err.println(e.getMessage());
				}
				finally
				{
					try
					{
						if(connection != null)
							connection.close();
					}
					catch(SQLException e)
					{
						// connection close failed.
						System.err.println(e);
					}

				}

		//Returns True if Password Matches	
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
