import java.io.*;
import java.util.*;

public class Main {
    static int mToS(String time){
        String[] times = time.split(":");
        int m = Integer.parseInt(times[0]) * 60;
        int s = Integer.parseInt(times[1]);
        return m + s;
    }
    static int count(String prev, String now) {
        return mToS(now) - mToS(prev);
    }
    static String sToM(int time){
        String m = ("00" + time/60);
        String s = ("00" + time%60);
        return m.substring(m.length()-2) + ":" +s.substring(s.length()-2);
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int a = 0, b = 0; //점수
        int A = 0, B = 0; //유리시간
        String prev = "00:00";
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            if(a > b) A += count(prev, time);
            else if(a < b) B += count(prev, time);
            if(team == 1) a++; else b++;
            prev = time;
        }

        String end = "48:00";
        if(a > b) A += count(prev, end);
        else if(a < b) B += count(prev, end);
        out.println(sToM(A));
        out.println(sToM(B));

        out.flush();
        out.close();
    }
}