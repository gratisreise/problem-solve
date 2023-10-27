import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        List<Pair> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            mp1.put(temp, mp1.getOrDefault(temp, 0) + 1);
            if (!mp2.containsKey(temp)) {
                mp2.put(temp, i + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mp1.entrySet()) {
            v.add(new Pair(entry.getValue(), entry.getKey()));
        }

        Collections.sort(v, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.first == b.first) {
                    return mp2.get(a.second) - mp2.get(b.second);
                }
                return b.first - a.first;
            }});

        for (Pair pair : v) {
            for (int j = 0; j < pair.first; j++) {
                System.out.print(pair.second + " ");
            }
        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
