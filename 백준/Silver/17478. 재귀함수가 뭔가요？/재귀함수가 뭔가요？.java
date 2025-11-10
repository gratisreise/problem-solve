import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder line1 = new StringBuilder("\"재귀함수가 뭔가요?\"");
    static StringBuilder line2 = new StringBuilder("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
    static StringBuilder line3 = new StringBuilder("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
    static StringBuilder line4 = new StringBuilder("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
    static StringBuilder line5 = new StringBuilder("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
    static StringBuilder line6 = new StringBuilder("라고 답변하였지.");
    static int n;
    static StringBuilder build(int n){
        return new StringBuilder("____".repeat(n));
    }
    static void go(int cnt){
        if(cnt == n) {
            System.out.println(build(cnt).append(line1));
            System.out.println(build(cnt).append(line5));
            System.out.println(build(cnt).append(line6));
            return;
        }
        System.out.println(build(cnt).append(line1));
        System.out.println(build(cnt).append(line2));
        System.out.println(build(cnt).append(line3));
        System.out.println(build(cnt).append(line4));
        go(cnt+1);
        System.out.println(build(cnt).append(line6));
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());


        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        go(0);


        out.flush();
        out.close();
    }
}
/*
"재귀함수가 뭔가요?"
"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
출력먼저
재귀체크는 그 다음
cnt == n이면 종료

*/