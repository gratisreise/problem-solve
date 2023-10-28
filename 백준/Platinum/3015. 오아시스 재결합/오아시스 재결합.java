import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ret = 0;
        Stack<Pair> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            long temp = scanner.nextLong();
            int cnt = 1;

            while (!s.isEmpty() && s.peek().first <= temp) {
                ret += s.peek().second;
                if (s.peek().first == temp) {
                    cnt = s.peek().second + 1;
                } else {
                    cnt = 1;
                }
                s.pop();
            }
            if (!s.isEmpty()) {
                ret++;
            }
            s.push(new Pair(temp, cnt));
        }

        System.out.println(ret);
    }

    static class Pair {
        long first;
        int second;

        public Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
