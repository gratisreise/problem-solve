class Solution {
    public int solution(int hp) {
        int ret = 0;
        for(int i = 5; i > 0; i -= 2){
            ret += (hp / i);
            hp = (hp % i);
        }
        return ret;
    }
}


/*
사냥감의 체력에 맞게
장군 5
병장 3
 일 1
 */
 