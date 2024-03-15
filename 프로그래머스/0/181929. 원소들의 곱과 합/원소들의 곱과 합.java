class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        int multiply = 1;
        int sum = 0;
        
        for(int i : num_list){
            sum += i;
            multiply *= i;
        }
        System.out.println(sum);
        sum = sum * sum;
        
        if(multiply < sum) ret = 1;
        
        return ret;
    }
}