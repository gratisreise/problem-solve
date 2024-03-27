import java.util.*;
class Solution {
    public String solution(String s) {
        String ret = "";
        String[] temp = s.split(" ");
        int[] temp1 = new int[temp.length];
        for(int i = 0; i < temp.length; i++){
            temp1[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(temp1);
        ret += "" + temp1[0];
        ret += " ";
        ret += "" + temp1[temp1.length - 1];
        return ret;
    }
}