import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 이전 순열을 찾는 핵심 메서드
    public static boolean prevPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 1;

        // 1. 감소하는 부분 찾기 (A[i-1] > A[i]를 만족하는 가장 큰 i)
        // 뒤에서부터 탐색하여, arr[i-1] > arr[i]를 만족하는 'pivot' 지점 i를 찾습니다.
        while (i > 0 && arr[i-1] <= arr[i]) {
            i--;
        }

        // 만약 i <= 0 이면, 배열이 오름차순 정렬된 상태이므로 이전 순열은 없습니다.
        if (i <= 0) {
            return false;
        }

        // 2. 교환할 숫자 찾기 (A[i-1]보다 작으면서 가장 큰 값)
        int j = n - 1;

        // arr[i]부터 끝까지의 원소 중에서 arr[i-1]보다 작은(>) 첫 번째 원소 arr[j]를 찾습니다.
        // 13542
        while (arr[j] >= arr[i-1]) {
            j--;
        }

        // arr[i-1]과 arr[j]를 교환
        swap(arr, i-1, j);

        // 3. 뒷부분 정렬 (i부터 끝까지 내림차순으로 뒤집기)
        // arr[i]부터 끝까지를 뒤집어 (reverse) 내림차순으로 만들어,
        // 교환된 상태에서 만들 수 있는 가장 큰 순열을 완성합니다.
        int k = n - 1;
        while (i < k) {
            swap(arr, i, k);
            i++;
            k--;
        }

        return true;
    }

    // 두 원소를 교환하는 헬퍼 함수
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 순열의 크기 N
        int N = Integer.parseInt(br.readLine());

        // 순열 A
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 이전 순열을 찾고 결과를 출력
        if (prevPermutation(A)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(A[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            // 이전 순열이 없다면 -1 출력
            System.out.println(-1);
        }
    }
}