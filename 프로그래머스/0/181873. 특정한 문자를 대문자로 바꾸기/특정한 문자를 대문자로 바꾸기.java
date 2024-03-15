import java.util.*;
class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            if((my_string.charAt(i)+"").equals(alp)){
                String temp = alp;
                answer += temp.toUpperCase();   
            } else answer += my_string.charAt(i);
        }
        return answer;
    }
}