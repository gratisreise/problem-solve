import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        
        int y = Integer.parseInt(in.readLine());
        System.out.println(y - 2024);

        out.flush();
        out.close();
    }
}
/*

*/