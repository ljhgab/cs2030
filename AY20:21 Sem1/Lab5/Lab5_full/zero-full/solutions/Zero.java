import java.util.*;

public class Zero {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		long[] prefix = new long[n];
		prefix[0] = a[0];
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + a[i];
		}
		Arrays.sort(prefix);

		
		long answer = 0;
		int last = -1;
		for (int i = 0; i < n; i++) {
			//finish the count of cumsum with value prefix[i]
			if (i == n - 1 || prefix[i] != prefix[i + 1]) {
				int cnt = i - last;
				//add the number of targeted subarray. N choose 2
				answer += (long) cnt * (cnt - 1) / 2;
				last = i;
			}

			//if cumsum == 0, add the answer by one 
			//because we omitted the 0-sum subarrays starting from a[0] in previous calculation
			if (prefix[i] == 0) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		Zero runner = new Zero();
		runner.run();
	}
}
