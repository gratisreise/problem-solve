import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cnt = new int[150];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            cnt[c]++;
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 97; i <= 122; i++) {
            if (cnt[i] >= 5) {
                ret.append((char) i);
            }
        }

        if (ret.length() > 0) {
            System.out.println(ret);
        } else {
            System.out.println("PREDAJA");
        }
    }
}
