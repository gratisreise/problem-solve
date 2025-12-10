import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(in.readLine());
        int sx = 1, sy = 0;
        if(target > c * r){
            System.out.println(0);
            return;
        }
        int now = 0;
        int cntR = r;
        int cntC = c-1;
        int d = 0;
        while(now != target){
            if(d == 0 || d == 2){
                for(int i = 0; i < cntR; i++){
                    sy = sy + dy[d];
                    now++;
                    if(now == target) break;
                }
                cntR--;
            } else {
                for(int i = 0; i < cntC; i++){
                    sx = sx + dx[d];
                    now++;
                    if(now == target) break;
                }
                cntC--;
            }
            d = (d + 1) % 4;
        }
        System.out.println(sx + " " + sy);

        out.flush();
        out.close();
    }
}