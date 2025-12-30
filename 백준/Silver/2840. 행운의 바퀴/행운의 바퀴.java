import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] pannel = new char[n];
        Arrays.fill(pannel, '?');
        st = new StringTokenizer(in.readLine());
        int garbage = Integer.parseInt(st.nextToken());
        pannel[0] = st.nextToken().charAt(0);
        int idx = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < k-1; i++){
            st = new StringTokenizer(in.readLine());
            int move = Integer.parseInt(st.nextToken());
            move %= n;
            char c = st.nextToken().charAt(0);
            idx = (idx + n - move) % n;
            if(pannel[idx] != '?' && pannel[idx] != c){
                System.out.println("!");
                return;
            }
            if(pannel[idx] == '?' && set.contains(c)){
                System.out.println("!");
                return;
            }
            pannel[idx] = c;
            set.add(c);
        }
        var ret =  new StringBuilder();
        for(int i = 0; i < n; i++){
            ret.append(pannel[(idx+i)%n]);
        }

        System.out.println(ret);
        out.flush();
        out.close();
    }
}
/*
N[2, 25], K[1, 100]
행운바퀴:
결정못하느부분: ?
없으면: !
아예 없는 경우
자기자신으로 안돌아오거나 위치가 꼬여 있는 경우 => 이거 말고 다른 경우가 있나??

0 1 2 3
1 2 3 4
주기성 역방향 움직임 어떻게 표현
1번, 2번, 3번, 4번
-1: 3
-2: 2
-3: 1
-4: 0
1
2
3
4
*/