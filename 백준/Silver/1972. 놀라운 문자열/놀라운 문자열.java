import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        while(true){
            String now = in.readLine();
            char[] word = now.toCharArray();
            boolean flag = false;
            if(word[0] == '*') break;
            for(int i = 0; i < word.length-1; i++){
                Set<String> set = new HashSet<>();
                for(int j = 0; j < word.length - i-1; j++){
                    var hap = new StringBuilder()
                        .append(word[j]).append(word[j+i+1])
                        .toString();
                    if(set.contains(hap)) flag = true;
                    set.add(hap);
                }
                if(flag) break;
            }
            if(flag) out.printf("%s is NOT surprising.\n", now);
            else out.printf("%s is surprising.\n", now);
        }

        out.flush();
        out.close();
    }
}