/*input
11
4 usa
3
1 224.55.212.234 vnm 3
4 singapore
1 224.55.212.234 vnm 2
4 usa
1 36.242.10.124 brazil 4
1 183.250.153.191 singapore 4
2 vnm
2 singapore
4 singapore

*/
import java.util.*;

public class Website {
    private void run() {
        Scanner sc = new Scanner(System.in);

        ///map from ip to number of accesses
        Map<String, Integer> userAccess = new HashMap<>();
        Map<String, Integer> countryAccess = new HashMap<>();
        Map<String, Integer> activeUsers = new HashMap<>();
        Map<String, Integer> userDuration = new HashMap<>();
        Map<String, Integer> countryDuration = new HashMap<>();

        int Q = sc.nextInt();
        while (Q > 0) {
            Q--;

            int type = sc.nextInt();

            if (type == 1) {
                ///log
                String ip = sc.next();
                String country = sc.next();
                int duration = sc.nextInt();

                ///update everything
                userAccess.putIfAbsent(ip, 0);
                activeUsers.putIfAbsent(country, 0);
                countryAccess.putIfAbsent(country, 0);
                userDuration.putIfAbsent(ip, 0);
                countryDuration.putIfAbsent(country, 0);

                countryAccess.computeIfPresent(country, (key, x) -> x + 1);
                int current = userAccess.computeIfPresent(ip, (key, x) -> (x + 1));

                if (current == 1) {
                    activeUsers.computeIfPresent(country, (key, x) -> x + 1);
                }

                userDuration.computeIfPresent(ip, (key, x) -> x + duration);
                countryDuration.computeIfPresent(country, (key, x) -> Math.max(x, userDuration.get(ip)));
            }

            if (type == 2) {
                String country = sc.next();
                Integer result = countryDuration.get(country);
                if (result == null) {
                    System.out.println(0);
                } else {
                    System.out.println(result);
                }
            }

            if (type == 3) {
                System.out.println(countryAccess.size());
            }

            if (type == 4) {
                String country = sc.next();
                Integer result = activeUsers.get(country);
                if (result == null) {
                    System.out.println(0);
                } else {
                    System.out.println(result);
                }
            }
        }
    }

    public static void main(String[] args) {
        Website runner = new Website();
        runner.run();
    }
}
