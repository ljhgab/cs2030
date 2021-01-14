import java.util.*;

public class Height {
    private ArrayList<ArrayList<Edge>> adjList;
    private void addEdge(int a, int b, int c) {
        adjList.get(a).add(new Edge(b, c));
    }


    private boolean[] visited;
    private long[] relHeight;

    private void dfs(int x) {
        if (visited[x]) return;
        visited[x] = true;
        for (Edge e : adjList.get(x)) {
            if (visited[e.getDest()]) continue;
            relHeight[e.getDest()] = relHeight[x] + e.getHeightDiff();
            dfs(e.getDest());
        }
    }

    private void processQuery(int x, int y) {
        long result = relHeight[y] - relHeight[x];
        System.out.println(result);
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        adjList = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; ++i) {
            adjList.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < N-1; ++i) {
            int a = sc.nextInt()-1, b = sc.nextInt()-1, h = sc.nextInt();
            addEdge(a, b, h);
            addEdge(b, a, -h);
        }

        relHeight = new long[N];
        relHeight[0] = 0;
        dfs(0);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; ++i) {
            processQuery(sc.nextInt()-1, sc.nextInt()-1);
        }
    }
    public static void main(String[] args) {
        Height newHeight = new Height();
        newHeight.run();
    }
    
}

class Edge {
    private int dest;
    private int heightDiff;
    public Edge (int dest, int heightDiff) {
        this.dest = dest;
        this.heightDiff = heightDiff;
    }
    
    public int getDest() {
        return this.dest;
    }
    
    public int getHeightDiff() {
        return this.heightDiff;
    }
}
