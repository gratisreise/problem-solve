import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        int max = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        int[] che = new int[max + 4];
        
        for(int i = 2; i <= max; i++){
            if(che[i] == 1) continue;
            for(int j = i * 2; j <= max; j += i){
                che[j] = 1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                for(int k = 0; k < j; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(che[sum] == 1) continue;
                    ret++;
                }
            }
        }
        
        
        return ret;
    }
}