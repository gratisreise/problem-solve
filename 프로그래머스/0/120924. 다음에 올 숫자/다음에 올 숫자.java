class Solution {
    public int solution(int[] common) {
        double r1 = (double) common[1] / common[0];
        double r2 = (double) common[2] / common[1];
        if(r1 % 1 == 0 && r2 % 1 == 0 && (int)r1 == (int)r2) {
            return (int)r1 * common[common.length - 1];
        }
        int d1 = common[1] - common[0];
        int d2 = common[2] - common[1];
        if(d1 == d2) return common[common.length - 1] + d1;
        return 0;
    }
}