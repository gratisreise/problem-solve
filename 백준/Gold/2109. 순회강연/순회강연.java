import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = 0;
        ArrayList<Pair> v = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int d = scanner.nextInt();
            v.add(new Pair(d, p));
        }

        Collections.sort(v);
        for (int i = 0; i < n; i++) {
            ret += v.get(i).second;
            pq.add(v.get(i).second);
            while (pq.size() > v.get(i).first) {
                ret -= pq.poll();
            }
        }

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
            return Integer.compare(this.first, other.first);
        }
    }
}
