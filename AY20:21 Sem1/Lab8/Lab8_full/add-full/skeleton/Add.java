/*input
6
1 5
1 8
2 3
1 7
3
3
*/
import java.util.*;

public class Add {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        long totalAdded = 0;

        PriorityQueue<Long> queue = new PriorityQueue<>();
        while (Q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                ///insert element
                long newElement = sc.nextInt();
                queue.offer(newElement - totalAdded);
            }

            if (type == 2) {
                ///add all
                int addValue = sc.nextInt();
                totalAdded += addValue;
            }

            if (type == 3) {
                ///poll peak
                if (queue.size() == 0) {
                    System.out.println("None");
                } else {
                    long answer = queue.poll() + totalAdded;
                    System.out.println(answer);
                }
            }
        }
    }

    public static void main(String[] args) {
        Add runner = new Add();
        runner.run();
    }
}