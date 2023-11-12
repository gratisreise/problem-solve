import java.util.*;

public class Main{
    static int[] cnt = new int[26];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        for(int i : cnt) System.out.print(i + " ");
    }
}