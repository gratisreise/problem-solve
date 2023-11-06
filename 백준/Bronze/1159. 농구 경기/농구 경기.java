import java.util.*;
public class Main{
    static int n;
    static int[] cnt = new int[26];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder ret = new StringBuilder();
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            cnt[s.charAt(0) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt[i] >= 5) ret.append((char)(i + 'a'));
        }
        if(ret.length() > 0) System.out.println(ret);
        else System.out.println("PREDAJA");
    }
}