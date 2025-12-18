import java.io.*;
import java.util.*;

public class Main {

    static int calc(String prev, String now){
        int prevS = mToS(prev);
        int nowS = mToS(now);
        return nowS - prevS;
    }
    static int mToS(String time){
        String[] s = time.split(":");
        int m = Integer.parseInt(s[0]) * 60;
        int ss = Integer.parseInt(s[1]);
        return m + ss;
    }
    static String con(int second){
        String min = "00" + (second / 60);
        String sec = "00" + (second % 60);
        return min.substring(min.length()-2) +":"+sec.substring(sec.length()-2);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        int[] score = new int[3];
        int[] time = new int[3];

        int n = Integer.parseInt(in.readLine());

        String prev = "00:00";
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int teamNum = Integer.parseInt(st.nextToken());
            String now = st.nextToken();
            //지금까지 시간 계산해서 이긴 상태 팀넣어주기
            if(score[1] > score[2]){
                time[1] += calc(prev, now);
            } else if(score[1] < score[2]){
                time[2] += calc(prev, now);
            }
            score[teamNum]++; //점수계산
            prev = now;
        }

        String end = "48:00";
        if(score[1] > score[2]){
            time[1] += calc(prev, end);
        } else if(score[1] < score[2]){
            time[2] += calc(prev, end);
        }

        out.println(con(time[1]));
        out.println(con(time[2]));
        out.flush();
        out.close();
    }
}