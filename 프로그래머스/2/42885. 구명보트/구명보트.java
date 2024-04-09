import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int ret = 0;
        Arrays.sort(people);
        int s = 0, e = people.length - 1;
        int sum = people[s] + people[e];
        while(s <= e){
            if(people[s] + people[e] <= limit){
                ret++; s++; e--;
            } else {
                ret++; e--;
            }
        }
        return ret;
    }
    
}