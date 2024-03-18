import java.util.*;
class Solution {
    public List<Integer> solution(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(n);
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            ret.add(n);
        }
        return ret;
    }
}
//x짝수일 때 2로나누고
//x홀수일 때 3*x + 1로 바꾸는 ㅅ