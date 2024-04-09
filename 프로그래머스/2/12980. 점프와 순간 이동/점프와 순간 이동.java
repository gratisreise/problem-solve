import java.util.*;

public class Solution {
    public int solution(int n) {
        int ret = 0;
        int cnt = 0; //홀수인거 카운트
        while(true){
            if(n <= 2) break; 
            if(n % 2 != 0) { 
                n = n - 1; 
                cnt += 1;
                // n = n / 2;
            } else n = n / 2; 
        }
        ret = 1 + cnt;
        return ret;
    }
}