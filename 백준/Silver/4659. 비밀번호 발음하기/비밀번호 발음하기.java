import java.util.Scanner;

public class Main {
    static boolean check(char a) {
        return (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("end")) break;

            boolean flag = false;
            int cnt = 0, mcnt = 0, jcnt = 0;
            char prev = '1';

            for (char a : s.toCharArray()) {
                if (check(a)){cnt++; mcnt++; jcnt = 0;}
                else {jcnt++; mcnt = 0;}
                if (mcnt == 3 || jcnt == 3) flag = true;
                if (prev != '1' && a == prev && a != 'e' && a != 'o') {
                    flag = true;
                }
                prev = a;
            }
            if (cnt == 0) flag = true;
            if (flag) System.out.println("<" + s + "> is not acceptable.");
            else  System.out.println("<" + s + "> is acceptable.");
        }
    }    
}
