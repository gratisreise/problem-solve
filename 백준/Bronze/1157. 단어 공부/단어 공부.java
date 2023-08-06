import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] cnt = new int[26];
        String s = sc.next();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) <= 'Z') cnt[s.charAt(i) - 'A']++;
            else cnt[s.charAt(i) - 'a']++;
        }

        int max = -1; 
        char ch = '?';

        for(int i = 0; i < 26; i++){
            if(cnt[i] > max){
                max = cnt[i];
                ch = (char)(i + 65);
            }
            else if(cnt[i] == max){
                ch = '?';
            }
        }
        System.out.println(ch);
        
    }
}