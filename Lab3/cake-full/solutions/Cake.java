/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Cake {
    private void run() {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] a = new int[n];

    	for (int i = 0; i < n; i++) {
    		a[i] = sc.nextInt();
    	}

    	Stack<Integer> stack = new Stack<>();
    	int[] left = new int[n];
    	for (int i = 0; i < n; i++) {
            //pop out all columns higher than a[i]
    		while (stack.size() > 0 && a[stack.peek()] >= a[i]) {
    			stack.pop();
    		}
    		if (stack.size() > 0) {
    			left[i] = stack.peek();
    		} else {
                // Imagine that there is a column with index -1 that stops all other column from stretching out.
    			left[i] = -1; 
    		}
            stack.push(i);
    	}

    	stack.clear();
    	int[] right = new int[n];
    	for (int i = n - 1; i >= 0; i--) {
    		while (stack.size() > 0 && a[stack.peek()] >= a[i]) {
    			stack.pop();
    		}
    		if (stack.size() > 0) {
    			right[i] = stack.peek();
    		} else {
    			right[i] = n;
    		}
            stack.push(i);
    	}

    	long answer = 0;
    	for (int i = 0; i < n; i++) {
            //System.out.println(left[i] + " " + right[i]);
    		answer = Math.max(answer, (long) a[i] * (right[i] - left[i] - 1));
    	}

    	System.out.println(answer);
    }

    public static void main(String args[]) {
        Cake cake = new Cake();
        cake.run();
    }
}
