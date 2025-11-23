import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String line;

        while((line = in.readLine()) != null){
            if(line.isEmpty()) continue;

            int n = Integer.parseInt(line);

            int cnt = 1;
            int temp = 1;

            while((temp % n) != 0){
                temp = (temp*10 + 1) % n;
                cnt++;
            }
            out.println(cnt);
        }

        out.flush();
        out.close();
        in.close();
    }
}