class Solution {
    public int solution(int num, int k) {
        char[] arr = String.valueOf(num).toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(k == arr[i] - '0') return i + 1;
        }
        return -1;
    }
}