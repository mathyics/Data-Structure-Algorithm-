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
    public static void main(String[] args) {

        //if graph doesnt has cycle its bipartite graph;
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
       

        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2 vertex
       
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
       
        // 4 vertex

        graph[4].add(new Edge(4, 2, 1));
       graph[4].add(new Edge(4, 3, 1));
        

        System.out.println(isBipartite(graph));
    }

}
