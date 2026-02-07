import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < w; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];
        
        leftMax[0] = arr[0];
        for(int i = 1; i < w; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        
        rightMax[w-1] = arr[w-1];
        for(int i = w-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }

        int ret = 0;
        for(int i = 0; i < w; i++){
            int now = (Math.min(leftMax[i], rightMax[i]) - arr[i]);
            ret += Math.max(now , 0);
        }
        out.println(ret);


        out.flush();
        out.close();
    }
}
/*
leftMax[], rightMax[]배열을 만들어서
왼쪽과 오른쪽끝의 최대를 비교해서 최소값에서 - 나의 현재높이



*/