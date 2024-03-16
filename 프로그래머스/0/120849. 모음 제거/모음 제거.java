class Solution {
    public String solution(String my_string) {
        String ret = "";
        for(char c : my_string.toCharArray()){
            if(c =='a' || c == 'i' || c =='o' || c == 'e' || c == 'u') continue;
            ret += c;
        }
        return ret;
    }
}