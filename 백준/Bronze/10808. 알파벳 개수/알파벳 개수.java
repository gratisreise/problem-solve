import java.io.*;
import java.util.*;

public class Main{
    static int[] cnt = new int[200];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String rs;
        StringTokenizer st;
        rs = br.readLine();
        for(char c : rs.toCharArray()) cnt[c]++;
        for(int i = 'a'; i <= 'z'; i++){
            bw.write(String.valueOf(cnt[i]) + " ");
        }
        bw.write('\n');
        bw.flush();
    }
}

/*
1. 문자열을 입력받는다.
2. 문자열을 순회하면서 cnt배열에 ++해준다.
3. 'a' ~ 'z' 까지 cnt배열을 순회하면서 숫자를 출력한다. 
 */