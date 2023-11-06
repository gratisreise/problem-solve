import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                if(s.charAt(i) + 13 > 'z'){
                    ret.append((char)(s.charAt(i) - 13));
                } else {
                    ret.append((char)(s.charAt(i) + 13));
                }
            } else if('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
                if(s.charAt(i) + 13 > 'Z'){
                    ret.append((char)(s.charAt(i) - 13));
                } else {
                    ret.append((char)(s.charAt(i) + 13));
                }
            } else ret.append(s.charAt(i));
        }
        System.out.println(ret);
    }
}