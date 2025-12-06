import java.io.*;
import java.util.*;
import javax.print.attribute.HashPrintServiceAttributeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++){
            arr[i] = in.readLine().toCharArray();
        }
        char[] alp = {'A', 'C', 'G', 'T'};
        var ret = new StringBuilder();
        for(int j = 0; j < m; j++){
            Map<Character, Integer> mp = new HashMap<>();//알파벳 - 빈도
            for(int i = 0; i < 4; i++){
                mp.put(alp[i], 0);
            }
            for(int i = 0; i < n; i++){
                char now = arr[i][j];
                for(char c : alp){
                    if(c == now){
                        mp.put(c, mp.get(c)+1);
                    }
                }
            }
            char c = ' ';
            int max = 0;
            for(char cc : alp){
                int now = mp.get(cc);
                if(now > max){
                    max = now;
                    c = cc;
                }
            }
            ret.append(c);
        }
        char[] retCrr = ret.toString().toCharArray();
        int retCnt = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < m; j++){
                if(arr[i][j] != retCrr[j]){
                    cnt++;
                }
            }
            retCnt += cnt;
        }
        System.out.println(ret);
        System.out.println(retCnt);
        out.flush();
        out.close();
    }
}