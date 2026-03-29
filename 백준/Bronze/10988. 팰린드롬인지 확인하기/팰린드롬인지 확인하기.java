import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String s = in.readLine();
        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) {
            out.println(1);
        } else out.println(0);


        out.flush();
        out.close();
    }
}