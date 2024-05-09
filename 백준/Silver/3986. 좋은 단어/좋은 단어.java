import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ret = 0;
        
        while(n-- > 0){
            String s = br.readLine();
            Stack<Character> stk = new Stack<>();
            for(char c : s.toCharArray()){
                if(!stk.isEmpty() && stk.peek() == c) stk.pop();
                else stk.push(c);
            }
            if(stk.isEmpty()) ret++;
        }

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}
/*
짝짓기 -> 스택사용
1. 단어의 수 n 입력받기
2. n번만큼 문자열 입력받기
3. 문자열 순회함녀서 stack에넣기
    3-1. 스택의 윗문자랑 넣어줘야하는 문자가 같으면 pop
    3-2. 아니면 그냥 스택에 넣기
4. 스택이 비워져 있으면 ret++
5. ret 출력
*/