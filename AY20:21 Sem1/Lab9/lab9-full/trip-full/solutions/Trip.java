import java.util.*;

public class Trip {
	private int n;
	private int m;
	private ArrayList[] edges;
	private int[] interesting;
	private boolean[] visited;

	boolean dfs(int u, int T) {
		visited[u] = true;
		if (u == T) {
			return true;
		}
		for (Object vo: edges[u]) {
			Integer v = (Integer)vo;
			if (!visited[v]) {
				if (dfs(v, T)) {
					return true;
				}
			}
		}
		return false;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;

		edges = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<Integer>();
		}

		interesting = new int[n];
		for (int i = 0; i < n; i++) {
			interesting[i] = sc.nextInt();
		}

		while (m-- > 0) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			if (interesting[v] > interesting[u]) {
				edges[u].add(v);
			}
			
			if (interesting[u] > interesting[v]) {
			    edges[v].add(u);
			} 
		}

		visited = new boolean[n];
		if (dfs(S, T)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		Trip runner = new Trip();
		runner.run();
	}
}
