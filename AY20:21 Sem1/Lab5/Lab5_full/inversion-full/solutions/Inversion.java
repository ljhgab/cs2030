import java.util.*;

public class Inversion {

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		Inversion runner = new Inversion();
		runner.run();		
	}
}
