class Solution {
    public int solution(int[] num_list) {
        int num1 = 0;
        int num2 = 1;
        for(int i : num_list){
            if(num_list.length >= 11) num1 += i;
            else num2 *= i;
        }
        return num1 == 0 ? num2 : num1;
    }
}