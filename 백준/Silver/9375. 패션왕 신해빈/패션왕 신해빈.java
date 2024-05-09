import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> mp = new HashMap<>();

            while(n-- > 0){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!mp.containsKey(b)) mp.put(b, 1);
                else mp.put(b, mp.get(b) + 1);
            }

            long ret = 1;

            for(String key : mp.keySet()){
                ret *= (mp.get(key) + 1);
            }
            ret--;
            
            bw.write(String.valueOf(ret)+'\n');
        }
        bw.flush();
    }
}
/*
의상 종류 중복불가 -> 의상의 종류마다++하고 안입는 경우까지 넣어주기
-> 알몸은 모든 종류의 옷이 안입는 경우가 있을 때 -> 종류마다 곱하고 나중에 -1해주면 경우의 수
1. tc t 입력받기
2. t반복: 의상의 수 n 입력받기
    2-1.의상 이름 : 종류 입력받기
    2-2.종류별 숫자 저장 이름 => 숫자 Map
3. Map을 순회하면서 곱해주기
4. ret에 -1을 하고 출력
 */