import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int ret = sum;

        for(int i = k; i < n; i++){
            sum = sum - nums[i - k] + nums[i];
            ret = Math.max(ret, sum);
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}