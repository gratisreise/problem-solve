class Solution {
    public long solution(int price, int money, int count) {
        long ret = 0;
        long sum = (long)price*(count)*(count+1)/2;
        if(sum - money > 0) ret = sum - money;
        return ret;
    }
}

/*
제약사항: 반복문 쓰지말고 수식으로
원래가격: price
n번째 이용 -> n배
price: a, d
count: n
*/