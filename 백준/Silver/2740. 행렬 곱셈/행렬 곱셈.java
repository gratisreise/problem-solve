import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr1, arr2;
    static int m;
    static int ssum(int y, int x){
        int idx = 0;
        int sum = 0;
        while(idx < m){
            sum += (arr1[y][idx] * arr2[idx][x]);
            idx++;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr1 = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] nums = in.readLine().split(" ");
            for(int j = 0; j < m; j++){
                arr1[i][j] = Integer.parseInt(nums[j]);
            }
        }

        st = new StringTokenizer(in.readLine());
        m  = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr2 = new int[m][k];
        for(int i = 0; i < m; i++){
            String[] nums = in.readLine().split(" ");
            for(int j = 0; j < k; j++){
                arr2[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int[][] ret = new int[n][k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                ret[i][j] = ssum(i, j);
            }
        }

        var ans = new StringBuilder();
        for(int i = 0; i < n; i++){
            var temp = new StringBuilder();
            for(int j= 0; j < k; j++){
                temp.append(ret[i][j]).append(" ");
            }
            ans.append(temp.toString().trim());
            ans.append("\n");
        }
        System.out.println(ans);

        out.flush();
        out.close();
    }
}