package knightstale;
import java.util.Scanner;

public class KnightsTale 
{
	private static UserStatistics userstats = new UserStatistics();
	private static String CurrentCommand = "";
	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception 
	{		
		// Print Instructions
		System.out.println("Welcome to Knights Tale the game. \nPress (help) at any time to list your command options");
		//-----------------------------
		
		// Menu sequence.  get command from user
		while(CurrentCommand.equals("QUIT") == false)
		{
			CurrentCommand = GetCommand();
			
			switch(CurrentCommand.toUpperCase())
			{
				case "LOAD":					
					String user = "";				
					while(user.equals(""))
					{
						System.out.println("Enter a UserName to load -->");
						user = userInput.nextLine();	
					}
					userstats = new UserStatistics(user);
					PrintMessage("Game loaded successfully");
					break;
				case "NEW":
					if(!(userstats.user_name.equals(""))){
						String requests = "";				
						while(!(requests.equals("Y")) & !(requests.equals("N")) )
						{
							System.out.println("Are you sure you want to start a NEW GAME without saving? (Y/N) -->");
							requests = userInput.nextLine().toUpperCase();
						}
						if (requests.equals("Y"))
						{
							String newuser1 = "";				
							while(newuser1.equals(""))
							{
								System.out.println("Enter desired UserName -->");
								newuser1 = userInput.nextLine();	
							}
							// create a new entry in the user statistics table
							new UserStatistics().CreateUserStatistics(newuser1, 1, 10, "Bronze Sword", 0);
							// Create all rooms and monsters for the game
							Initialize.CreateRooms(newuser1);
							userstats = new UserStatistics(newuser1);	
							PrintMessage("New Game created sucessfully");	
						}
					}
					else
					{
						String newuser = "";				
						while(newuser.equals(""))
						{
							System.out.println("Enter desired UserName -->");
							newuser = userInput.nextLine();	
						}
						// create a new entry in the user statistics table
						new UserStatistics().CreateUserStatistics(newuser, 1, 10, "Bronze Sword", 0);
						// Create all rooms and monsters for the game
						Initialize.CreateRooms(newuser);
						userstats = new UserStatistics(newuser);	
						PrintMessage("New Game created sucessfully");
					}
					break;	
				case "STATUS":
					if(userstats.user_name == null)
					{ PrintMessage("No game has been initiatd");} 
					else
					{
						// print userstats
						PrintMessage(userstats.toString());
						// print room stats
						PrintMessage(new Room(userstats.user_name, userstats.currentRoom).toString());
					}
					break;
					
				case "EXIT":
					//ask to save game
					String request = "";				
					while(!(request.equals("Y")) & !(request.equals("N")) )
					{
						System.out.println("Are you sure you want to quit without saving? (Y/N) -->");
						request = userInput.nextLine().toUpperCase();
					}
					if (request.equals("Y")){CurrentCommand = "QUIT";}
					break;
				case "SAVE":
					break;
					
				case "MOVE":
					//next room;
					break;
				case "ATTACK":
					// start attacking sequence
					//shields.. etc
					break;
				case "FLEE":
					break;
				case "INVENTORY":
					PrintMessage( new Inventory(userstats.user_name).toString() );
					break;
				case "PICK":
					break;
				case "DROP":
					break;
				case "USE":
					break;
					
			
			}
			
			
		}
		
		PrintMessage("Thank you for playing Knights Tale the game.");		
	}
		
	
	
	// get next command
	private static String GetCommand() throws Exception
	{		
		boolean isValid = false;
		String response = "";
		
		while(!isValid)	{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter a command -->");
			response = userInput.nextLine();			
			
			isValid = new CmdLogic().ValidCommand(response);
		}
		
		return response.toUpperCase();
	}
	
	// print method use to show messages (overwritten)
	private static void PrintMessage(String _message){
		PrintMessage(_message, true);
	}
	
	// print method use to show messages on the screen
	private static void PrintMessage(String _message, boolean success)
	{
		if(success){
			System.out.println(_message);
		}
		else		{
			System.out.println("<<ERROR>> " + _message);
		}
	}
	
	
	
}
