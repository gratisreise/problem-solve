import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
     static class Pair {
        public final long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Pair inter(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Pair((long) x, (long) y);
    }

    private Pair getMin(List<Pair> pairs) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Pair p : pairs) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Pair(x, y);
    }

    private Pair getMax(List<Pair> pairs) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Pair p : pairs) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Pair(x, y);
    }

    public String[] solution(int[][] line) {
        List<Pair> lp = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < i; j++) {
                Pair intersection = inter(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    lp.add(intersection);
                }
            }
        }

        Pair min = getMin(lp);
        Pair max = getMax(lp);

        int col = (int) (max.x - min.x + 1);
        int row = (int) (max.y - min.y + 1);

        char[][] arr = new char[row][col];
        for (char[] r : arr) {
            Arrays.fill(r, '.');
        }

        for (Pair p : lp) {
            int x = (int) (p.x - min.x);
            int y = (int) (max.y - p.y);
            arr[y][x] = '*';
        }

        String[] ret = new String[arr.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = new String(arr[i]);
        }
        return ret;
    }
}
