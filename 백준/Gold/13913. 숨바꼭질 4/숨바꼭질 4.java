import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main{
    static int n, k, max = 200004;
    static int[] visited = new int[max];
    static int[] prev = new int[max];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : new int[]{now - 1, now + 1, now * 2}){
                if(next < 0 || next >= max) continue;
                if(visited[next] != 0) continue;
                visited[next] = visited[now] + 1;
                prev[next] = now;
                q.add(next);
            }
        }

        Stack<Integer> stk = new Stack<>();
        for(int i = k; i != n; i = prev[i]) stk.push(i);
        stk.add(n);
        bw.write(String.valueOf(visited[k] - 1)+'\n');
        while(!stk.isEmpty()) bw.write(stk.pop() + " ");
        bw.write("\n");
        bw.flush();
    }
}