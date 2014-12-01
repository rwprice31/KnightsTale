package knightstale;

import java.sql.ResultSet;

public class CmdLogic {
	
	public String[] Commands;
	
	public CmdLogic() throws Exception{
		int x = 0,z=0;
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("SELECT Command FROM Commands");
		while(rs.next()){ x++;}			
		
		Commands = new String[x];
		
		ResultSet rs2 = db.executeQry("SELECT Command FROM Commands");
		while(rs2.next()){
			Commands[z] = rs2.getString("Command");	
			z++;
		}
		
		db.closeConnection();
	}
	
	public boolean ValidCommand(String Command) throws Exception
	{
		boolean rtn = false;
		for(int x=0; x<Commands.length;x++)
		{
			
			if(Commands[x].trim().toUpperCase().equals(Command.trim().toUpperCase()))
			{
				rtn = true;
			}
		}
		return rtn;
	}

}
