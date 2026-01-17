import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] target = new int[n];
        for(int i = 0; i < n; i++){
            target[i] = Integer.parseInt(in.readLine());
        }

        var visited = new boolean[n];
        int cnt = 0;
        int cur = 0;
        while(true){
            if(visited[cur]){
                out.println(-1);
                break;
            }

            visited[cur] = true;

            if(cur == k){
                out.println(cnt);
                break;
            }
            
            cnt++;
            cur = target[cur];
        }


        out.flush();
        out.close();
    }
}
/*

*/