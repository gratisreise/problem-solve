class Solution {
    public int solution(int n) {
        int ret = 0;
        int[] temp = new int[110];
        int k = 0;
        int i = 1;
        while(temp[n+1] == 0){
            k++;
            if(k % 3 == 0 || (""+k).contains("3")) continue;
            temp[i] = k; i++;
            System.out.println(i + " :: " + k);
        }
        ret = temp[n];
        return ret;
    }
}