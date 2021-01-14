/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Jobs {
	private static long INF = 1000000000000000000L;
	private long answer = INF;
	private int n;
	private int[] a;

	private void backtrack(int pos, long sumA, long sumB, long sumC) {
		if (pos == n) {
			long maximum = Math.max(sumA, Math.max(sumB, sumC));
			answer = Math.min(answer, maxmimum);
			return;
		}
		backtrack(pos + 1, sumA + a[pos], sumB, sumC);
		backtrack(pos + 1, sumA, sumB + a[pos], sumC);
		backtrack(pos + 1, sumA, sumB, sumC + a[pos]);

	}

    private void run() {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	a = new int[n];
    	for (int i = 0; i < n; i++) {
    		a[i] = sc.nextInt();
    	}
    	backtrack(0, 0L, 0L, 0L);
    	System.out.println(answer);
    }

    public static void main(String args[]) {
        Jobs jobs = new Jobs();
        jobs.run();
    }
}
