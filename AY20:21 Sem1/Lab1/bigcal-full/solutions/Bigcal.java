import java.util.*;
import java.math.BigInteger;

public class Bigcal {
    private void run() {
        Scanner in = new Scanner(System.in);
        String raw_a = in.next();
        String raw_b = in.next();
        BigInteger a = new BigInteger(raw_a);
        BigInteger b = new BigInteger(raw_b);
        System.out.println(a.add(b));
    }

    public static void main(String[] args) {
        Bigcal newBigcal = new Bigcal();
        newBigcal.run();
    }
}
