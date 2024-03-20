import java.util.*;
class Solution {
    public long solution(long n) {
        String s = "" + n;
        int[] arr = new int[s.length()];
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i) - '0';
        }
        Arrays.sort(arr);
        s = "";
        for(int i = arr.length-1; i >= 0; i--){
                s += ("" + arr[i]);
        }
        long ret = Long.parseLong(s);
        
        
        
        return ret;
    }
}