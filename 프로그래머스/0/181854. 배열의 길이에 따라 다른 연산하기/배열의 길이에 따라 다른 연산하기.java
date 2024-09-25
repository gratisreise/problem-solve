class Solution {
    public int[] solution(int[] arr, int n) {
        int flag = 0;
        if(arr.length % 2 != 0) flag = 1;
        else flag = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(flag == 1 && i % 2 == 0) arr[i] += n;
            else if(flag == 0 && i % 2 != 0) arr[i] += n;
        }
        return arr;
    }
}