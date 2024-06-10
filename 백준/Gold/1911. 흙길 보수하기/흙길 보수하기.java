import java.io.*;
import java.util.*;
public class Main {
    static int b, n, l, idx, ret;
    static List<Pair> a = new ArrayList<>();
    static class Pair{
        int f, s ;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a.add(new Pair(s, e));
        }

        Collections.sort(a, Comparator.comparingInt(a -> a.f));

        for (int i = 0; i < n; i++) {
            Pair pair = a.get(i);
            if (pair.s < idx) continue;
            if (idx < pair.f) {
                b = (pair.s - pair.f) / l + ((pair.s - pair.f) % l == 0 ? 0 : 1);
                idx = pair.f + b * l;
            } else {
                b = (pair.s - idx) / l + ((pair.s - idx) % l == 0 ? 0 : 1);
                idx = idx + b * l;
            }
            ret += b;
        }
        
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }

}
