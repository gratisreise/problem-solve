import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int test = Integer.parseInt(in.readLine());
        for(int t = 0; t < test; t++){
            int n = Integer.parseInt(in.readLine());
            int[] cnt = new int[n + 1];
            int total = 0;
            int max  = -1;
            for(int i = 1; i <= n; i++){
                cnt[i] = Integer.parseInt(in.readLine());
                max = Math.max(max, cnt[i]);
                total += cnt[i];
            }
            int r = -1;
            int count = 0;

            for(int i = 1; i <= n; i++){
                if(cnt[i] == max) {
                    r = i;
                    count++;
                }
            }
            if(count > 1) {
                out.println("no winner");
                continue;
            }
            if(max  > total/2) out.printf("majority winner %d\n", r);
            else out.printf("minority winner %d\n", r);
        }

        out.flush();
        out.close();
    }
}