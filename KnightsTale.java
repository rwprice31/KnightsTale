import java.sql.ResultSet;
import java.util.Scanner;



public class KnightsTale 
{

	private static String currentUser ;
	private static int currentRoom ;
	protected static Scanner userInput;
	protected boolean loggedIn = false;

	public static void main(String[] args) throws Exception 
	{

		UserStatistics userstats = new UserStatistics();
		GenerateRooms genRooms = new GenerateRooms();
		GetData data = new GetData();

		//Loop to login the user and set their user name to currentUser.
		boolean loggedIn = false;

		//Creates an instance of login
		Login login = new Login();


		//Creates an instance of login
		Commands commands = new Commands();

		//Loop to check login information. If new it will send user name and password to the Login class.
		//If continuing game it will check user name and password using the Login class and log user in.
		while (loggedIn == false)
		{
			userInput = new Scanner(System.in);
			System.out.println("Welcome to Knights Tale, Would you like to start a new or continue an old game(please type new or continue)");
			String answer = userInput.nextLine();
			if(answer.equalsIgnoreCase("continue"))
			{
				System.out.println("Welcome to Knights Tale, Please enter your username");
				String username = userInput.nextLine();
				System.out.println("Please enter your password");
				String userPassword = userInput.nextLine();

				//Checks to see if user name and password match.
				if(login.login(username, userPassword) == true)
				{
					setCurrentUser(username);
					loggedIn = true;
					System.out.println("Welcome to a Knights Tale!");
					System.out.println("Hint: You can use the following commands");
					System.out.println("open, close ,drop, use, attack, back step, throw, raise shield, move, inventory, and cast");
				}
				else
				{
					System.out.println("Incorrect Login Information");
				}
			}
			else if(answer.equalsIgnoreCase("new"))
			{
				System.out.println("Welcome to Knights Tale, Please enter your username");
				String username = userInput.nextLine();
				System.out.println("Please enter your password");
				String userPassword = userInput.nextLine();
				System.out.println("Your username is " + username + " , your password is " + userPassword + ".");
				userstats.createUserStatistics(username,userPassword);
				genRooms.createRooms(username);
				setCurrentUser(username);

				loggedIn = true;
				System.out.println("Welcome to a Knights Tale!");
				System.out.println("Hint: You can use the following commands");
				System.out.println("open, close ,drop, use, attack, back step, throw, raise shield, move, inventory, and cast");
			}

		}

		//Start of game loops once the user logs in.
		while(loggedIn == true)
		{

			Scanner userInput = new Scanner(System.in);
			while (userstats.getCurrentRoom(getCurrentUser()) <= 50)
			{


				System.out.println("You are currently in room " + userstats.getCurrentRoom(getCurrentUser()));

				String roomType = data.getRoomType(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));

				//Checks the room type to see what loop to start in.
				if(roomType.equalsIgnoreCase("fight"))
				{

					System.out.println("Fight");

					String command = userInput.nextLine();
					// Checks to see if the command is valid
					if (commands.checkCommandExists(command))
					{
						// Uses the command
						commands.commandCheck(command, getCurrentUser());
					}

					//When user types Exit it will exit game
					else if(command.equalsIgnoreCase("exit"))
					{
						loggedIn = false;
						System.out.println("Your game has been saved and you are logged out");

					}
					else 
					{
						System.out.println("That is not a valid command");
					}
					break;
				}

				else if(roomType.equalsIgnoreCase("boss"))
				{
					System.out.println("Boss Room");
					System.out.println("Init Fight Here");

					String command = userInput.nextLine();
					// Checks to see if the command is valid
					if (commands.checkCommandExists(command))
					{
						// Uses the command
						commands.commandCheck(command, getCurrentUser());
					}

					//When user types Exit it will exit game
					else if(command.equalsIgnoreCase("exit"))
					{
						loggedIn = false;
						System.out.println("Your game has been saved and you are logged out");

					}
					else 
					{
						System.out.println("That is not a valid command");
					}
					break;
				}
				
				//The chest room is the puzzle room. To open the chest you must solve the puzzle. Once the puzzle is solved you will be able
				//to add the items in the chest to your inventory.
				else if(roomType.equalsIgnoreCase("chest"))
				{
					
					String itemOne = data.getRoomPuzzleItemOne(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String itemTwo = data.getRoomPuzzleItemTwo(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String itemThree = data.getRoomPuzzleItemThree(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String itemOneQuantity = data.getRoomPuzzleItemOneQuantity(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String itemTwoQuantity = data.getRoomPuzzleItemTwoQuantity(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String itemThreeQuantity = data.getRoomPuzzleItemThreeQuantity(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String useableItemOne = data.getUseableItemOne(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					String useableItemTwo = data.getUseableItemTwo(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
				    String useableItemThree = data.getUseableItemThree(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()));
					System.out.println("When you enter the room you notice their are " + itemOneQuantity + " " + itemOne + ", "+ itemTwoQuantity + " " + itemTwo + ", "+ itemThreeQuantity + " " + itemThree + " around the room.");
					System.out.println("Sitting in the center of the room is a Large chest");
					System.out.println("The chest is locked…");
					System.out.println("You see an old combination lock with numbers ranging from 1 - 30, what could the combination be?");
					int count = 0;
					
					//Gets the users guess at the passcode if it is incorrect the while loop will take over until the correct answer
					//has been input.
					String command = userInput.nextLine();
					while (!command.equalsIgnoreCase(data.getRoomPuzzleSolution(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()))))
					{
						System.out.println("The lock didnt open.. maybe you entered the wrong number, try again....");
						count++;
						if (count % 3 == 0 )
						{
							System.out.println("The sum of some can be the sum of none");
						}
						else
						{
							
						}
						command = userInput.nextLine();
					}
					
					//Once the correct answer has been input the chest opens and you can add the items inside to you inventory. 
					//You are then moved to the next room.
					if(command.equalsIgnoreCase(data.getRoomPuzzleSolution(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser()))))
					{
					System.out.println("The lock sprung open and inside you see a few items: " + useableItemOne + ", " + useableItemTwo + ", and a " + useableItemThree + ".");
					commands.Move(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser())+1);
					}
//					//String command = userInput.nextLine();
//					// Checks to see if the command is valid
//					if (commands.checkCommandExists(command))
//					{
//						// Uses the command
//						commands.commandCheck(command, getCurrentUser());
//					}
//
//					//When user types Exit it will exit game
//					else if(command.equalsIgnoreCase("exit"))
//					{
//						loggedIn = false;
//						System.out.println("Your game has been saved and you are logged out");
//
//					}
//					else 
//					{
//						System.out.println("That is not a valid command");
//					}
					break;
				}
				else
				{
					System.out.println("You walked up the stair case to the next floor of the castle");
					commands.Move(getCurrentUser(), userstats.getCurrentRoom(getCurrentUser())+1);
					break;
				}
				// Exits loop to make sure loggedIn = true
			//	break;
			}

			// Ends game if level 50 has been completed
			if (userstats.getCurrentRoom(getCurrentUser()) > 50)
			{
				System.out.println("Congrats! you have finished the game, their is nothing more to do!");
				loggedIn = false;
				break;
			}
		}
	}



	/**
	 * @return the currentUser
	 */
	public static String getCurrentUser()
	{
		return currentUser;
	}

	/**
	 * @param currentUser the currentUser to set
	 */
	public static void setCurrentUser(String currUser)
	{
		currentUser = currUser;
	}


}
