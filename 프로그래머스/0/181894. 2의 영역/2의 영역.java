class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;
        for(int i = 0; i < arr.length; i++){
            if(start == -1 && arr[i] == 2) {start = i; end = i;}
            if(start != -1 && arr[i] == 2) end = i;
        }
        int[] ret = new int[end - start + 1];
        if(start == -1) return new int[]{-1};
        for(int i = start; i <= end; i++){
            ret[i-start] = arr[i];
        }
        return ret;
    }
}