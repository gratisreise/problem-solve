import java.io.*;
import java.util.*;

public class Main{
    static int A, B, team, n, retA, retB;
    static String time, prev = "00:00";

    static int sum(){
        return mToS(time) - mToS(prev);
    }
    static int mToS(String s){
        String[] temp = s.split(":");
        int a = Integer.parseInt(temp[0]) * 60;
        int b = Integer.parseInt(temp[1]);
        return a + b;
    }
    static String sToM(int n){
        String a = ("00" + n / 60);
        String b = ("00" + n % 60);
        return a.substring(a.length()-2) + ":" + b.substring(b.length()-2);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            team = Integer.parseInt(st.nextToken());
            time = st.nextToken();
            if(A > B) retA += sum();
            else if(B > A) retB += sum();

            if(team == 1) A++; else B++;
            prev = time;
        }
        time = "48:00";
        if(A > B) retA += sum();
        else if(B > A) retB += sum();
        bw.write(sToM(retA)+'\n');
        bw.write(sToM(retB)+'\n');
        bw.flush();
    }
}
/*
골이 들어간 시간 : 팀 이름
입력: 골이 들어간 횟수 n, n줄에 팀번호 :: 시간
누가 유리하지? -> 변수에 골수를 담아서 비교하자
어떻게 계산하지? -> 골이 들어갈 때마다 유불리를 비교해서 체크하자
언제 계산해야하지? -> 골이 들어간순간 유불리가 바뀔수 있으니 골이 입력되기전에 계산로직을넣자
시작과 끝의 경계처리
00:00부터 계산
48:00끝 계산

1. 골횟수 n 입력.
2. n번 팀번호 - 시간 입력받기
3. 입력되기 전에 이전 시간과 비교하여 유불리비교해서 시간 계산
4. 끝나는 시간에 유불리 비교해서 시간계산
 */