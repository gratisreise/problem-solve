import com.sun.security.jgss.GSSUtil;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] pos;
    static class Point{
        int s; int e;
        Point(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    static boolean check(int mid){
        Point[] points = new Point[m];
        for(int i = 0; i < m; i++){
            int now = pos[i];
            int s = Math.max(0, now - mid);
            int e = Math.min(n, now + mid);
            points[i] = new Point(s, e);
        }
        if(points[0].s > 0) return false;
        int prev = points[0].e; //이전의 끝
        for(int i = 1; i < m; i++){
            int nowS = points[i].s;
            int nowE = points[i].e;
            if(nowS > prev) return false;
            prev = nowE;
        }
        if(prev != n) return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);



        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());
        var st = new StringTokenizer(in.readLine());
        pos = new int[m];
        for(int i = 0; i < m; i++){
            pos[i] =  Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = n;
        int ret = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(check(mid)){
                r = mid - 1;
                ret = mid;
            } else {
                l = mid + 1;
            }
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}