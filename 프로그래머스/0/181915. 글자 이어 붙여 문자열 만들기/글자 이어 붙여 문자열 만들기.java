class Solution {
    public String solution(String my_string, int[] index_list) {
        String ret = "";
        for(int i : index_list){
            ret += my_string.charAt(i);
        }
        return ret;
    }
}