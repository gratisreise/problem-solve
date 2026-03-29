import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();
        var ret = new StringBuilder();
        for(char c : s.toCharArray()){
            char now = c;
            if(Character.isUpperCase(now)){
                now = (char)(((now + 13 - 'A') %26) +'A');
            } else if(Character.isLowerCase(now)){
                now = (char)(((now + 13 - 'a') %26) +'a');
            }
            ret.append(now);
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}