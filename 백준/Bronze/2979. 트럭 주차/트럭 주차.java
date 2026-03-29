import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int[] cnt = new int[104];
        String[] nums = in.readLine().split(" ");
        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);
        int C = Integer.parseInt(nums[2]);

        for(int i = 0; i < 3; i++){
            String[] times = in.readLine().split(" ");
            int a = Integer.parseInt(times[0]);
            int b = Integer.parseInt(times[1]);
            for(int j = a; j < b; j++) cnt[j]++;
        }
        int ret = 0;
        for(int i = 1; i < 100; i++){
            if(cnt[i] == 1) ret += A;
            else if(cnt[i] == 2) ret += B * 2;
            else if(cnt[i] == 3) ret += C * 3;
        }
        out.println(ret);
        out.flush();
        out.close();
    }
}