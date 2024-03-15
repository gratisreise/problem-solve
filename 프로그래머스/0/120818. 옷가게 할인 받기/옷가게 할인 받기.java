class Solution {
    public int solution(int price) {
        int ret = 0;
        if(price < 100000) ret = price;
        else if(price < 300000) ret = price * 95 / 100;
        else if(price < 500000) ret = price * 90 / 100;
        else ret = price * 80 / 100;
        return ret;
    }
}