import java.io.*;
import java.util.*;

public class Main{
    static int n, s, e, ret, time;
    static class Pair{
        int s, e;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        List<Pair> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            l.add(new Pair(s, e));
        }
        Collections.sort(l, (a, b)-> {
            if(a.e == b.e) return Integer.compare(a.s, b.s);
            return Integer.compare(a.e, b.e);
        });

        for(Pair p : l){
            if(time > p.s) continue;
            ret++;
            time = p.e;
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}