import java.util.*;

public class Nearest {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int answer[] = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = N + 1;
		}

		Map<Integer, Integer> seen = new HashMap();
		for (int i = 0; i < N; i++) {
			if (seen.containsKey(a[i])) {
				answer[i] = Math.min(answer[i], i - seen.get(a[i]));
			}
			seen.put(a[i], i);
		}

		seen.clear();
		for (int i = N - 1; i >= 0; i--) {
			if (seen.containsKey(a[i])) {
				answer[i] = Math.min(answer[i], seen.get(a[i]) - i);
			}
			seen.put(a[i], i);
		}

		for (int i = 0; i < N; i++) {
			if (answer[i] < N) {
				System.out.println(answer[i]);
			} else {
				System.out.println(-1);
			}
		}
	}

	public static void main(String[] args) {
		Nearest runner = new Nearest();
		runner.run();
	}
}
