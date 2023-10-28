import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Pair> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            v.add(new Pair(a, b));
        }

        Collections.sort(v);

        int time = v.get(0).first + v.get(0).second;

        for (int i = 1; i < n; i++) {
            if (time > v.get(i).first) {
                time += v.get(i).second;
            } else {
                time = v.get(i).first + v.get(i).second;
            }
        }

        System.out.println(time);
    }
}

class Pair implements Comparable<Pair> {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.first, other.first);
    }
}
