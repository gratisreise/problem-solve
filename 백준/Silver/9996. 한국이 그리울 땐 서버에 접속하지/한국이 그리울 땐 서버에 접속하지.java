import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();
        int pos = s.indexOf("*");
        String prefix = s.substring(0, pos);
        String suffix = s.substring(pos + 1);

        for(int i = 0; i < n; i++){
            String now = in.readLine();
            if(now.length() < prefix.length() + suffix.length()){
                out.println("NE");
                continue;
            }
            if(now.startsWith(prefix) && now.endsWith(suffix)) {
                out.println("DA");
            } else{
                out.println("NE");
            }
        }


        out.flush();
        out.close();
    }
}