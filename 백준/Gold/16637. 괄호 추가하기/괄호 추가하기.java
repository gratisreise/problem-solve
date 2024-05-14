import java.io.*;
import java.util.*;

public class Main{
    static int n, ret = Integer.MIN_VALUE;
    static String s;
    static List<Integer> num = new ArrayList<>();
    static List<Character> operChar = new ArrayList<>();

    //계산 메서드
    static int oper(char a, int b, int c){
        int ret = 0;
        if(a == '+') ret = b + c;
        else if(a == '*') ret = b * c;
        else if(a == '-') ret = b - c;
        return ret;
    }
    static void go(int idx, int sum){
        if(idx == operChar.size()){ // 연산자를 모두 사용했으면
            ret = Math.max(ret, sum); //최댓값 찾아주기
            return;
        }
        // 순서대로 현재랑 바로 다음 수랑 계산해서 넘기기
        go(idx + 1, oper(operChar.get(idx), sum, num.get(idx+1)));
        // 2번 연산해야하므로 2를 더해서 size보다 크면 연산제외 시켜준다.
        if(idx + 2 > operChar.size()) return;
        int temp = oper(operChar.get(idx + 1), num.get(idx + 1), num.get(idx + 2));
        go(idx + 2, oper(operChar.get(idx), sum, temp));
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        s = br.readLine();
        for(char c : s.toCharArray()){
            if('0' <= c && c <= '9') num.add(c - '0');
            else operChar.add(c);
        }

        go(0, num.get(0));

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}