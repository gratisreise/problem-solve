import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int ret = 0;
        if(str1.contains(str2)) ret = 1;
        else ret = 2;
        return ret;
    }
}