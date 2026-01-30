import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int temp = 1; // 곱셈 연산의 중간값을 저장하는 변수

        boolean isValid = true; // 올바른 괄호열인지 체크하는 플래그

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 1. 여는 괄호 '('
            if (c == '(') {
                stack.push(c);
                temp *= 2;
            }
            // 2. 여는 괄호 '['
            else if (c == '[') {
                stack.push(c);
                temp *= 3;
            }
            // 3. 닫는 괄호 ')'
            else if (c == ')') {
                // 스택이 비었거나 짝이 맞지 않는 경우
                if (stack.isEmpty() || stack.peek() != '(') {
                    isValid = false;
                    break;
                }
                
                // 바로 직전 문자가 '(' 인 경우에만 값 더하기
                if (s.charAt(i - 1) == '(') {
                    answer += temp;
                }
                
                stack.pop();
                temp /= 2;
            }
            // 4. 닫는 괄호 ']'
            else if (c == ']') {
                // 스택이 비었거나 짝이 맞지 않는 경우
                if (stack.isEmpty() || stack.peek() != '[') {
                    isValid = false;
                    break;
                }
                
                // 바로 직전 문자가 '[' 인 경우에만 값 더하기
                if (s.charAt(i - 1) == '[') {
                    answer += temp;
                }
                
                stack.pop();
                temp /= 3;
            }
        }

        // 모든 처리 후 스택이 비어있지 않거나, 도중에 유효하지 않은 괄호가 발견된 경우
        if (!isValid || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}