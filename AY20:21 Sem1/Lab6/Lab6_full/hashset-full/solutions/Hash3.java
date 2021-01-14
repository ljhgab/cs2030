import java.util.*;

public class Hash3 {
	private static class Triple {
		public long x;
		public long y;
		public long z;

		public Triple(long x, long y, long z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public boolean equals(Triple other) {
			return other.x == x && other.y == y && other.z == z;
		}
	}

	private static class MyData {
		private long[] prefixSum;
		private long[] prefixSquare;
		private long[] prefixSumMod;
		final long mod = 171000L;
		private int N;

		MyData(int N, int[] a) {
			this.N = N;
			prefixSum = new long[N];
			prefixSquare = new long[N];
			prefixSumMod = new long[N];

			for (int i = 0; i < N; i++) {
				prefixSum[i] = a[i];
				prefixSquare[i] =  a[i];
				prefixSumMod[i] = a[i];
			}

			for (int i = 1; i < N; i++) {
				prefixSum[i] += prefixSum[i - 1];
				prefixSquare[i] += prefixSquare[i - 1];
				prefixSumMod[i] += prefixSumMod[i - 1];
			}
		}

		public Triple get(int L, int R) {
			if (L == 0) {
				return new Triple(prefixSum[R], prefixSquare[R], prefixSumMod[R]);
			} else {
				return new Triple(prefixSum[R] - prefixSum[L - 1], prefixSquare[R] - prefixSquare[L - 1], 
					prefixSumMod[R] - prefixSumMod[L - 1]);
			}
		}
	} 
	private void run() {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}

		MyData storageA = new MyData(N, a);
		MyData storageB = new MyData(N, b);

		int Q = sc.nextInt();
		while (Q > 0) {
			Q--;

			int L = sc.nextInt(), R = sc.nextInt(), U = sc.nextInt(), V = sc.nextInt();
			L--;
			R--;
			U--;
			V--;

			if (R - L == V - U && storageA.get(L, R).equals(storageB.get(U, V))) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
	}
	public static void main(String[] args) {
		
		Hash3 runner = new Hash3();
		runner.run();
	}
}
