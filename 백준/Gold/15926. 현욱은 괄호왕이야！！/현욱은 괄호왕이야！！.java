import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            }
            if (str.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    ret = Math.max(ret, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        System.out.println(ret);
    }
}
