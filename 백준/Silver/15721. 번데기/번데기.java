import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int t = Integer.parseInt(in.readLine());
        int target = Integer.parseInt(in.readLine());
        Map<Integer, Set<Integer>>[] mpr = new Map[n];
        for(int i = 0; i < n; i++) {
            mpr[i] = new HashMap<>();
            mpr[i].put(0, new HashSet<>());
            mpr[i].put(1, new HashSet<>());
        }
        int temp = 1;
        int idx = 0;
        int cntb = 1;
        int cntd = 1;

        while(true){
            int num = 4;
            boolean flag = true;

            // 뻔-데기-뻔-데기
            while(num-- > 0){
                if(flag) {
                    mpr[idx].get(0).add(cntb);
                    cntb++;
                } else {
                    mpr[idx].get(1).add(cntd);
                    cntd++;
                }
                flag = !flag;
                idx = (idx+1)%n;
            }
            //뻔 n+1번
            for(int i = 0; i < temp + 1; i++){
                mpr[idx].get(0).add(cntb);
                cntb++; idx = (idx+1)%n;
            }

            //데기 n+1번
            for(int i = 0; i < temp + 1; i++){
                mpr[idx].get(1).add(cntd);
                cntd++; idx = (idx+1)%n;
            }
            if(cntb >= t && cntd >= t) break;
            temp++;
        }

        int ret = -1;
        for(int i = 0; i < n; i++){
            if (target == 0 && mpr[i].get(0).contains(t)) {
                ret = i;
                break;
            } else if(target == 1 && mpr[i].get(1).contains(t)){
                ret = i;
                break;
            }
        }

        out.println(ret);

        out.flush();
        out.close();
    }
}