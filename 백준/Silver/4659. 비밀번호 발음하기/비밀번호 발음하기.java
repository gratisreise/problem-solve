import java.util.*;

public class Main{
    static boolean check(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.next();
            if(s.equals("end")) break;
            int jcnt = 0, mcnt = 0, cnt = 0;
            boolean flag = false;
            char prev = '1';
            for(char c : s.toCharArray()){
                if(check(c)){ jcnt = 0; mcnt++; cnt = 1;}
                else{jcnt++; mcnt = 0;}
                if(jcnt == 3 || mcnt == 3) flag = true;
                if(prev != '1' && c == prev && (c != 'e' && c!= 'o')) flag = true;
                prev = c;
            }
            if(cnt == 0) flag = true;
            if(flag) System.out.println("<" + s + "> is not acceptable.");
            else System.out.println("<" + s + "> is acceptable.");
        }
    }
}