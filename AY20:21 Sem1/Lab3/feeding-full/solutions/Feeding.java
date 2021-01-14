/*input
5 3
1 3 18 25 26
3 2 8
*/

import java.util.*;

public class Feeding {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Stack<Long> input = new Stack<>();
        Stack<Long> fishes = new Stack<>();
        //reverse the order using input stack
        for (int i = 0; i < n; i++)
            input.push((long)sc.nextInt());
        for (int i = 0; i < n; i++)
            fishes.push(input.pop());

        //Read in new fish and keep eating smaller fishes. 
        for (int i = 0; i < m; i++) {
            long newFish = sc.nextInt();
            while (fishes.size() > 0 && fishes.peek() < newFish) {
                newFish += fishes.pop();
            }
            fishes.push(newFish);
        }

        int answer = fishes.size();
        for (int i = 0; i < answer; i++) {
            System.out.print(fishes.pop());
            if (i != answer - 1) System.out.print(" ");
        }

        System.out.println();
    }

    public static void main(String args[]) {
        Feeding feeding = new Feeding();
        feeding.run();
    }
}
