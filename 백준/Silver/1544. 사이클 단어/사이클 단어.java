import java.io.*;
import java.util.*;

public class Main {
    static boolean check(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] crr1 = s1.toCharArray();
        char[] crr2 = s2.toCharArray();
        if(!check(crr1, crr2)) return false;

        for(int i = 0; i < crr1.length; i++){
            if(isEqual(crr1, crr2, i)) return true;
        }
        return false;
    }
    static boolean isEqual(char[] crr1, char[] crr2, int k){
        for(int i = 0; i < crr1.length; i++){
            if(crr1[i] != crr2[(i+k)%crr1.length]) return false;
        }
        return true;
    }
    static boolean check(char[] crr1, char[] crr2){
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0; i < crr1.length; i++){
            cnt1[crr1[i] -'a']++;
            cnt2[crr2[i]-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        List<String> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            l.add(in.readLine());
        }

        Set<Integer> st = new HashSet<>();
        int ret =0;
        for(int i = 0; i < n; i++){
            if(st.contains(i)) continue;
            st.add(i);
            ret++;
            for(int j = 0; j < n; j++){
                if(st.contains(j)) continue;
                if(check(l.get(i), l.get(j))){
                    st.add(j);
                }
            }
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}