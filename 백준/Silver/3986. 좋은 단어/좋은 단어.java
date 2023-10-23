import java.util.*;

public class Main {
    static int ret;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                else stack.push(c);
            }
            if (stack.isEmpty()) ret++;
        }

        System.out.println(ret);
    }
}
