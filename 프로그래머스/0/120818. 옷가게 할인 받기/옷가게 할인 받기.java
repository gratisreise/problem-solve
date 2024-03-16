class Solution {
    public int solution(int price) {
        int ret = price;
        if(price >= 500000) ret = ret * 80 /100;
        else if(price >= 300000) ret = ret * 90 / 100;
        else if(price >= 100000) ret = ret * 95 / 100;
        return ret;
    }
}