import java.util.ArrayList;

public class ItemList{
    private ArrayList<MyPair<String,Double>> myItems;
    public ItemList(){
        myItems = new ArrayList<MyPair<String,Double>>();    
    }
    
    public void addItem(String name, double price)
    {
        myItems.add( new MyPair<String,Double>(name,price));
    }
    
    public String toString()
    {
        String str = " ";
        for(MyPair<String,Double> each : myItems){
            str +=each + "\n";
            //System.out.print("\n" + each + " ");
        }
        return str;
    }
}