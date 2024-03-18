import java.util.*;
class Solution {
    public List<String> solution(String my_string) {
        List<String> ret = new ArrayList<>();
        String temp = "";
        for(char c : my_string.toCharArray()){
            if(c != ' ') temp += c;
            else if(c == ' ' && temp.length() > 0){
                ret.add(temp);
                temp = "";
            }
        }
        if(temp.length() > 0) ret.add(temp);
        return ret;
    }
}

// 순회 -> 빈칸x -> 빈문자열에 담기 -> 빈문자열 나오면 리스트에 추가 -> 남아있으면 리스트에 추가
