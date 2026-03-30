import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(in.readLine());

        var stk = new ArrayDeque<Integer>();
        var ret = new StringBuilder();

        int cur = 1; // 다음에 push할 숫자

        for (int num : nums) {
            // target까지 push
            while(cur <= num && cur <= n){
                stk.push(cur++);
                ret.append("+\n");
            }
            // 스택 top이 target과 같으면 pop
            if(!stk.isEmpty() && stk.peek() == num){
                stk.pop();
                ret.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        //모든 연산출력
        out.println(ret);
        out.flush();
        out.close();
    }
}