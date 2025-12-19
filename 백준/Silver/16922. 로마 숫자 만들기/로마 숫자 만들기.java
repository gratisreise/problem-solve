import java.io.*;
import java.util.*;

public class Main {

    static int[] nums = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();
    static int n;
    static void go(int depth, int start, int sum){
        if(depth == n){
            set.add(sum);
            return;
        }

        for(int i = start; i < 4; i++){
            go(depth+1, i, sum + nums[i]);
        }

    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        n = Integer.parseInt(in.readLine());

        go(0, 0,0);

        System.out.println(set.size());

        out.flush();
        out.close();
    }
}