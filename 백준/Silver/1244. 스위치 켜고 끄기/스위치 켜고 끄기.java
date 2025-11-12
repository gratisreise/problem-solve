import java.io.*;
import java.util.*;

public class Main {

    static void boy(int num, boolean[] stch){
        for(int i = num; i < stch.length; i += (num+1)){
            stch[i] = !stch[i];
        }
    }

    static void girl(int num, boolean[] stch){
        int l = num - 1;
        int r = num + 1;
        stch[num] = !stch[num];
        while(l>=0 && r < stch.length){
            if(stch[l] == stch[r]){
                stch[l] = !stch[l];
                stch[r] = !stch[r];
            } else break;
            l--;
            r++;
        }
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        String[] arr = in.readLine().split(" ");
        boolean[] stch = new boolean[n];

        for(int i = 0; i < n; i++){
            if(arr[i].charAt(0) == '0'){
                stch[i] = false;
            } else stch[i] = true;
        }

        int k = Integer.parseInt(in.readLine());

        for(int i = 0; i < k; i++){
            var st = new StringTokenizer(in.readLine());
            int g = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(g == 1) boy(num-1, stch);
            else girl(num-1, stch);
        }


        int idx = 0;
        var ret = new StringBuilder();
        while(idx < n){
            if(stch[idx]) ret.append("1 ");
            else ret.append("0 ");
            idx++;
            if(idx % 20 == 0) ret.append("\n");
        }
        System.out.println(ret);

        out.flush();
        out.close();
    }
}
/*

스위치 8개
1켜짐 0꺼짐
1~8 숫자 배분
남자:받은숫자 = 스위치번호 * n 이면 변경
여자:양쪽뻗어나가면서 숫자 같은범위의 숫자를 변경
입력순으로 변경

3
1 1 1
2
1 2
2 3
2 1
*/