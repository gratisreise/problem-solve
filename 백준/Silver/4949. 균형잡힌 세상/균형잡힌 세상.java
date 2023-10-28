import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (".".equals(s)) {
                break;
            }
            if (isBalanced(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')' && c != '[' && c != ']') {
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
