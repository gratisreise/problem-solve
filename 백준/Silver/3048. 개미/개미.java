import java.io.*;
import java.util.*;

public class Main {
    static int[] dir = {1, -1};
    static String n1, n2;
    static String jump(String now){
        int len = now.length();
        char[] crr = now.toCharArray();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < len; i++){
            char c = crr[i];
            if(isExists(n1, c) && i < len-1 && isExists(n2, crr[i+1])){
                ans.append(crr[i+1]).append(c);
                i++;
            }else if(isExists(n2, c) && i > 0 && isExists(n1, crr[i-1])){
                ans.append(c).append(crr[i-1]);
                i++;
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
    static boolean isExists(String s, char c){
        for(char cc : s.toCharArray()) if(cc == c) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        n1 = in.readLine();
        n2 = in.readLine();
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; i--){
            sb.append(n1.charAt(i));
        }
        sb.append(n2);
        String ret = sb.toString();
        for(int i = 0; i < t; i++){
            ret = jump(ret);
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}