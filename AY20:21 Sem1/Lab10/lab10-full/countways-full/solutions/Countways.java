import java.util.*;

public class Countways {
	private static final long INF = 1000L * 1000 * 1000 * 1000 * 1000 * 1000;
	private static final int MOD = 1000000000 + 7;

    private static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    class State implements Comparable<State> {
        public int u;
        public long dist;

        public State(int u, long dist) {
            this.u = u;
            this.dist = dist;
        }

        public int compareTo(State other) {
        	if (dist < other.dist) {
        		return -1;
        	}
        	if (dist > other.dist) {
        		return 1;
        	}
        	return 0;
        }
    }

    private List<List<Edge>> V;
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;

		V = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            V.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            --u;
            --v;
            Edge a = new Edge(u, v, w);
            Edge b = new Edge(v, u, w);
            V.get(u).add(a);
            V.get(v).add(b);
        }
        
        long[] d = new  long[n];
        long[] ways = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = INF;
        }

        d[S] = 0;
        ways[S] = 1;
        PriorityQueue<State> qu = new PriorityQueue<>(1 << 18);
        qu.offer(new State(S, 0));
        while (qu.size() > 0) {
            State current = qu.poll();
            int u = current.u;
            long dist = current.dist;
            if (d[u] != dist) continue;
            for (Edge next : V.get(u)) {
                int v = next.v, w = next.w;
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    ways[v] = ways[u];
                    qu.offer(new State(v, d[v]));
                } else if (d[v] == d[u] + w) {
                	ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        System.out.println(d[T] + " " + ways[T]);

	}

	public static void main(String[] args) {
		Countways runner = new Countways();
		runner.run();
	}
}
