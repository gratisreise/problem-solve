import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int cnt = 0;
        
        int[] a = new int[n];
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(a[i])) {
                if (v.size() == k) {
                    int lastIdx = 0;
                    int pos = 0;

                    for (int _a : v) {
                        int herePick = Integer.MAX_VALUE;

                        for (int j = i + 1; j < n; j++) {
                            if (_a == a[j]) {
                                herePick = j;
                                break;
                            }
                        }

                        if (lastIdx < herePick) {
                            lastIdx = herePick;
                            pos = _a;
                        }
                    }

                    visited.remove(pos);
                    cnt++;
                    v.remove(Integer.valueOf(pos));
                }

                v.add(a[i]);
                visited.add(a[i]);
            }
        }

        System.out.println(cnt);
    }
}
