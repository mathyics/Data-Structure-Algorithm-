import java.util.*;
import javax.xml.stream.events.EndDocument;
class Greedy{
    public static void main(String[] args) {
//         int start[] = {0,1,3,5,5,8};
//         int finish[] = {6,2,4,7,9,9};
        
//         int[][] activities= new int[start.length][3];

//         for(int i=0;i<start.length;i++){
//             activities[i][0]=i;
//             activities[i][1]=start[i];
//             activities[i][2]=finish[i]; 
//         }
// // sort using lamda expression
//          Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
//         //end time basis sorted
//         ArrayList<Integer> ans= new ArrayList<>();
//         int maxActivity = 0;

//         //1st activity
//         maxActivity=1;
//         ans.add(activities[0][0]);
//         int lastEnd=activities[0][2];

//         for(int i=1;i<finish.length;i++){
//             if(activities[i][1]>=lastEnd){
//                 maxActivity++;
//                 ans.add(activities[i][0]);
//                 lastEnd=activities[i][2];
//             }
//         }
//         System.out.println("Maximum number of activities: " + maxActivity);
//         System.out.print("Activities selected: "+ ans);



        // int val[]={60, 100, 120};
        // int wt[]={10, 20, 30};
        // int W=50;

        // double ratio[][] = new double[val.length][2];
        // // 0 col=> index , 1 col=> ratio
        // for(int i=0;i<val.length;i++){
        //     ratio[i][0]=i;
        //     ratio[i][1]=(double)val[i]/wt[i];
        // }
        // // sort using lamda expression
        // Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        // int capacity=W;
        // int finalval=0;
        
        // for(int i=val.length-1;i>=0;i--){
        //    int idx=(int)ratio[i][0];

        //    if(capacity>=wt[idx]){
        //     finalval= finalval + val[idx];
        //     capacity=capacity-wt[idx];
        //    }else{
        //     finalval+=(capacity*ratio[i][1]);
        //     capacity=0;
        //     break;
        //    }
        // }
        // System.out.println("Maximum value in Knapsack = " + finalval);
        // System.out.println();



        int A[]={4,1,8,7};
        int B[]={2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff=0;
        for(int i=0;i<A.length;i++){
            minDiff+=Math.abs(A[i]-B[i]);
        }

        System.out.println("Minimum Absolute difference is: " + minDiff);
       

    }
}

