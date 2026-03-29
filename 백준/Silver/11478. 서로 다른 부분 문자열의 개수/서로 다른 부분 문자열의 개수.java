import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();
        Set<String> set = new HashSet<>();
        for(int k = 1; k <= s.length(); k++){
            for(int i = 0; i < s.length(); i++){
                if(i+k > s.length()) break;
                set.add(s.substring(i, i+k));
            }
        }
        out.println(set.size());



        out.flush();
        out.close();
    }
}