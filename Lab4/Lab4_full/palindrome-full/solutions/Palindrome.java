/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Palindrome {
	private Boolean solve(String s, int K) {
		if (K + 1 >= s.length()) {
			return true;
		}
		boolean[][][] dp = new boolean[s.length()][s.length()][K + 1];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k <= K; k++) {
					dp[i][j][k] = false;
				}
			}
		}
		for (int i = 0; i < s.length(); i++) {
			dp[i][i][0] = true;
		}
		for (int i = 0; i + 1 < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1][0] = true;
			} else {
				if (K >= 1) dp[i][i + 1][1] = true;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i + 2; j < s.length(); j++) {
				for (int k = 0; k <= K; k++) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j][k] |= dp[i + 1][j - 1][k];
					}
					if (k >= 1) {
						dp[i][j][k] |= dp[i + 1][j][k - 1];
						dp[i][j][k] |= dp[i][j - 1][k - 1];
					}
				}
			}
		}
		boolean answer = false;
		for (int k = 0; k <= K; k++) {
			answer |= dp[0][s.length() - 1][k];
		}
		return answer;
	}

    private void run() {
    	Scanner sc = new Scanner(System.in);
    	int numTest = sc.nextInt();
    	while (numTest > 0) {
    		numTest--;
    		String s = sc.next();
    		int K = sc.nextInt();	
    		System.out.println(solve(s, K) ? "YES" : "NO");
    	}
    }

    public static void main(String args[]) {
        Palindrome runner = new Palindrome();
        runner.run();
    }
} 
