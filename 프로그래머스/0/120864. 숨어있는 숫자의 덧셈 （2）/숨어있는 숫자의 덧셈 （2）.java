class Solution {
    public int solution(String my_string) {
        String temp = "";
        int ret = 0;
        for(char c : my_string.toCharArray()){
            if(Character.isAlphabetic(c) && temp.length() > 0) {
                ret += Integer.parseInt(temp);
                temp = "";
            } else if(!Character.isAlphabetic(c)) temp += c;
        }
        if(temp.length() != 0) ret += Integer.parseInt(temp);
        return ret;
    }
}