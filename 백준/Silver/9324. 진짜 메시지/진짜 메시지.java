import java.io.*;
import java.util.*;

public class Main {
    static boolean check(String s){
        int len = s.length();
        int[] cnt = new int[26];
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            cnt[c - 'A']++;
            if(cnt[c-'A'] % 3 == 0){
                if(i == len - 1 || s.charAt(i + 1) != c) return false;
                else i++;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++){
            String s = in.readLine();
            if(check(s)) out.println("OK");
            else out.println("FAKE");
        }

        out.flush();
        out.close();
    }
}
/*
100 * 10만 천만
각 문자가 3번 째 등장할 때 한번 더 추가
가짜 메세지는 3번째에 새로운 문자추가가 없다는것

1. 테스트 케이스 입력받기
2. 문자열의 문자를 순회하면서 3번째 추가 있는지 확인
 2-1. 맞으면 OK
 2-2. 틀리면 FAKE


*/