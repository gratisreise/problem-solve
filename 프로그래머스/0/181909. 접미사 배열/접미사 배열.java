import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string).reverse();
        char[] spells = sb.toString().toCharArray();
        String[] psum = new String[spells.length];
        String temp = "";
        for(int i = 0; i < psum.length; i++){
            StringBuilder builder = new StringBuilder();
            if(i == 0) psum[i] = temp + spells[i];
            else psum[i] = spells[i] + psum[i - 1];
        }
        Arrays.sort(psum);
        return psum;
    }
}