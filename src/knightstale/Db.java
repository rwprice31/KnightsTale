package knightstale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
/** Database connection class & utilities **/
 
public class Db {
	
    private  String sDriver = ""; 
    private  String sUrl = null;
    private  int iTimeout = 30;
    private  Connection conn = null;
    private  Statement statement = null;

 
    //This will connect to the database 
    public Db() throws Exception
    {
        init("org.sqlite.JDBC", "jdbc:sqlite:C:/Users/david/Documents/Java/KnightsTale/AKnightTale.db");
    }
 
    public void init(String sDriverVar, String sUrlVar) throws Exception
    {
        setDriver(sDriverVar);
        setUrl(sUrlVar);
        setConnection();
        setStatement();
    }
 
    //This will set the driver passed in from constructor to variable sDriver
    private void setDriver(String sDriverVar)
    {
        sDriver = sDriverVar;
    }
 
    //This will set the url passed in from constructor to variable sUrl
    private void setUrl(String sUrlVar)
    {
        sUrl = sUrlVar;
    }
 
    public  void setConnection() throws Exception {
        Class.forName(sDriver);
        conn = DriverManager.getConnection(sUrl);
    }
 
    //Gets the connection to use in the class
    public  Connection getConnection() {
        return conn;
    }
 
    //Sets the timeout for the query and checks connection
    public  void setStatement() throws Exception {
        if (conn == null) {
            setConnection();
        }
        statement = conn.createStatement();
        statement.setQueryTimeout(iTimeout);  // set timeout to 30 sec.
    }
 
    public  Statement getStatement() {
        return statement;
    }
 
    //Executes the given statement. Use this for adds,deletes,and creates
    //when no additional information will be needed in return.
    public  void executeStmt(String instruction) throws SQLException {
        statement.executeUpdate(instruction);        
    }
 
    // processes an array of instructions e.g. a set of SQL command strings passed from a file
    //NB you should ensure you either handle empty lines in files by either removing them or parsing them out 
    // since they will generate spurious SQLExceptions when they are encountered during the iteration....
    public void executeStmt(String[] instructionSet) throws SQLException {
        for (int i = 0; i < instructionSet.length; i++) {
            executeStmt(instructionSet[i]);
        }
    }
 
    //Returns a result set that contains the information queried.
    public ResultSet executeQry(String instruction) throws SQLException {
        return statement.executeQuery(instruction);
    } 
 
    //CLoses the connection to the database
    public void closeConnection() {
        try { conn.close(); } catch (Exception ignore) {}
    }
 
}