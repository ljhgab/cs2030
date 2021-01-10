/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Jobs {

    //find the worker with minimum working time
    private int findMinimum(long[] sum) {
        int k = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] < sum[k]) {
                k = i;
            }
        }
        return k;

    }

    private void run() {

        Integer[] a;
        int n;
        long[] sum = new long[3];

        for (int i = 0; i < 3; i++) {
            sum[i] = 0L;
        } 

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //sort in descending order
        Arrays.sort(a, Collections.reverseOrder());

        //every time allocate the jobs to worker with min working time 
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
            sum[findMinimum(sum)] += a[i];

        }

        long workingTime = 0;

        for (int i = 0; i < 3; i++) {
            workingTime = Math.max(workingTime, sum[i]);
        }

        System.out.println(workingTime);



    }

    public static void main(String args[]) {
        Jobs runner = new Jobs();
        runner.run();
    }
}
