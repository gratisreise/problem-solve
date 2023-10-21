import java.util.*;

public class Main{
    public static int cnt[] = new int[26];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 97]++;
        }
        for(int i : cnt) System.out.print(i+ " ");
    }
}