import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int ret = 0;
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length - i){
                ret = citations.length - i;
                break;
            }
        }
        
        return ret;
    }
}