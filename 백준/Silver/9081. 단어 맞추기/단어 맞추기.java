import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int T = Integer.parseInt(in.readLine());


        while (T-- > 0) {
            String word = in.readLine();
            char[] chars = word.toCharArray();
            if (nextPermutation(chars)) {
                out.println(new String(chars));
            } else {
                out.println(word); // 다음 순열이 없으면 그대로 출력
            }
        }
        out.flush();
        out.close();
    }

    private static boolean nextPermutation(char[] arr) {
        // 1. 뒤에서부터 꺾이는 지점 i-1 찾기
        int i = arr.length - 1;
        while(i > 0 && arr[i-1] >= arr[i]) i--;

        if (i <= 0) return false; // 마지막 순열인 경우

        // 2. arr[i-1]보다 큰 값을 뒤에서부터 찾기
        int j = arr.length - 1;
        while(arr[j] <= arr[i - 1]) j--;

        // 3. i-1과 j 교체
        swap(arr, i - 1, j);

        // 4. i 지점부터 끝까지 오름차순 정렬 (Reverse)
        int k = arr.length - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    private static void swap(char[] arr, int a, int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}