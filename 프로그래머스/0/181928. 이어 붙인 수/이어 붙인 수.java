class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        String even = "";
        String odd = "";
        for(int i : num_list){
            if(i % 2 == 0) even += i;
            else odd += i;
        }
        ret = Integer.parseInt(even) + Integer.parseInt(odd);
        
        return ret;
    }
}