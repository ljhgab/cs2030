/*input
7
1 5
1 8
2
1 20
2
1 17
2
*/
import java.util.*;

public class Median {
    private static final int maxSize = 100000;
    private void run() {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> right = new PriorityQueue<Integer>(maxSize);
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(maxSize, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                }
                if (a < b) {
                    return 1;
                }
                return 0;
            }
        });
        int totalSize = 0;

        int Q = sc.nextInt();
        while (Q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                ///insert element
                int value = sc.nextInt();
                if (totalSize == 0) {
                    left.offer(value);
                } else if (totalSize == 1) {
                    if (value < left.peek()) {
                        //swap
                        right.offer(left.poll()); 
                        left.offer(value);
                    } else {
                        right.offer(value);
                    }
                } else {
                    ///size >= 2, each half has peak
                    if (value > right.peek()) {
                        right.offer(value);
                    } else {
                        left.offer(value);
                    }
                    ///balancing the two
                    while (right.size() > left.size()) {
                        left.offer(right.poll());
                    }
                    while (right.size() + 2 <= left.size()) {
                        right.offer(left.poll());
                    }
                }
                totalSize++;
            }

            if (type == 2) {
                if (totalSize == 0) {
                    System.out.println("None");
                } else if (totalSize % 2 == 1) {
                    System.out.println(left.peek());
                } else {
                    System.out.println(left.peek() + " " + right.peek());
                }
            }
        }
    }

    public static void main(String[] args) {
        Median runner = new Median();
        runner.run();
    }
}
