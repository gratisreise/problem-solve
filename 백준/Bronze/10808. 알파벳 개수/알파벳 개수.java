import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);


        int[] cnt = new int[26];


        String s = in.readLine();
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        for(int i : cnt){
            out.print(i+" ");
        }


        out.flush();
        out.close();
    }
}
/*

*/