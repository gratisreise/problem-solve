class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder ret = new StringBuilder();
        char[] cArr = s.toCharArray();
        
        for(char c : cArr){
            if('a' <= c && c <= 'z'){
                ret.append(pushLower(c, n));
            } else if('A' <= c && c <= 'Z'){
                ret.append(pushUpper(c, n));
            } else ret.append(c);
        }
        
        return ret.toString();
    }
    private char pushLower(char c, int n){
        if(c + n <= 'z') return (char)(c + n);
        else return (char)(c + n - 26);
    }
    private char pushUpper(char c, int n){
        if(c + n <= 'Z') return (char)(c + n);
        else return (char)(c + n - 26);
    }
    
}
/*
1. 문자열을 문자의 배열로 만든다
2. 문자의 배열을 순회
    2-1. 소문자 => 밀기, 빌더에 넣기 
    2-2. 대문차 => 밀기, 빌더에 넣기
    2-3. 공백  => 배제, 빌더에 넣기
3. 변환된 문자의 배열을 
*/