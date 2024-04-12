import java.util.*;
class Solution {
    static int calc(int a, int b, String s){
        if(s.equals("+")) return a + b;
        else if(s.equals("-")) return a - b;
        return 1;
    }
    public int solution(String my_string) {
        int ret = 0;
        List<Integer> num = new ArrayList<>();
        List<String> oper = new ArrayList<>();
        String[] s = my_string.split(" ");
        
        for(String ss : s){
            if(ss.equals("+") || ss.equals("-")) oper.add(ss);
            else num.add(Integer.parseInt(ss));
        }
        ret = calc(num.get(0), num.get(1), oper.get(0));
        for(int i = 1; i < oper.size(); i++){
            ret = calc(ret,num.get(i+1), oper.get(i));
        }
        return ret;
    }
}
/*
1. 연산자, 숫자 나눠서 리스트 저장
2. 처음 계산은 해주고 나머지는 인덱스 맞춰서 반복 계산
*/