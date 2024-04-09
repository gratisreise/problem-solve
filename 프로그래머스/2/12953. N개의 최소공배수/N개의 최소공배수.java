class Solution {
    public int solution(int[] arr) {
        int ret = 1;
        int mx = -1;
        for(int i = 0; i < arr.length; i++) mx = Math.max(mx, arr[i]);
        for(int i = 2; i <= mx; i++){
            boolean flag = true;
            while(flag){
                flag = false;
                for(int j = 0; j < arr.length; j++){
                    if(arr[j] % i == 0) {
                        arr[j] /= i;
                        flag = true;
                    }
                }
                if(flag == true) ret *= i;
            }
        }
        return ret;
    }
}