import java.awt.dnd.DragSource;
import java.io.*;
import java.util.*;

public class Main {
    static int wate(int ret, int r, int g){
        int temp = ret % (r + g);
        if(temp < r) return r - temp;
        return 0;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int ret = 0;
        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int now = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            ret += d - now; //신호등까지오는 시간
            if(d == l){
                System.out.println(ret);
                return;
            }
            ret += wate(ret, r, g);// 기다리는 시간
            now = d;//위치이동
        }

        ret += l - now;
        System.out.println(ret);
        out.flush();
        out.close();
    }
}