
class Solution {
    public String solution(String my_string) {
        String ret = "";
        StringBuilder sb = new StringBuilder(my_string);
        ret = sb.reverse().toString();
        return ret;
    }
}