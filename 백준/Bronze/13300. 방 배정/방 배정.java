import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[6][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken())-1;
            arr[grade][gen]++;
        }
        int ret = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 2; j++){
                ret += arr[i][j]/k;
                if(arr[i][j] % k > 0) ret++;
            }
        }
        out.println(ret);


        out.flush();
        out.close();
    }
}