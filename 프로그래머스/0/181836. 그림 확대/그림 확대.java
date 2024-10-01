import java.util.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        String[] ret = new String[picture.length * k];
        for(int i = 0; i < ret.length;){
            StringBuilder sb = new StringBuilder();
            for(char c : picture[i / k].toCharArray()){
                for(int j = 0; j < k; j++) sb.append(c);
            }
            for(int j = 0; j < k; j++){
                ret[i++] = sb.toString();
            }
        }
        return ret;
    }
}