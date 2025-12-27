import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] b = new int[h+x][w+y];
        for(int i = 0; i < h+x; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < w+y; j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] a = new int[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if (i >= x && j >= y) {
                    // 1단계 힌트: 겹치는 영역은 빼주기!
                     a[i][j] = b[i][j] - a[i-x][j-y];
                } else {
                    // 겹치지 않는 영역은 그대로!
                    a[i][j] = b[i][j];
                }
            }
        }
        var ret = new StringBuilder();
        for(int[] row : a){
            for(int j = 0; j < w; j++){
                ret.append(row[j]);
                if(j < w-1) ret.append(" ");
            }
            ret.append("\n");
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}