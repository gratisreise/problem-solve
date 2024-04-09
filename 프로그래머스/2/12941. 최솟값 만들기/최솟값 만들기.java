import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        int ret = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < n; i++) {
            ret += A[i] * B[n - 1 - i];
        }        
        // System.out.println("Hello Java");
        return ret;
    }
}