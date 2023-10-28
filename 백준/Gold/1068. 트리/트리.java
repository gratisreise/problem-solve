import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    static int n, root, temp, del;
    static List<Integer>[] tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            temp = scanner.nextInt();
            if (temp == -1) {
                root = i;
            } else {
                tree[temp].add(i);
            }
        }

        del = scanner.nextInt();
        if (del == root) {
            System.out.println(0);
        } else {
            int result = go(root);
            System.out.println(result);
        }
    }

    static int go(int now) {
        int ret = 0;
        int child = 0;
        for (int next : tree[now]) {
            if (next == del) continue;
            ret += go(next);
            child++;
        }
        if (child == 0) return 1;
        return ret;
    }
}
