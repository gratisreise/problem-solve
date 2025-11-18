import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int[][] arr = new int[104][104];
        for(int i = 0; i < 4; i++){
            var st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    arr[y][x] += 1;
                }
            }
        }

        int ret = 0;
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(arr[i][j] > 0) ret++;
            }
        }
        System.out.println(ret);






        out.flush();
        out.close();
    }
}