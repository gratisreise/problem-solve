import java.io.*;
import java.util.*;
public class Main {
    static class Pair {
        long f;
        long s;

        public Pair(long f, long s) {
            this.f = f;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());;
        long ret = 0;
        Stack<Pair> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            long temp = Long.parseLong(br.readLine());
            long cnt = 1;

            while (!s.isEmpty() && s.peek().f <= temp) {
                ret += s.peek().s;
                if (s.peek().f == temp)
                    cnt = s.peek().s + 1;
                else cnt = 1;
                s.pop();
            }
            if (!s.isEmpty()) ret++;
            s.push(new Pair(temp, cnt));
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        br.close();
        bw.close();
    }
}