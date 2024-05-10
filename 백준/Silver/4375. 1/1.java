import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s;

        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int cnt = 1;
            int ret = 1;
            while (true) {
                if (cnt % n == 0) {
                    bw.write(String.valueOf(ret)+'\n');
                    bw.flush();
                    break;
                } else {
                    cnt = cnt * 10 + 1;
                    cnt %= n;
                    ret++;
                }
            }
        }

        br.close();
    }
}
