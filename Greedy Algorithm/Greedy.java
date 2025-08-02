import java.util.*;
import javax.xml.stream.events.EndDocument;
class Greedy{
    public static void main(String[] args) {
        int start[] = {1,3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};

        //end time basis sorted
        ArrayList<Integer> ans= new ArrayList<>();
        int maxActivity = 0;

        //1st activity
        maxActivity=1;
        ans.add(0);
        int lastEnd=finish[0];

        for(int i=1;i<finish.length;i++){
            if(start[i]>=lastEnd){
                maxActivity++;
                ans.add(i);
                lastEnd=finish[i];
            }
        }
        System.out.println("Maximum number of activities: " + maxActivity);
        System.out.print("Activities selected: "+ ans);

    }
}