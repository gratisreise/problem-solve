import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            mp.put(s, i);
        }

        int[] order = new int[n];
        for(int i = 0; i < n; i++){
            String s = in.readLine();
            order[i] = mp.get(s);
        }

        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(order[i] > order[j]){
                    ret++;
                    break;
                }
            }
        }
        System.out.println(ret);



        out.flush();
        out.close();
    }
}