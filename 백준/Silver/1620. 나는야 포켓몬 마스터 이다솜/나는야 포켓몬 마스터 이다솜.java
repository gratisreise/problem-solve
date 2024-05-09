import java.io.*;
import java.util.*;

public class Main{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> mp1 = new HashMap<>();
        String[] arr = new String[n+ 4];
        
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            mp1.put(s, i + 1);
            arr[i + 1] = s;
        }
        
        for(int i = 0; i < m; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            if('0' <= c && c <= '9'){
                int num = Integer.parseInt(s);
                bw.write(arr[num]+'\n');
            } else bw.write(String.valueOf(mp1.get(s))+'\n');
        }
        bw.flush();
    }
}

/*
이름 => 번호  :: 맵
번호 => 이름  :: 배열, 맵

1.포켓몬 갯수 n, 문제 갯수 m 입력받기
2. n번만큼 포켓몬 이름 입력받기
    2-1. 이름 => 번호 맵에 저장
    2-2. 번호 => 이름 배열에 저장
3. m번만큼 문제입력받기
    3-1 숫자면 배열을 이용해서 출력
    3-2. 이름이면 맵을 이용해서 출력
 */