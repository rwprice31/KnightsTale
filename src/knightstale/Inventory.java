package knightstale;
import java.sql.ResultSet;
import java.util.List;
import java.util.Stack;

public class Inventory {
	public int InventoryID;
	public String user_name;
	@SuppressWarnings("rawtypes")
	public List<Item> Items = new Stack<Item>();

		
	public Inventory(){}

	public Inventory(String _user_name) throws Exception
	{
		Db db = new Db();
		db.getConnection();
		ResultSet rs = db.executeQry("SELECT * FROM Inventory WHERE user_name = '" + _user_name +"'");
		while(rs.next())
		{
			this.InventoryID = rs.getInt("InventoryID");
			this.user_name = rs.getString("user_name");
			Item _it = new Item();			
			_it.ItemID = rs.getInt("ItemID"); 
			_it.ItemName = rs.getString("ItemName");	
			_it.isActive = rs.getInt("isActive");
			Items.add(_it);
		}
		db.closeConnection();
	}

	@Override public String toString()
	{
		String rtn = "";
		
		for(int z=0;z<this.Items.size(); z++){
			rtn += "[Item " + z + "] = " + Items.get(z).ItemName;
			if (Items.get(z).isActive == 1){ rtn += " is active"; }
			rtn += "\n";			
		}
		
		return rtn;
	}
	
	public static void AddInventoryItem(int _ItemID)
	{
		
	}


	public class Item{
		public int ItemID = 0;
		public String ItemName = "";
		public int isActive = 0;
		public Item(){ this.ItemID = 0; this.ItemName = ""; this.isActive = 0;}
	}
	
	
}

