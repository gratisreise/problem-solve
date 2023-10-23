import java.util.*;

public class Main {
    static int[] cnt = new int[200]; // ASCII 범위의 문자 개수를 저장하는 배열
    static char mid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder ret = new StringBuilder();

        for (char c : s.toCharArray()) cnt[c]++;
        int flag = 0;

        for (int i = 'Z'; i >= 'A'; i--) {
            if (cnt[i] % 2 != 0) {
                mid = (char) i;
                cnt[i]--; flag++;
            }

            if (flag == 2) break;
            
            for (int j = 0; j < cnt[i]; j += 2) {
                ret.insert(0, (char) i); // 문자열 앞쪽에 추가
                ret.append((char) i); // 문자열 뒷쪽에 추가
            }
        }

        if (mid != 0) ret.insert(ret.length() / 2, mid);
        if (flag == 2) System.out.println("I'm Sorry Hansoo");
        else  System.out.println(ret.toString());
    }
}
