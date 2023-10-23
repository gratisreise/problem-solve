import java.util.*;

public class Main {
    static long modPower(long a, long b, long c) {
        if (b == 1) return a % c;
        long ret = modPower(a, b / 2, c);
        ret = (ret * ret) % c;
        if (b % 2 == 1) ret = (ret * a) % c;
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        long result = modPower(a, b, c);
        System.out.println(result);
    }   
}
