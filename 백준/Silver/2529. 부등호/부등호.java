import java.util.*;

public class Main {
    static int n;
    static List<String> ret = new ArrayList<>();
    static int[] cnt = new int[10];
    static char[] oper = new char[10];
    static boolean good(char a, char b, char op){
        if((a > b) && (op == '>')) return true;
        if((a < b) && (op == '<')) return true;
        return false;
    }
    static void go(int idx, String num){
        if(idx == n + 1){
            ret.add(num);
            return;
        }
        for(int i = 0; i <= 9; i++){
            if(cnt[i] != 0) continue;
            if((idx == 0) || good(num.charAt(idx - 1), (char)(i + '0'), oper[idx-1])){
                cnt[i] = 1;
                go(idx + 1, num + (""+i));
                cnt[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            oper[i] = sc.next().charAt(0);
        }
        go(0, "");
        System.out.println(ret.get(ret.size() - 1));
        System.out.println(ret.get(0));
    }
}