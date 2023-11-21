import java.util.*;

public class Main{
    static int jcnt, mcnt, cnt;
    static boolean check(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.next();
            if(s.equals("end")) break;
            boolean flag = false;
            jcnt = mcnt = cnt = 0;
            char prev = '1';
            for(char c : s.toCharArray()){
                if(check(c)){
                    mcnt++; jcnt = 0; cnt++;
                } else {
                    mcnt = 0; jcnt++;
                }
                if(jcnt == 3 || mcnt == 3) flag = true;
                if(prev == c && (c != 'e' && c != 'o')){
                    flag = true;
                }
                prev = c;
            }
            if(cnt == 0) flag = true;
            if(flag) System.out.println("<" + s +"> is not acceptable.");
            else System.out.println("<" + s + "> is acceptable.");
        }
    }
}

/** flag가 세워지는 경우
 * 모음 없을 때 -> cnt, 모음 체크
 * 자음, 모음 3개연속 -> jcnt, mcnt
 * e,o 제외 긑은 글자 연속이면  -> prev로 이전과 비교
 */