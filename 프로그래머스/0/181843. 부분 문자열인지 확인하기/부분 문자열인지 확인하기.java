import java.util.*;
class Solution {
    public int solution(String my_string, String target) {
        int ret = 0;
        if(my_string.contains(target)) ret = 1;
        return ret;
    }
}