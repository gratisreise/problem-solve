import java.util.*;
class Solution {
    public List<Integer> solution(int money) {
        List<Integer> ret = new ArrayList<>();
        int cup = money / 5500;
        int surplus = money - (5500 * cup);
        ret.add(cup);
        ret.add(surplus);
        return ret;
    }
}
//아메리카노 - 5500
//가지고 있는 돈은 주어짐
// 최대로 마실 수 있는 아메리카노 잔 수와 남는돈을 담은 배열 리턴
