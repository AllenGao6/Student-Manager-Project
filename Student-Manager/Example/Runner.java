import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		ArrayList<MyPair> customerList = new ArrayList<MyPair>();
		
		ItemList inventory = new ItemList();
        inventory.addItem("shoes",49.99);
        inventory.addItem("pen",1.99);
        
        customerList.add(new MyPair<String,ItemList>("Cindy",inventory));
        customerList.add(new MyPair<String,String>("John","<empty>"));
        for(int i = 0; i<customerList.size();i++)
        {
            //name
            System.out.println( customerList.get(i).getKey());
            //inventory
            System.out.println( customerList.get(i).getValue());
        }

	}
}