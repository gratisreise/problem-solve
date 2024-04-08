import java.util.*;
class Solution {
    static int n;
    public String solution(String a, String b) {
        String ret = "";
        Stack<Character> stka = new Stack<>();
        Stack<Character> stkb = new Stack<>();
        n = (a.length() > b.length()) ? b.length() : a.length();
        for(char c : a.toCharArray()) stka.push(c);
        for(char c : b.toCharArray()) stkb.push(c);
        int prev = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            int aa = stka.pop() - '0';
            int bb = stkb.pop() - '0';
            sum = aa + bb;
            if(prev == 1) {
                sum++;
                prev = 0;
            }
            if(sum > 9){
                prev = 1;
                sum -= 10;
            }
            ret = (""+sum ) + ret;
        }
            while(stka.isEmpty() && !stkb.isEmpty()){
                int sum = 0;
                sum = stkb.pop() - '0';
                if(prev == 1) {
                    prev = 0;
                    sum++;
                }
                if(sum > 9) {
                    sum -= 10;
                    prev = 1;
                }
                ret = ("" + sum) + ret;
            }
            while(stkb.isEmpty() && !stka.isEmpty()){
                int sum = 0;
                sum = stka.pop() - '0';
                if(prev == 1) {
                    prev = 0;
                    sum++;
                }
                if(sum > 9) {
                    sum -= 10;
                    prev = 1;
                }
                ret = ("" + sum) + ret;
            }
        if(stka.isEmpty() && stkb.isEmpty()){
            if(prev == 1) ret = "1" + ret;
        }
        return ret;
    }
}