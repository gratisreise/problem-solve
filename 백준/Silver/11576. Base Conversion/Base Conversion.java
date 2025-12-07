import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < m; i++){
            l.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(l);

        int num10 = aToTen(l, a);
        String ret = tenToB(num10, b);

        System.out.println(ret);

        out.flush();
        out.close();
    }

    private static String tenToB(int num10, int b) {
        Stack<Integer> stk = new Stack<>();
        while(num10 > 0){
            int now = num10 % b;
            num10 /= b;
            stk.add(now);
        }

        StringBuilder ret = new StringBuilder();
        while(!stk.isEmpty()){
            ret.append(stk.pop());
            ret.append(" ");
        }

        return ret.toString().trim();
    }

    private static int aToTen(List<Integer> l, int a) {
        int tempA = 1;
        int ret =  0;
        for(int i : l){
            ret += (i * tempA);
            tempA *= a;
        }
        return ret;
    }
}