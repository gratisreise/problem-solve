import java.util.*;

public class Solution {
    public int solution(int n) {
        int ret = 0;
        String s = String.valueOf(n);
        for(char c : s.toCharArray()){
            ret += (c - '0');
        }
        return ret;
    }
}