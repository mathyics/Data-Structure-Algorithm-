import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiPredicate;

public class Graph2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }

    }

      public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited){//O(V + E)
        Queue<Integer> q= new LinkedList<>();
        q.add(0); // Starting from vertex 0

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visited[curr]){
                visited[curr]=true;
                System.out.print(curr + " ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        int V= graph.length;
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsUtil(graph, i,visited);
            }
        }
    }

     public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited){
        visited[curr]=true;
        System.out.print(curr + " ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }
    
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
               return detectCycleUtil(graph,0,visited,-1);
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, int parent){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.dest]){
                return detectCycleUtil(graph, e.dest, visited, curr);
             
            }
            if(visited[e.dest]&&e.dest!=parent){
                return true;
            }
        }

        return false;

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        Arrays.fill(col,-1);

        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e= graph[curr].get(j);
                        
                        if(col[e.dest]==-1) {
                        int nextCol= col[curr]==0?1:0;
                        col[e.dest]=nextCol;
                        q.add(e.dest);
                        }else if(col[curr]==col[e.dest]){
                            return false;
                        }

                    }
                }
            }
        }
        return true;

    }
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)) return true;
        }
        
    }
    return false;
}
     public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest])return true;

            if(!vis[e.dest]&&isCycleUtil(graph, e.dest, vis, stack)) 
                return true;
        }

        stack[curr]=false;
        return false;
     }

     public static void topologicalSort(ArrayList<Edge>[] graph){
        boolean[] vis= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topologicalSortUtil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){    
            System.out.print(s.pop()+" ");
            }


     }

      public static void topologicalSortUtil(ArrayList<Edge>[] graph,int curr, boolean[] vis, Stack<Integer> s ){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
      }
       
      public static void calcIndeg(ArrayList<Edge>[] graph,int inDeg[]){
        for(int i=0;i<graph.length;i++){
             int v=i;
             for(int j=0;j<graph[v].size();j++){
                Edge e=graph[v].get(j);
                inDeg[e.dest]++;
             }
        }
      }

      public static void topoBFS(ArrayList<Edge>[] graph){
        int inDeg[]= new int[graph.length];
        calcIndeg(graph,inDeg);
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
      }

      public static void printAllPath(ArrayList<Edge>[] graph,int src, int dest, String path){
        if(src==dest){
            System.err.println(path+dest);
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            printAllPath(graph,e.dest,dest,path+src+" ");
        }

      }


    public static void main(String[] args) {

        //if graph doesnt has cycle its bipartite graph;
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        

        printAllPath(graph, 5, 1, "");
    }

}
