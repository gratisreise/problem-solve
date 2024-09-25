class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] arr = my_string.toCharArray();
        StringBuilder ret = new StringBuilder();
        for(int i : index_list) ret.append(arr[i]);
        return ret.toString();
    }
}