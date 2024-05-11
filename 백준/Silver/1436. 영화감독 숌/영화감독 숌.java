import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int i = 666;
        for (; n != 0; i++) if (("" + i).contains("666")) n--;
        bw.write(String.valueOf(i-1) + '\n');
        bw.flush();
    }
}