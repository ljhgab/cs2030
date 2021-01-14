/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Movies {
	private int n, m;
	private long answer = 0;

	public static class Movie {
		public int L, R, S;

		public Movie(int L, int R, int S) {
			this.L = L;
			this.R = R;
			this.S = S;
		}

		public boolean intersect(Movie other) {
			if (this.R <= other.L) {
				return false;
			}
			if (other.R <= this.L) {
				return false;
			}
			return true;
		}
	}

	private Movie[] movies;

    //pos: the current movie we are dealing with
    //chosen[i]: whether the ith movie is chosen
    //taken: # of movies chosen; sum: total time
	private void backtrack(int pos, boolean[] chosen, int taken, long sum) {
		if (pos == n) {
			answer = Math.max(answer, sum);
			return;
		}

        //not choose this movie
		chosen[pos] = false;
		backtrack(pos + 1, chosen, taken, sum);

        //check whether this movie has time conflicts with the movies already chosen.
		if (taken < m) {
			for (int i = 0; i < pos; i++) {
				if (chosen[i] && movies[pos].intersect(movies[i])) {
					return;
				}
			}
			///valid
			chosen[pos] = true;
			backtrack(pos + 1, chosen, taken + 1, sum + movies[pos].S);
		}
	}


    private void run() {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	m = sc.nextInt();

    	movies = new Movie[n];
    	for (int i = 0; i < n; i++) {
    		int L = sc.nextInt(), R = sc.nextInt(), S = sc.nextInt();
    		movies[i] = new Movie(L, R, S);
    	}

    	boolean[] chosen = new boolean[n];
    	backtrack(0, chosen, 0, 0);

    	System.out.println(answer);
    }

    public static void main(String args[]) {
        Movies runner = new Movies();
        runner.run();
    }
} 
