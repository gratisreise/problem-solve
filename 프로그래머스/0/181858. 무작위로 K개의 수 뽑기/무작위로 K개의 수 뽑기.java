import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] cnt = new int[100004];
        int[] ret = new int[k];
        Arrays.fill(ret, -1);
        int j = 0;
        for(int i : arr){
            if(cnt[i] != 0) continue;
            ret[j++] = i;
            cnt[i] = 1;
            if(ret[k-1] != -1) break;
        }
        return ret;
    }
}