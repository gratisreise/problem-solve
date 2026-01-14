import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Double> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            double db = Double.parseDouble(in.readLine());
            l.add(db);
        }
        l.sort(Comparator.naturalOrder());

        //절사 양 끝 k개 제외
        double sum = 0.0;
        for(int i = k; i < n - k; i++) sum += l.get(i);
        sum /= (n-2*k);
        out.printf("%.2f\n", sum);

        sum = 0.0;
        //보정
        for(int i = k; i < n-k; i++){
            if(i == k || i == n - k - 1){
                for(int j = 0; j <= k; j++){
                    sum += l.get(i);
                }
            } else {
                sum += l.get(i);
            }
        }
        sum /= n;
        out.printf("%.2f\n", sum);

        out.flush();
        out.close();
    }
}