import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);
        
        String s = in.readLine();
        String t = in.readLine();
        
        String sum1 = s+t;
        String sum2 = t+s;
        if(sum1.equals(sum2)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        out.flush();
        out.close();
    }
}
/*

*/