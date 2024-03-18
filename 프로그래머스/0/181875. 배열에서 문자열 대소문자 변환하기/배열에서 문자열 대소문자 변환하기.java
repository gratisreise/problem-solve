import java.util.*;
class Solution {
    public List<String> solution(String[] strArr) {
         List<String> ret = new ArrayList<>();
        for(int i = 0; i < strArr.length; i++){
            if(i % 2 == 0) ret.add(strArr[i].toLowerCase());
            else ret.add(strArr[i].toUpperCase());
        }
        return ret;
    }
}