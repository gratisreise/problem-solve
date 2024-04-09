import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] ret = new int[2];
        Map<String, Integer> mp = new HashMap<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        // System.out.println("Hello Java");
        String prev = "" + words[0].charAt(0);
        for(int i = 0; i < words.length; i++){    
            // 앞의 첫글자랑 다르면
            if(prev.charAt(prev.length() - 1) != words[i].charAt(0)){
                ret[0] = (i % n) + 1; //몇번째인지
                ret[1] = (i / n) + 1; //회차
                break;
            }
            //나온적있는 단어
            if(mp.containsKey(words[i])){
                ret[0] = (i % n) + 1;
                ret[1] = (i / n) + 1;
                break;
            }
            // 단어의 길이가 1이면
            if(words[i].length() == 1){
                ret[0] = (i % n) + 1;
                ret[1] = (i / n) + 1;
                break;
            }
            prev = words[i];
            mp.put(words[i], 1);
        }
        
        return ret;
    }
}
// 조건1: 앞사람의 마지막 단어가 시작인지? -> prev로 확인
// 조건2: 이전 등장했던 단어인가?
// 조건3: 한 글자인 단어는 인정x
// {첫탈락사람번호, 몇번째}