import java.util.*;
class Solution {
    public List<String> solution(String my_string) {
        List<String> ret = new ArrayList<>();
        String temp = "";
        for(int i = my_string.length() - 1; i >= 0; i--){
            temp = my_string.charAt(i) + temp;
            ret.add(temp);
        }
        Collections.sort(ret);
        return ret;
    }
}