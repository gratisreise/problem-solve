import java.io.*;
import java.util.*;

public class Main {
    static class Problem{
        int score;
        int minutes;

        Problem(int s, int m){
            this.score = s;
            this.minutes = m;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        Stack<Problem> stk = new Stack<>();

        Problem now = new Problem(-1 , -1);
        int ret = 0;
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1){
                int score = Integer.parseInt(st.nextToken());
                int minutes = Integer.parseInt(st.nextToken());
                stk.push(now);
                now = new Problem(score, minutes-1);
            } else { // 해당 과제없음
                now.minutes--; // 차감
            }
            //now의 시간이 0일때 => 다른 놈 꺼내서 시작
            if(now.minutes == 0){ //후처리
                ret += now.score;
                if(!stk.isEmpty()){
                    now = stk.pop();
                }
            }
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}