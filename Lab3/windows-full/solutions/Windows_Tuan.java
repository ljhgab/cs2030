/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Windows {
    private void run() {
    	Scanner sc = new Scanner(System.in);

    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	int[] a = new int[n];

    	for (int i = 0; i < n; i++) {
    		a[i] = sc.nextInt();
    	}

    	Queue<Integer> queue = new LinkedList<>();
    	for (int i = 0; i < n; i++) {
    		if (a[i] % 2 == 1) {
    			queue.add(i);
    		}
    		while (queue.size() > 0 && queue.peek() <= i - k) {
				queue.poll();
    		}
    		if (i >= k - 1) {
    			System.out.print(queue.peek() == null ? "-1": (queue.peek() + 1));
                if (i < n - 1) {
                    System.out.print(" ");
                }
    		}
    		
    	}
    	System.out.println("");
    }

    public static void main(String args[]) {
        Windows windows = new Windows();
        windows.run();
    }
}
