import java.util.*;
class Solution {
    public List<String> solution(String[] picture, int k) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < picture.length; i++){
            String s = "";
            int cnt = k;
            for(char c : picture[i].toCharArray()){
                for(int j = 0; j < k; j++) s += c;
            }
            while(cnt-- > 0) ret.add(s);
        }
        return ret;
    }
}