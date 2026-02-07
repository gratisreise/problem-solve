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
        for(int i = 0; i < w; i++){
            for(int l = 0; l < i; l++){
                leftMax[i] = Math.max(leftMax[i], arr[l]);
            }
            for(int r = i+1; r < w; r++){
                rightMax[i] = Math.max(rightMax[i], arr[r]);
            }
        }

        int ret = 0;
        for(int i = 0; i < w; i++){
            ret += Math.max((Math.min(leftMax[i], rightMax[i]) - arr[i]), 0);
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