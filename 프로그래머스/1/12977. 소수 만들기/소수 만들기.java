import java.util.*;
class Solution {
    static boolean check(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public int solution(int[] nums) {
        int ret = 0;        
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                for(int k = 0; k < j; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(check(sum)) ret++;
                }
            }
        }
        
            
        return ret;
    }
}