import java.util.*;
class Solution {
    int ret;
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations.length - i <= citations[i] ) {
                ret = citations.length - i;
                break;
            }
        }
        return ret;
    }
}