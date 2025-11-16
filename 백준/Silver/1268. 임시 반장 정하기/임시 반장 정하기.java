import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++){
            String[] ip = in.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(ip[j]);
            }
        }

        int max = -1;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i == j) continue; // 같은번호 넘기기
                boolean flag = true; // 같은반이었으면 꺽기
                for(int k = 0; k < 5; k++){
                    if(arr[i][k] == arr[j][k]) flag = false;
                }
                if(flag) continue;
                cnt++;
            }
            nums[i] = cnt;
            max = Math.max(max, cnt);
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max) {
                System.out.println(i+1);
                return;
            }
        }

        out.flush();
        out.close();
    }
}