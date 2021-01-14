import java.util.*;
import java.util.function.Function;

public class Pizzasteve {
	private static final long INF = 1000L * 1000 * 1000 * 1000 * 1000 * 1000;

    private static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
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
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            --u;
            --v;
            Edge a = new Edge(u, v, w);
            V.get(u).add(a);
            edges.add(a);
        }


		Function<Integer, ArrayList<Long> > Dijkstra = (Integer source) -> {
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
            long[] d = new long[n];
            for (int i = 0; i < n; i++) {
                d[i] = INF;
            }
            d[source] = 0;
            PriorityQueue<State> qu = new PriorityQueue<>(1 << 18);
            qu.offer(new State(source, 0));
            while (qu.size() > 0) {
                State current = qu.poll();
                int u = current.u;
                long dist = current.dist;
                if (d[u] != dist) continue;
                for (Edge next : V.get(u)) {
                    int v = next.v, w = next.w;
                    if (d[v] > d[u] + w) {
                        d[v] = d[u] + w;
                        qu.offer(new State(v, d[v]));
                    }
                }
            }
            ArrayList<Long> result = new ArrayList();
            for (int i = 0; i < n; i++) {
            	result.add(d[i]);
            }

            return result;
        };

        ArrayList<Long> distS = Dijkstra.apply(S);
        ArrayList<Long> distT = Dijkstra.apply(T);

        Long answer = INF;
        for (int i = 0; i < n; i++) {
        	answer = Math.min(answer, Math.max(distS.get(i), distT.get(i)));
        }

        if (answer == INF) {
        	System.out.println("Sad");
        	return;
        }
        System.out.println(answer);

	}

	public static void main(String[] args) {
		Pizzasteve runner = new Pizzasteve();
		runner.run();
	}
}
