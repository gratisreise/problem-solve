class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        int num1 = 1; // 모든 원소들의 곱
        int num2 = 0; // 모든 원소들의 합의 제곱
        for(int i : num_list){
            num1 *= i;
            num2 += i;
        }
        num2 *= num2;
        System.out.println(num1 + " : " + num2);
        if(num1 < num2) ret = 1;
        return ret;
    }
}