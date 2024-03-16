class Solution {
    public int solution(String str1, String str2) {
        int ret = 2;
        if(str1.contains(str2)) ret = 1;
        return ret;
    }
}