import java.util.*;

public class Main {
    static int n;
    static int[] check = new int[10]; 
    static char[] a = new char[20]; 
    static List<String> ret = new ArrayList<>(); 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 

        for (int i = 0; i < n; i++) {
            a[i] = sc.next().charAt(0);
        }

        go(0, ""); 
        Arrays.sort(ret.toArray());

        System.out.println(ret.get(ret.size() - 1));
        System.out.println(ret.get(0));
    }

    static boolean good(char x, char y, char op) {
        if ((x < y) && (op == '<')) return true;
        if ((x > y) && (op == '>')) return true;
        return false;
    }

    static void go(int idx, String num) {
        if (idx == n + 1) { 
            ret.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i] != 0) continue; 
            if ((idx == 0) || (good(num.charAt(idx - 1), (char) (i + '0'), a[idx - 1]))) {
                check[i] = 1;
                go(idx + 1, num + Integer.toString(i));
                check[i] = 0;
            }
        }
    }
}
