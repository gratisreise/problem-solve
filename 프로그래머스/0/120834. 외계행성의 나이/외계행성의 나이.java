import java.util.*;
class Solution {
    
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        char[] idxNumber = new char[10];
        for(int i = 0; i < 10; i++) idxNumber[i] = (char)(i + 'a');
        for(char c : String.valueOf(age).toCharArray()){
            for(int i = 0; i < 10; i++) if(c-'0' == i) sb.append(idxNumber[i]);
        }
        return sb.toString();
    }
}