class Solution {
    public int solution(int[] num_list) {
        int numEven = 0;
        int numOdd = 0;
        for(int i = 0; i < num_list.length; i++){
            if((i+1) % 2 == 0) numEven += num_list[i];
            else numOdd += num_list[i];
        }
        return numEven >= numOdd ? numEven : numOdd;
    }
}