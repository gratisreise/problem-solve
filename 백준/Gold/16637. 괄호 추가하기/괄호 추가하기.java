import java.util.Scanner;

public class Main {
    static int n;
    static int ret = Integer.MIN_VALUE;
    static String s;
    static int[] num;
    static char[] operStr;

    static int oper(char a, int b, int c) {
        int result = 0;
        if (a == '+') result = b + c;
        if (a == '*') result = b * c;
        if (a == '-') result = b - c;
        return result;
    }

    static void go(int here, int _num) {
        if (here == num.length - 1) {
            ret = Math.max(ret, _num);
            return;
        }
        go(here + 1, oper(operStr[here], _num, num[here + 1]));
        if (here + 2 <= num.length - 1) {
            int temp = oper(operStr[here + 1], num[here + 1], num[here + 2]);
            go(here + 2, oper(operStr[here], _num, temp));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();

        num = new int[s.length() / 2 + 1];
        operStr = new char[s.length() / 2];

        for (int i = 0, j = 0, k = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                num[j] = s.charAt(i) - '0';
                j++;
            } else {
                operStr[k] = s.charAt(i);
                k++;
            }
        }

        go(0, num[0]);
        System.out.println(ret);
    }
}
