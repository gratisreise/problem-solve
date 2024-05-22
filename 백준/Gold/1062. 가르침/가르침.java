import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] words;
    static String s;

    static int count(int mask) {
        int cnt = 0;
        for (int word : words) {
            if (word != 0 && ((word & mask) == word)) {
                cnt++;
            }
        }
        return cnt;
    }
    static boolean skip(int n){
        return n == 'a' - 'a' || n == 'n' - 'a' || n == 't' - 'a' || n == 'i' - 'a' || n == 'c' - 'a';
    }
    

    static int go(int idx, int k, int mask) {
        if (k < 0) return 0;
        if (idx == 26) return count(mask);

        int ret = go(idx + 1, k - 1, mask | (1 << idx));
        if (!skip(idx)) ret = Math.max(ret, go(idx + 1, k, mask));

        return ret;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());;
        k = Integer.parseInt(st.nextToken());;

        words = new int[51];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        bw.write(String.valueOf(go(0, k, 0))+'\n');
        bw.flush();
    }
}
/*
<최대를 어떻게 구하는지 아이디어를 모르겠다.>
*/
