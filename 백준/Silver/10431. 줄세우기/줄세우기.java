import java.io.*;
import java.util.*;

public class Main {
    static void stepBack(int k, int idx, int[] arr){

        int now = idx;
        int temp = arr[idx];
        while(now > k){
            arr[now] = arr[now-1];
            now--;
        }
        arr[k] = temp;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());


        for(int i = 0; i < t; i++){
            var st = new StringTokenizer(in.readLine());
            int te = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for(int j = 0; j < 20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int ret = 0;
            while(true){
                int cnt = 0;
                for(int j = 0; j < 20; j++){
                    boolean flag = false;
                    for(int k = 0; k < j; k++){
                        if(arr[k] > arr[j]){
                            stepBack(k, j, arr);
                            ret += (j-k);
                            cnt++;
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
                if(cnt == 0) break;
            }
            out.println(te + " " + ret);
        }


        out.flush();
        out.close();
    }
}