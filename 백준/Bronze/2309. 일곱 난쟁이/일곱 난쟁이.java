import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = 9;
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(in.readLine());
            arr[i] = num;
            sum += num;
        }
        int a =-1, b = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(sum - arr[i] - arr[j] == 100){
                    a = i; b = j;
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i == a || i == b) continue;
            l.add(arr[i]);
        }
        l.sort((a1,a2) -> a1 -a2);
        for(int i : l){
            out.println(i);
        }

        out.flush();
        out.close();
    }
}
/*
키합 100, 2명 임포스터 전체에서 2명의 경우를 조합으로 구하고 빼서 확인
오름차순 출력
*/