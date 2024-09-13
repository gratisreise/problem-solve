class Solution {
    public int solution(int n) {
        String num3 = new StringBuilder(Integer.toString(n, 3)).reverse().toString();
        int ret = Integer.parseInt(num3, 3);
        return ret;
    }
}