import java.util.*;
class Solution {
    public String solution(String myString, String pat) {
        String[] psum = new String[myString.length() + 1];
        char[] arr = myString.toCharArray();
        psum[0] = "";
        for(int i = 1; i <= myString.length(); i++){
            psum[i] = psum[i - 1] + arr[i-1];
        }
        String ret = "";
        for(int i = 1; i <= myString.length(); i++){
            if(psum[i].endsWith(pat)) ret = psum[i];
        }
        return ret;
    }
}