class Solution {
    public String solution(String s) {
        StringBuilder ret = new StringBuilder();
        int index = 0;
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)) {
                ret.append(' ');
                index = 0;
            } else{
                if(index % 2 == 0) ret.append(Character.toUpperCase(c));
                else ret.append(Character.toLowerCase(c));
                index++;
            }
        }
        return ret.toString();
    }
}
/*
1. 공백을 기준으로 나눈다
2. 문자의 배열의 각 문자열을 변환
    2-1. 각문자열 순회하면서 
3. 결괏값 반환
*/