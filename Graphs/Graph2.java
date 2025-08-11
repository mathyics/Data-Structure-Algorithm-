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

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited) {// O(V + E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // Starting from vertex 0

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                return detectCycleUtil(graph, 0, visited, -1);
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                return detectCycleUtil(graph, e.dest, visited, curr);

            }
            if (visited[e.dest] && e.dest != parent) {
                return true;
            }
        }

        return false;

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[curr] == col[e.dest]) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;

    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack))
                    return true;
            }

        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest])
                return true;

            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack))
                return true;
        }

        stack[curr] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int inDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topoBFS(ArrayList<Edge>[] graph) {
        int inDeg[] = new int[graph.length];
        calcIndeg(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.err.println(path + dest);
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src + " ");
        }

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }

    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (src != i) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if ((dist[u] + wt) < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void bellmanFold(ArrayList<Edge>[] graph,int src ){
        int dist[]= new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for(int i=0;i<V-1;i++){

            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if((dist[u]!=Integer.MAX_VALUE)&&(dist[u]+wt)<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }

    }

    static  class Pair2 implements Comparable<Pair2>{
        int v;
        int cost;
        public Pair2(int v,int cost){
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pair2 p2){
            return this.cost-p2.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair2>pq=new PriorityQueue<>();
        pq.add(new Pair2(0,0));
        int finalcost=0;

        while(!pq.isEmpty()){
            Pair2 curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair2(e.dest, e.wt));
                }
            }
        }

        System.out.println("Minimum cost of MST "+finalcost) ;


    }
    public static void main(String[] args) {

        // if graph doesnt has cycle its bipartite graph;
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(0, 3, 40));
      
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(4, 2, 50));
       

    prims(graph);
    }

}
