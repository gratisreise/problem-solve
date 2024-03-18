class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int ret = 0;
        if(arr1.length == arr2.length){
            int temp1 = 0;
            int temp2 = 0;
            for(int i : arr1) temp1 += i;
            for(int i : arr2) temp2 += i;
            if(temp1 == temp2) ret = 0;
            else if(temp1 < temp2) ret = -1;
            else ret = 1;
        } else if(arr1.length > arr2.length) ret = 1;
        else ret = -1;
        return ret;
    }
}