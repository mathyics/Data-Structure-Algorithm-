import java.util.*;
import javax.xml.stream.events.EndDocument;
class Greedy{
    public static void main(String[] args) {
        int start[] = {0,1,3,5,5,8};
        int finish[] = {6,2,4,7,9,9};
        
        int[][] activities= new int[start.length][3];

        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=finish[i]; 
        }
// sort using lamda expression
         Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        //end time basis sorted
        ArrayList<Integer> ans= new ArrayList<>();
        int maxActivity = 0;

        //1st activity
        maxActivity=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];

        for(int i=1;i<finish.length;i++){
            if(activities[i][1]>=lastEnd){
                maxActivity++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println("Maximum number of activities: " + maxActivity);
        System.out.print("Activities selected: "+ ans);

    }
}