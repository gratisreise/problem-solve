import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[200];
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            cnt[s.charAt(0)]++;
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 97; i < 150; i++){
            if(cnt[i] >= 5) ret.append((char)i);
        }
        if(ret.length() == 0) System.out.println("PREDAJA");
        else System.out.println(ret);
    }
}