import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int ret = 0;
        String temp = "";
        Stack<Integer> stk = new Stack<>();
        for(char c : dartResult.toCharArray()){
            if(c == 'S' || c == 'D' || c == 'T'){
                int n = Integer.parseInt(temp);
                if(c == 'S') stk.push(n);
                else if(c == 'D') stk.push(n * n);
                else if(c == 'T') stk.push(n * n * n);
                temp = "";
                continue;
            } else if(c == '*' || c == '#'){
                if(c == '*'){
                    Stack<Integer> temp1 = new Stack<>();
                    int k = 2;
                    while(!stk.isEmpty() && k-- > 0){
                        temp1.push(stk.pop()*2);
                    }
                    while(!temp1.isEmpty()) stk.push(temp1.pop());
                } else if(c == '#'){
                    stk.push(stk.pop()*(-1));
                }
                continue;
            }
            temp += c;   
        }
        while(!stk.isEmpty()) ret += stk.pop();
        return ret;
    }
}


/*
1. 문자열을 순회하면서 temp 넣어준다
2. 숫자가 아닌 문자가 나오면
    2-1. 뒤에 *,# 있는지 체크
        2-1-1. 있다
            2-1-1-1. *은 앞에 인덱스 존재하는지 체크해서 넣어주기(stack)
            2-1-1-2. #은 앞에 현재인덱스 -1배해서 stack에 push
        2-1-2. 없으면 계산해서 stack 넣어주기
    
    
*/