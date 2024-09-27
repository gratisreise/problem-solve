class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder ret = new StringBuilder();
        char[] arr = my_string.toCharArray();
        for(int i = 0; i < arr.length; i++){
            boolean flag = true;
            for(int j : indices) if(i == j) flag = false;
            if(flag) ret.append(arr[i]);
        }
        return ret.toString();
    }
}