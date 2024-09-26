import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder ret = new StringBuilder();
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 'a'; i <= 'z'; i++) mp.put((char)i, 0);
        for(int i = 'A'; i <= 'Z'; i++) mp.put((char)i, 0);
        mp.put(' ', 0);
        for(char c : my_string.toCharArray()){
            if(mp.get(c) == 1) continue;
            ret.append(c);
            mp.put(c, 1);
        }
        return ret.toString();
    }
}