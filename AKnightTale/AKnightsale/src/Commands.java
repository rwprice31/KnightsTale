import java.util.ArrayList;
import java.util.Scanner;


public class Commands extends KnightsTale 
{
	public boolean checkCommandExists(String command)
	{
		ArrayList<String> commandList =  new ArrayList<String>();
		
		commandList.add("open");
		commandList.add("close");
		commandList.add("drop");
		commandList.add("use");
		commandList.add("attack");
		commandList.add("back step");
		commandList.add("throw");
		commandList.add("raise shield");
		commandList.add("move");
		commandList.add("inventory");
		commandList.add("cast");
		commandList.add("help");
		if(commandList.contains(command))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void commandCheck(String command, String userID) throws Exception
	{
		if (command.equalsIgnoreCase("open"))
		{
			System.out.println("Which would you like to open? ");
			Open();
		}
		else if(command.equalsIgnoreCase("close"))
		{
			System.out.println("Which  would you like to close? ");
			Close();
		}
		else if(command.equalsIgnoreCase("drop"))
		{
			System.out.println("Which item would you like to drop? ");
			Drop();
		}
		else if(command.equalsIgnoreCase("use"))
		{
			System.out.println("Which would you like to use? ");
			Use();
		}
		else if(command.equalsIgnoreCase("attack"))
		{
			System.out.println("Which monster would you like to attack? ");
			int monsterNumber =  userInput.nextInt();
			Attack();
		}
		else if(command.equalsIgnoreCase("back step"))
		{
			System.out.println("You have stepped backward!");
			BackStep();
		}
		else if(command.equalsIgnoreCase("throw"))
		{
			System.out.println("Which potion would you like to throw? ");
			Throw();
		}
		else if(command.equalsIgnoreCase("raise shield"))
		{
			System.out.println("You have raised your shield!");
			RaiseShield();
		}
		else if(command.equalsIgnoreCase("move"))
		{
			System.out.println("what room number would you like to move to?");
			int roomNumber =  userInput.nextInt();
			Move(userID, roomNumber);
		}
		else if(command.equalsIgnoreCase("inventory"))
		{
			System.out.println("You have the following items in your inventory:");
			Inventory();
		}
		else if(command.equalsIgnoreCase("cast"))
		{
			System.out.println("Which tome would you like to cast? ");
			String tomeName =  userInput.nextLine();
			
			//Change when getters and setters are done
			System.out.println("Which room would you like to cast it in? ");
			int roomNumber =  userInput.nextInt();
			Cast(tomeName, userID, roomNumber);
		}
		else if(command.equalsIgnoreCase("help"))
		{
			Help();
		}
	
	}
	
	public void Open()
	{
		
	}
	
	public void Close()
	{
		
	}
	
	public void Drop()
	{
		
	}
	public void Use()
	{
		
	}
	public void Attack()
	{
		
	}
	public void BackStep()
	{
		
	}
	public void Throw()
	{
		
	}
	public void RaiseShield()
	{
		
	}
	public void Inventory()
	{
		
	}
	public void Move(String userID, int roomNumber) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		db.executeStmt("update UserStatistics set CurrentRoom ='" + roomNumber +"'where user_name = '"+ userID +"'");
		db.closeConnection();		
	}
	public void Cast(String tomeName,String userID, int roomNumber )
	{
		
	}
	public void Help()
	{
		System.out.println("Hint: You can use the following commands");
		System.out.println("open, close ,drop, use, attack, back step, throw, raise shield, move, inventory, and cast");
	}

}
