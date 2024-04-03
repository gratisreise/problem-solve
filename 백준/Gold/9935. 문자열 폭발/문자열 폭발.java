import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String b = sc.next();
        StringBuilder ret = new StringBuilder();

        for (char a : s.toCharArray()) {
            ret.append(a);
            if (ret.length() >= b.length() && ret.substring(ret.length() - b.length()).equals(b)) {
                ret.delete(ret.length() - b.length(), ret.length());
            }
        }

        if (ret.length() > 0) {
            System.out.println(ret);
        } else {
            System.out.println("FRULA");
        }
    }
}
