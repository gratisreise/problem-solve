import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] s = in.readLine().split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = arr[i][Math.max(j-1,0)] + Integer.parseInt(s[j]);
            }
        }
        

        int k = Integer.parseInt(in.readLine());

        for(int i = 0; i < k; i++){
            String[] s = in.readLine().split(" ");
            int y1 = Integer.parseInt(s[0])-1;
            int x1 = Integer.parseInt(s[1])-1;
            int y2 = Integer.parseInt(s[2])-1;
            int x2 = Integer.parseInt(s[3])-1;
            int sum = 0;
            for(int y = y1; y <= y2; y++){
                sum += (arr[y][x2] - (x1-1 < 0 ? 0 : arr[y][x1-1]));
            }
            out.println(sum);
        }
        
        out.flush();
        out.close();
    }
}