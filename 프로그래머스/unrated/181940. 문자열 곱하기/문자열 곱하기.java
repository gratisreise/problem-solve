import java.util.*;

class Solution {
    public String solution(String my_string, int k) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < k; i++){
            ret.append(my_string);
        }
        return ret.toString();
    }
}