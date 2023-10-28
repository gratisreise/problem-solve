import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long ret = 0;

        List<Pair> v = new ArrayList<>();
        List<Long> vv = new ArrayList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            long M = scanner.nextLong();
            long V = scanner.nextLong();
            v.add(new Pair(M, V));
        }

        for (int i = 0; i < k; i++) {
            long C = scanner.nextLong();
            vv.add(C);
        }

        Collections.sort(v);
        Collections.sort(vv);

        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && v.get(j).first <= vv.get(i)) {
                pq.add(v.get(j).second);
                j++;
            }

            if (!pq.isEmpty()) {
                ret += pq.poll();
            }
        }

        System.out.println(ret);
    }
}

class Pair implements Comparable<Pair> {
    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair other) {
        return Long.compare(this.first, other.first);
    }
}
