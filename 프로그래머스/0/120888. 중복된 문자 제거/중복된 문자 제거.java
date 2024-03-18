class Solution {
    public String solution(String my_string) {
        String ret = "";
        char[] alp = new char[150];
        for(char c : my_string.toCharArray()){
            if(alp[c] == 0){
                ret += ("" + c);
                alp[c] += 1;
            }
        }
        return ret;
    }
}