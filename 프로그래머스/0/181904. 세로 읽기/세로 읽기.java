class Solution {
    public String solution(String my_string, int m, int c) {
        char[] arr = my_string.toCharArray();
        StringBuilder ret = new StringBuilder(); 
        for(int i = 0; i < arr.length; i++){
            if((i % m)  + 1 == c) ret.append(arr[i]);
        }
        return ret.toString();
    }
}