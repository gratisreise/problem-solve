import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) break;
            Stack<Character> stk = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c != '(' && c != ')' && c != '[' && c != ']') continue;
                if (!stk.isEmpty() && c == ')' && stk.peek() == '(') stk.pop();
                else if (!stk.isEmpty() && c == ']' && stk.peek() == '[') stk.pop();
                else stk.push(c);
            }
            if (stk.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}