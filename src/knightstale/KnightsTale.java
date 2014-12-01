package knightstale;


public class KnightsTale 
{
	
	public static void main(String[] args) throws Exception 
	{		
		String user_name = "dave"; 
		Initialize.CreateRooms(user_name);
		// can also be used as
		// Initialize.CreateRooms(UserStatistics.user_name);
		
		// get and print dialog for entering the room.
		String[] temp = Dialog.GetRoomDialog("dave",  1);	
		for(int y=0;y<temp.length;y++)
		{
			System.out.println(temp[y]);
		}
	}
		
}
