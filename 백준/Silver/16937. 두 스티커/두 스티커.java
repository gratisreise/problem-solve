import java.io.*;
import java.util.*;

public class Main {
    static class P{
        int h; int w;
        P(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
    public static boolean check(int H, int W, int r1, int c1, int r2, int c2) {
        // 1. 가로로 붙이기: (r1+r2) x max(c1,c2)
        if((r1 + r2 <= H && Math.max(c1, c2) <= W) || (r1 + r2 <= W && Math.max(c1, c2) <= H)){
            return true;
        }
        // 2. 세로로 붙이기: max(r1,r2) x (c1+c2)
        if((Math.max(r1, r2) <= H && c1 + c2 <= W) || (Math.max(r1, r2) <= W && c1 + c2 <= H)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(in.readLine());

        List<P> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int hh = Integer.parseInt(st.nextToken());
            int ww = Integer.parseInt(st.nextToken());
            l.add(new P(hh, ww));
        }
        int ret = 0;
        for(int i = 0; i < l.size(); i++){
            for(int j = i + 1; j < l.size(); j++){
                P p1 = l.get(i);
                P p2 = l.get(j);
                int h1 = p1.h, w1 = p1.w, h2 = p2.h, w2 = p2.w;
                if(check(h,w,h1,w1,h2,w2)){
                    ret = Math.max(ret, (h1*w1 + h2*w2));
                } else if(check(h,w,h1,w1,w2,h2)){
                    ret = Math.max(ret, (h1*w1 + h2*w2));
                } else if(check(h,w,w1,h1,h2,w2)){
                    ret = Math.max(ret, (h1*w1 + h2*w2));
                } else if(check(h,w,w1,h1,w2,h2)){
                    ret = Math.max(ret, (h1*w1 + h2*w2));
                }
            }
        }
        
        out.println(ret);
        out.flush();
        out.close();
    }
}