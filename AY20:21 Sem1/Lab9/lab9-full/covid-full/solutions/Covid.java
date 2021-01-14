import java.util.*;

public class Covid {
	private int n, m;
	private ArrayList<ArrayList<Integer> > edges;


    //sources record the people who are infected initially
	void BFS(ArrayList<Integer> sources) {
		//d records the distance of one node to the nearest source
		//In this case d is the week when a person is infected 
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = -1;
		}

		Queue<Integer> queue = new LinkedList();
		for(Integer v: sources) {
			d[v] = 0;
			queue.offer(v);
		}

		while (queue.size() > 0) {
			int u = queue.poll();
			for (Integer v: edges.get(u)) {
				if (d[v] == -1) {
					d[v] = d[u] + 1;
					queue.offer(v);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (d[i] == -1) {
				System.out.println("Some are safe!");
				return;
			} else {
				answer = Math.max(answer, d[i]);
			}
		}
		System.out.println(answer);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		edges = new ArrayList<ArrayList<Integer> >();
		for (int i = 0; i < n; i++) {
			edges.add(new ArrayList<Integer>());
		}

		while (m-- > 0) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			edges.get(a).add(b);
			edges.get(b).add(a);
		}

		int k = sc.nextInt();
		ArrayList<Integer> sources = new ArrayList<>();
		while (k-- > 0) {
			int x = sc.nextInt() - 1;
			sources.add(x);
		}
		
		BFS(sources);
	}

	public static void main(String[] args) {
		Covid runner = new Covid();
		runner.run();
	}
}
