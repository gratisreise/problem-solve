import java.util.*;
class Solution {
    
    private int findIdx(String s){
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) ==')') cnt1++;
            else cnt2++;
            if(cnt1 == cnt2) return i;
        }
        return -1;
    }
    private String change(String s){
        var ans = new StringBuilder();
        for(int i = 1; i < s.length()-1; i++){
            if(s.charAt(i) == ')') ans.append('(');
            else ans.append(')');
        }
        return ans.toString();
    }
    private boolean isRight(String s){
        var stk = new ArrayDeque<Character>();
        for(char c : s.toCharArray()){
            if(!stk.isEmpty() && c == ')' && stk.peekLast() == '('){
                stk.pollLast();
            } else stk.addLast(c);
        }
        return stk.isEmpty();
    }
    private String go(String s){
        if(s.length() == 0) return "";
        int pos = findIdx(s);
        String u = s.substring(0, pos+1);
        String v = s.substring(pos+1);
        StringBuilder ret = new StringBuilder();
        if(isRight(u)) {
            ret.append(u).append(go(v));
            return ret.toString();
        } 
        ret.append("(");
        ret.append(go(v));
        ret.append(")");
        ret.append(change(u));
        return ret.toString();
    }
    public String solution(String p) {
        return go(p);
    }
}

/*
( ) 각각 갯수 같으면 균형잡힌 문자열 
( ) 짝도 맞으면 올바른 괄호 문자열
균형잡힌 문자열 -> 올바른 변환가능
자료구조: 올바른 체크용 메서드, 재귀 메서드, 
균잡문 -> 올바른 괄호
1. u를 괄호쌍 맞는 갯수 까지 해서 생성
2. u가 올바른 문자열인지 확인
 2-1.올바른 문자면 u에 붙혀서 다시 v에 대해 다시 재귀 시작
 2-2.아니면 
  1. 빈문자열 "(" 붙히기
  2. v문자열 재귀
  3. ")" 붙히기
  4. u의 첫번째 문자와 마지막 문자 제거하고 괄호방향뒤집어서 뒤에 붙히기
*/