import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 97){
                ret += (char)(s.charAt(i) - 32);
            } else {
                ret += (char)(s.charAt(i) + 32);
            }
        }
        System.out.println(ret);

    }
}