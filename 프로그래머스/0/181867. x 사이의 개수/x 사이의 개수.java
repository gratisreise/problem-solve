import java.util.*;
class Solution {
    public List<Integer> solution(String myString) {
        List<Integer> ret = new ArrayList<>();
        String[] s = myString.split("x");
        for(String ss : s){
            ret.add(ss.length());
        }
        if(myString.charAt(myString.length() - 1) == 'x') ret.add(0);
        return ret;
    }
}

//x를 기준으로 나눴을 때 마지막 x는 마지막과 사이의 0으로 인식