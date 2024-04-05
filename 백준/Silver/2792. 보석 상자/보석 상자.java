import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       long n = Long.parseLong(st.nextToken());
       long m = Long.parseLong(st.nextToken());
       long[] a = new long[(int) m];

       long hi = 0;
       for (int i = 0; i < m; i++) {
           a[i] = Long.parseLong(br.readLine());
           hi = Math.max(hi, a[i]);
       }

       long lo = 1;
       long ret = Long.MAX_VALUE;

       while (lo <= hi) {
           long mid = (lo + hi) / 2;
           if (check(a, n, m, mid)) {
               ret = Math.min(ret, mid);
               hi = mid - 1;
           } else {
               lo = mid + 1;
           }
       }

       System.out.println(ret);
   }

   private static boolean check(long[] a, long n, long m, long mid) {
       long num = 0;
       for (int i = 0; i < m; i++) {
           num += a[i] / mid;
           if (a[i] % mid != 0) {
               num++;
           }
       }
       return n >= num;
   }
}