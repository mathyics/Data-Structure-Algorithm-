import java.util.*;

public class Graph5 {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    static class Edge2 implements Comparable<Edge2> {
        int dest;
        int cost;

        public Edge2(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge2 e) {
            return this.cost - e.cost;
        }
    }

    public static void creatGraph(int[][] flight, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }

    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheastFlight(int n, int src, int dest, int k, ArrayList<Edge> graph[]) {
        int dist[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (src != i) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                // int u=e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // connect n cities;
    public static int connectCities(int[][] cities) {
        PriorityQueue<Edge2> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];
        int finalCost = 0;
        pq.add(new Edge2(0, 0));
        while (!pq.isEmpty()) {
            Edge2 curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge2(i, cities[curr.dest][i]));
                    }
                }

            }
        }

        return finalCost;
    }

    // Disjoint set DS
    static int n=4;
    static int[] rank = new int[n];
    static int[] parent = new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public static void union(int a, int b){
        a=find(a);
        b=find(b);
        if(rank[a]==rank[b]){
            parent[b] = a;
            rank[a]++;
        }else if(rank[a]<rank[b]){
            parent[a]=b;
        }else{
            parent[b]=a;
        }
    }

    public static int kruskal( ArrayList<Edge> edges,int v){
        Collections.sort(edges);
        int mst=0;
        int count=0;
        for (int i=0;count<v-1;i++){
            Edge e=edges.get(i);
            int a=find(e.src);
            int b= find(e.dest);
            if(a!=b){
                mst+=e.wt;
                count++;
                union(e.src, e.dest);
            }
        }

        return mst;

    }
    public static void main(String[] args) {
        // int n=4;
        // int[][] flight={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,300}};
        // int src=0, dest=3,k=1;
        // ArrayList<Edge>[] graph=new ArrayList[n];
        // creatGraph(flight, graph);
        // System.err.println(cheastFlight(n, src,dest, k, graph));

        // int[][] cities = { 
        //         { 0, 1, 2, 3, 4 },
        //         { 1, 0, 5, 0, 7 },
        //         { 2, 5, 0, 6, 0 },
        //         { 3, 0, 6, 0, 0 },
        //         { 4, 7, 0, 0, 0 } };

        //         System.out.println(connectCities(cities));

        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2,4);
        // union(3,6);
        // System.out.println(find(6));

        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        init();
        
        // 0 vertex
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));

        System.out.println(kruskal(graph, V));
        
    }
}
