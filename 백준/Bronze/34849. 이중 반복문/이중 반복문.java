import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int bound = 10000;
        if(n <= bound){
            out.println("Accepted\n");
        } else {
            out.println("Time limit exceeded\n");
        }

        out.flush();
        out.close();
    }
}
/*

*/