import java.util.*;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] a = new int[n];
       
       // 입력 받은 n개의 정수를 배열 a에 저장
       for (int i = 0; i < n; i++) {
           a[i] = sc.nextInt();
       }
       
       int x = sc.nextInt();
       
       // 배열 a를 오름차순으로 정렬
       Arrays.sort(a);
       
       int ret = 0;
       int left = 0, right = n - 1;
       
       // 두 포인터를 사용하여 a[left] + a[right] == x인 경우를 찾음
       while (left < right) {
           int sum = a[left] + a[right];
           if (sum == x) {
               right--;
               ret++;
           } else if (sum < x) {
               left++;
           } else {
               right--;
           }
       }
       
       System.out.println(ret);
   }
}