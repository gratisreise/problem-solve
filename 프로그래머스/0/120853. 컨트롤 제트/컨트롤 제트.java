import java.util.*;
class Solution {
    public int solution(String s) {
        int ret = 0;
        int prev = 0;
        String[] sArr = s.split(" ");
        // System.out.println(Arrays.toString(sArr));
        for(String ss : sArr){
            if(ss.equals("Z")) ret -= prev;
            else {
                int num = Integer.parseInt(ss);
                ret += num;
                prev = num;
            }
        }
        return ret;
    }
}