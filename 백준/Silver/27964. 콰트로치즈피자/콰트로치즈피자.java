import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        String[] srr = in.readLine().split(" ");
        Set<String> set = new HashSet<>();
        for(String s : srr){
            if(s.endsWith("Cheese")) set.add(s);
        }

        if(set.size() >= 4){
            out.println("yummy");
        } else {
            out.println("sad");
        }

        out.flush();
        out.close();
    }
}