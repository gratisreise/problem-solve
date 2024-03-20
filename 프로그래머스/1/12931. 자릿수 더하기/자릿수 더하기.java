import java.util.*;

public class Solution {
    public int solution(int n) {
        int ret = 0;

        String num = ""+n;
        for(char c : num.toCharArray()){
            ret += (c - '0');
        }
        
        return ret;
    }
}