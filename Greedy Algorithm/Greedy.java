import java.util.*;
class Greedy{
    static class Job{
        int id;
        int deadline;
        int profit;

       public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
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



        // int A[]={4,1,8,7};
        // int B[]={2,3,6,5};

        // Arrays.sort(A);
        // Arrays.sort(B);
        // int minDiff=0;
        // for(int i=0;i<A.length;i++){
        //     minDiff+=Math.abs(A[i]-B[i]);
        // }

        // System.out.println("Minimum Absolute difference is: " + minDiff);


        // int pairs[][]={{5,24},{39,60},{15,28},{27,40},{50,90}};
        // Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));
        // int chainLen=1;
        // int chainEnd=pairs[0][1];

        // for(int i=0;i<pairs.length;i++){
        //     if(chainEnd<pairs[i][0]){
        //         chainLen++;
        //         chainEnd=pairs[i][1];
        //     }

        // }
        // System.out.println("Maximum chain length is: " + chainLen);


        //Indian Coin Change Problem
        // Integer coins[]={1,2,5,10,20,50,100,500,2000};
        // Arrays.sort(coins,Comparator.reverseOrder());

        // int amount=590;
        // int ans=0;

        // for(int i=0;i<coins.length;i++){
        //     if(coins[i]<=amount){
        //         while(coins[i]<=amount){
        //             ans++;
        //             amount-=coins[i];
        //         }
        //     }
        // }
        // System.out.println("Minimum number of coins required: " + ans);
        
    //     int jobs[][]={{4,20},{1,10},{1,40},{1,30}};

    //     ArrayList<Job> jobList = new ArrayList<>();
    //     for(int i=0;i<jobs.length;i++){
    //         jobList.add(new Job(i,jobs[i][0],jobs[i][1]));
    //     }

    //     Collections.sort(jobList,(a,b)->b.profit-a.profit);

    //     ArrayList<Integer> seq= new ArrayList<>();
    //     int time=0;

    //     for(int i=0;i<jobList.size();i++){
    //         Job curr=jobList.get(i);
    //         if(curr.deadline>time){
    //             time++;
    //             seq.add(curr.id+1);
    //         }
    //     }
    //     System.out.println("Maximum profit job sequence: " + seq);
    //     System.out.println("Total time taken: " + time);

      Integer costVer[] = {2,1,3,1,4};
      Integer costHor[] = {4,1,2};
      Arrays.sort(costVer, Collections.reverseOrder());
      Arrays.sort(costHor, Collections.reverseOrder());

      int h=0,v=0;
      int hp=1, vp=1;
      int cost=0;
      while(h<costHor.length&&v<costVer.length){
        if(costHor[h]>=costVer[v]){
            cost+=vp*costHor[h];
            hp++;
            h++;
        }else{
            cost+=hp*costVer[v];
            vp++;
            v++;
        }
      }
      while(h<costHor.length){
         cost+=vp*costHor[h];
            hp++;
            h++;
      }
      while(v<costVer.length){
           cost+=hp*costVer[v];
            vp++;
            v++;
      }
        System.out.println("Minimum cost to connect all points: " + cost);


      }
    
}

