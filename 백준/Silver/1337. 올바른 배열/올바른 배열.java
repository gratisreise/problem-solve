import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        int[] nums = new int[n];
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(in.readLine());
            st.add(nums[i]);
        }
        Arrays.sort(nums);
        int ret = 5;
        for(int i = 0; i < n; i++){
            int now = nums[i];
            int cnt = 0;
            for(int j = now + 1; j < now + 5; j++){
                if(st.contains(j)) continue;
                cnt++;
            }
            ret = Math.min(ret, cnt);
        }
        System.out.println(ret);
        out.flush();
        out.close();
    }
}