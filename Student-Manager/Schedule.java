import java.util.ArrayList;

public class Schedule{
    private ArrayList<Pair<Integer,String>> mySchedule;
    private boolean checksame = true;
    public Schedule()
    {
        mySchedule = new ArrayList<Pair<Integer,String>>();
    }
    
    public void addClass(int period, String classname){
        //check if the period is the same
        for(int i = 0; i<mySchedule.size();i++){
            if(mySchedule.get(i).getKey() == period)
                checksame = false;
        }
        //add items
        if(checksame){
            mySchedule.add(new Pair<Integer,String>(period,classname));
        
        //sort mySchedule
        
        for(int i=0;i<mySchedule.size()-1;i++){
            int m = i;
            for(int j=i+1;j<mySchedule.size();j++){
                if(mySchedule.get(m).getKey() > mySchedule.get(j).getKey())
                    m = j;
        }
            //swapping elements at position i and m
            Pair<Integer,String> temp = mySchedule.get(i);
            mySchedule.set(i, mySchedule.get(m));
            mySchedule.set(m, temp);
        
            }  
        }
        
        }
        public String toString(){
		String str = "";
		for(Pair<Integer,String> each : mySchedule){
			str += "Period " + each + "\t ";
		}
		return str;
	}
    }
        
    
