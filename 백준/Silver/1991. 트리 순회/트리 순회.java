import java.util.*;

public class Main {
    static int[][] tree;

    static String preOrder(int now) {
        char c = (char) (now + 'A');
        String s = ("" + c);
        for(int next : tree[now]){
            if(next == -1) continue;
            s += preOrder(next);
        }
        return s;
    }

    static String inOrder(int now) {
        char c = (char) (now + 'A');
        String s = "";
        if (tree[now][0] != -1) s += inOrder(tree[now][0]);
        s += c;
        if (tree[now][1] != -1) s += inOrder(tree[now][1]);
        return s;
    }

    static String postOrder(int now) {
        char c = (char) (now + 'A');
        String s = "";
        if (tree[now][0] != -1) s += postOrder(tree[now][0]);
        if (tree[now][1] != -1) s += postOrder(tree[now][1]);
        s += c;
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new int[n + 4][2];
        for (int i = 0; i < n; i++) {
            int now = sc.next().charAt(0) - 'A';
            for (int j = 0; j < 2; j++) {
                char c = sc.next().charAt(0);
                if (c == '.') {
                    tree[now][j] = -1;
                    continue;
                }
                tree[now][j] = c - 'A';
            }
        }
        System.out.println(preOrder(0));
        System.out.println(inOrder(0));
        System.out.println(postOrder(0));
    }
}