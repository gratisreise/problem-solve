import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int k = Integer.parseInt(in.readLine());

        for(int i = 0; i < k; i++){
            var st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int max = -1;
            int min = 101;
            List<Integer> l = new ArrayList<>();
            for(int j= 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                l.add(num);
                max =Math.max(num, max);
                min = Math.min(num, min);
            }
            l.sort(Comparator.reverseOrder());
            int prev = l.get(0);
            int gap = 0;
            for(int j = 1; j < n; j++){
                int now = prev - l.get(j);
                gap = Math.max(gap, now);
                prev = l.get(j);
            }

            out.printf("Class %d\nMax %d, Min %d, Largest gap %d\n", i+1, max, min, gap);
        }


        out.flush();
        out.close();
    }
}