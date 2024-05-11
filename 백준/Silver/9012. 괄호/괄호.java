import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n-- > 0){
            Stack<Character> stk = new Stack<>();
            String s = br.readLine();
            for(char c : s.toCharArray()){
                if(!stk.isEmpty() && stk.peek() == '(' && c == ')') stk.pop();
                else stk.push(c);
            }
            if(stk.isEmpty()) bw.write("YES\n");
            else bw.write("NO\n");
            bw.flush();
        }

    }
}
/*
괄호짝 맞는지 체크하는 문제
1. n 입력받기
2. 문자열 입력받기
3. 문자열 순회
    3-1. stack이 비어있으면
        3-1-1. 문자 넣기
    3-2. stack이 안 비어있으면
        3-2-1. peek()==( 이고 c == ')' 이면 pop()
4. stack이 체크
    4-1. 비어있으면 YES
    4-2. 안 비어있으면 NO
*/