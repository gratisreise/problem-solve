class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String ret = "";
        for(int i = 0; i < parts.length; i++){
            ret += my_strings[i].substring(parts[i][0], parts[i][1] + 1);
        }
        return ret;
    }
}