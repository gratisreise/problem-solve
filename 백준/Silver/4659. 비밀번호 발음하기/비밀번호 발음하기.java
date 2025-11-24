import java.io.*;
import java.util.*;

public class Main {
    static boolean isMo(char c){
        return c == 'a' || c== 'i' || c =='o' || c == 'e' || c == 'u';
    }
    static boolean check(String s){
        char[] crr = s.toCharArray();
        boolean flag1 = false; //모음존재체크
        boolean flag2 = true;//자모음3개연속 체크
        boolean flag3 = true; // 같은글자연속체크
        int cntJ = 0, cntM= 0;
        char prev =  ' ' ;

        for(char c : crr){
            if(c == prev && (c != 'e' && c != 'o')) flag3 = false;
            if(isMo(c)){
                cntM++; cntJ = 0; flag1 = true;
            } else {
                cntJ++; cntM = 0;
            }
            if(cntM >= 3 || cntJ >= 3) flag2 = false;
            prev = c;
        }

        return flag1 && flag2 && flag3;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        while(true){
            String s = in.readLine();
            if(s.equals("end")) break;
            if(check(s)){
                out.printf("<%s> is acceptable.\n", s);
            } else {
                out.printf("<%s> is not acceptable.\n", s);
            }
        }


        out.flush();
        out.close();
    }
}