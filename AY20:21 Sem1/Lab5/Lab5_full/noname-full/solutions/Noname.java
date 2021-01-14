import java.util.*;

public class Noname {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int[] cnt = new int[T + 1];
        int[] prefix = new int[T + 1];


        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            cnt[value]++;
        }

        prefix[0] = cnt[0];
        for (int i = 1; i <= T; i++) {
            prefix[i] = prefix[i - 1] + cnt[i];
        }

        long answer = 0;
        //we calculate answer for ordered pair (i, j) that i != j, then divide answer by 2 for final result. 
        for (int i = 0; i <= T; i++) {
            int j = T - i;
            answer += (long) cnt[i] * prefix[j];

            //we don’t want to count pairs of form (x, x) (same index))
            if (j >= i) {
                answer -= (long) cnt[i];
            }
        }
        
        System.out.println(answer / 2);
    }

    public static void main(String[] args) {
        Noname runner = new Noname();
        runner.run();
    }
}
