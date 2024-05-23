import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());;
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        stack.push(-1);
        char[] c = str.toCharArray();
        for (int i = 0; i < n; i++) {
            if (c[i] == '(')  stack.push(i);
            if (c[i] == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    ret = Math.max(ret, i - stack.peek());
                } else  stack.push(i);
            }
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}