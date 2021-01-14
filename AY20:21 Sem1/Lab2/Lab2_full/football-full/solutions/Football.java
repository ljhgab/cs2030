/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Football {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		int current = 0, moved = 0;
		while (moved < n) {
			current = p[current];
			moved++;

			if (current == 0) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

	public static void main(String args[]) {
		Football football = new Football();
		football.run();
	}
}
