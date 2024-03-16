class Solution {
    public int[] solution(int money) {
        int[] ret = {0, 0};
        ret[0] = money / 5500;
        ret[1] = money % 5500;
        return ret;
    }
}