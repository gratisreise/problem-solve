import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        boolean des = true;
        boolean asc = true;
        String prev =  "";
        for(int i = 0; i < n; i++){
            String now = in.readLine();
            if(i != 0){
                if(prev.compareTo(now) > 0){
                    asc = false;
                } else if(prev.compareTo(now) < 0){
                    des = false;
                }
            }
            prev = now;
        }
        if(asc){
            System.out.println("INCREASING");
        } else if(des){
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }

        out.flush();
        out.close();
    }
}