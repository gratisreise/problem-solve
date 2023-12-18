import java.util.*;
class Solution {
    public List<String> solution(String[] picture, int k) {
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < picture.length; i++){
            String temp = "";
            for(char c : picture[i].toCharArray()){
                for(int j = 0; j < k; j++){
                    temp += c;
                }
            }
            for(int j = 0; j < k; j++){
                ret.add(temp);
            }
        }
        
        return ret;
    }
}