import java.util.*;
class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        if(s.length() == 1) return 1;
        for(int length = 1; length <= s.length() / 2; length++){
            //문자열 압축 후 가장 짧은 길이 선택
            int compressed = compress(s, length);
            if(compressed < min) min = compressed;
        }
        
        return min;
    }
    
    private int compress(String source, int length){
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        
        for(String token : split(source, length)){
            //압축문자열 구성
            if(token.equals(last)) {
                count++;
            } else { // 새로운 토큰 등장 처리
                if(count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        
        if(count > 1) builder.append(count);
        builder.append(last);
        
        return builder.length();
    }
    
    private List<String> split(String source, int length){
        List<String> tokens = new ArrayList<>();
        //source를 length만큼씩 잘라 token 리스트에 추가
        for(int startIndex = 0; startIndex < source.length(); startIndex += length){
            int endIndex = startIndex + length;
            if(endIndex > source.length()) endIndex = source.length();
            //문자열을 startIndex부터 잘라 tokens 리스트에 추가
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
}
/*
1. 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
2. 설정된 길이만큼 문자열을 잘라 낸 token의 배열 생성
3. 문자열을 비교하며 token의 배열을 하나의 문자열로 압축
4. 1~3 과정으로 압축된 문자열 중 가장 짧은 길이 반환
*/