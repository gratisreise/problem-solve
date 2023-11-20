import java.util.*;

public class Main{
    static long go(long a, long b, long c){
        if(b == 1) return a % c;
        long ret = go(a, b/2, c);
        ret = (ret * ret) % c;
        if(b % 2 != 0) ret = (ret * a) % c;
        return ret;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        System.out.println(go(a, b, c));
    }
}