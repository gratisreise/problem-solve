class Solution {
    public int solution(int n, int k) {
        int ret = 0;
        ret = 12000 * n + 2000 * (k - n/10);
        return ret;
    }
}