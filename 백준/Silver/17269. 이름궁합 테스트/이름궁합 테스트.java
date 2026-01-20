import java.io.*;
import java.util.*;

public class Main {
    static int[] alp = new int[]{
        3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1
    };

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        char[] cr1 = st.nextToken().toCharArray();
        char[] cr2 = st.nextToken().toCharArray();
        List<Integer> start = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < n || idx2 < m){
            if(idx1 < n) start.add(alp[cr1[idx1] - 'A']);
            if(idx2 < m) start.add(alp[cr2[idx2] - 'A']);
            idx1++; idx2++;
        }

        while(true){
            var temp = new ArrayList<Integer>();
            for(int i = 0; i < start.size()-1; i++){
                int a = start.get(i);
                int b = start.get(i+1);
                temp.add((a + b) % 10);
            }
            start = temp;
            if(start.size() == 2) break;
        }

        int ret = start.get(0) * 10 + start.get(1);
        out.println(ret + "%");


        out.flush();
        out.close();
    }
}