import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ret = 0;
        while(n > 0) {
            if (n % 2 == 1) ret++;
            n /= 2;
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}