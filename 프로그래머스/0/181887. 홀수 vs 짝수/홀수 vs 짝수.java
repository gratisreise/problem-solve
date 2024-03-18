class Solution {
    public int solution(int[] num_list) {
        int ret = 0;
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0; i < num_list.length; i++){
            if((i+1) % 2 == 0) temp1 += num_list[i];
            else temp2 += num_list[i];
        }
        System.out.println(temp1 + " :: " + temp2);
        if(temp1 > temp2) ret = temp1;
        else ret = temp2;
        return ret;
    }
}