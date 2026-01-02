import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = Math.min(b, Math.min(c, d));
        int m = Math.max(b, Math.max(c, d));

        List<Integer> burger = new ArrayList<>();
        List<Integer> cide = new ArrayList<>();
        List<Integer> drink = new ArrayList<>();


        int total = 0;
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < b; i++){
            int now = Integer.parseInt(st.nextToken());
            total += now;
            burger.add(now);
        }

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < c; i++){
            int now = Integer.parseInt(st.nextToken());
            total += now;
            cide.add(now);
        }

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < d; i++){
            int now = Integer.parseInt(st.nextToken());
            total += now;
            drink.add(now);
        }

        burger.sort(Comparator.reverseOrder());
        cide.sort(Comparator.reverseOrder());
        drink.sort(Comparator.reverseOrder());

        int discount = 0;
        for(int i = 0; i < n; i++){
            int bb = burger.get(i);
            int cc = cide.get(i);
            int dd = drink.get(i);
            int sum = (bb + cc + dd) * 9 / 10;
            discount += sum;
        }

        for(int i = n; i < m; i++){
            if(burger.size() > i) discount += burger.get(i);
            if(cide.size() > i) discount += cide.get(i);
            if(drink.size() > i) discount += drink.get(i);
        }
        out.println(total);
        out.println(discount);



        out.flush();
        out.close();
    }
}