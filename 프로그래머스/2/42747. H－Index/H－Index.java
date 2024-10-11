import java.util.*;
class Solution {
    private boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        return citations[index] >= h;
    }
    
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int h = citations.length; h >= 1; h--){
            if(isValid(citations, h)) return h;
        }
        return 0;
    }
}
/*
1 2 3 4 5

5 4 3 2 1

*/