import java.io.*;
import java.util.*;

public class Main{
    static int k;
    static int[] cnt;
    static List<Integer>[] tree;
    static void input(int l, int r, int n){
        if(n == k) return;
        int mid = (l + r) / 2;
        tree[n].add(cnt[mid]);
        input(l, mid - 1, n + 1);
        input(mid + 1, r, n + 1);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int end = (int)Math.pow(2, k) - 1;
        tree = new List[k + 1];
        for(int i = 0; i < k; i++) tree[i] = new ArrayList<>();
        cnt = new int[end];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < end; i++){
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        input(0, end, 0);;
        for(int i = 0; i < k; i++){
            for(int j : tree[i]) bw.write(String.valueOf(j)+' ');
            bw.write('\n');
        }
        bw.flush();
    }
}