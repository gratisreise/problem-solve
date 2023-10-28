import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] segments = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            segments[i] = new Pair(from, to);
        }

        Arrays.sort(segments);

        int l = segments[0].first;
        int r = segments[0].second;
        long ret = 0;

        for (int i = 1; i < n; i++) {
            if (r < segments[i].first) {
                ret += r - l;
                l = segments[i].first;
                r = segments[i].second;
            } else if (segments[i].first <= r && segments[i].second >= r) {
                r = segments[i].second;
            }
        }

        ret += r - l;
        System.out.println(ret);
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.first == other.first) {
                return Integer.compare(this.second, other.second);
            }
            return Integer.compare(this.first, other.first);
        }
    }
}
