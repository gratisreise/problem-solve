import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] ret = my_string.toLowerCase().toCharArray();
        Arrays.sort(ret);
        return new String(ret);
    }
}