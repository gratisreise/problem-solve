import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       long n = Long.parseLong(st.nextToken());
       long atk = Long.parseLong(st.nextToken());
       long mx = 0;
       long H = 0;

       for (int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine());
           int t = Integer.parseInt(st.nextToken());
           long a = Long.parseLong(st.nextToken());
           long h = Long.parseLong(st.nextToken());

           if (t == 1) {
               long damage = a * ((long) Math.ceil((double) h / atk) - 1);
               if (H < damage) {
                   mx += damage - H;
                   H = 0;
               } else {
                   H -= damage;
               }
           } else {
               atk += a;
               H = Math.min(H + h, mx);
           }
       }

       System.out.println(mx + 1);
   }
}