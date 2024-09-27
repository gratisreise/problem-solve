class Solution {
    public String solution(String my_string, int s, int e) {
        String s1 = my_string.substring(0, s);
        String s2 = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String s3 = my_string.substring(e + 1);
        return s1 + s2 + s3;
    }
}