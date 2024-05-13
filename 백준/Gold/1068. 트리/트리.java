import java.io.*;
import java.util.*;

public class Main{
    static int n, root, delete;
    static List<Integer>[] tree;
    static int go(int now){
        if(now == delete) return 0;
        int ret = 0;
        int child = 0;
        for(int next : tree[now]){
            if(next == delete) continue;
            ret += go(next);
            child++;
        }
        if(child == 0) return 1;
        return ret;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tree = new List[n + 4];
        for(int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1){
                root = i; continue;
            }
            tree[temp].add(i);
        }

        st = new StringTokenizer(br.readLine());
        delete = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(go(root))+'\n');
        bw.flush();
    }
}
/*
트리입력받기, 노드지우기, 리프노드 카운팅
1. 노드를 입력받는다.
2. 지울 노드를 입력받는다
3. 트리를 탐색한다.
4. 지운 노드는 건너 뛴다.
5. 리프 노드를 카운팅 한다.
*/