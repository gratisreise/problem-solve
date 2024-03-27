import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int ret = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++){
            ret += A[i] * B[B.length - 1 - i];
        }

        return ret;
    }
}