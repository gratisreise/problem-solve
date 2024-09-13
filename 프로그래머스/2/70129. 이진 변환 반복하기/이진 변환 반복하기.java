class Solution {
    public int[] solution(String s) {
        int cntDel = 0; 
        int cntCvt = 0;
        
        while(!s.equals("1")){
            StringBuilder builder = new StringBuilder();
            for(char c : s.toCharArray()) if(c == '1') builder.append(c);
            cntDel += s.length() - builder.length();
            cntCvt ++;
            s = Integer.toString(builder.length(), 2);
        }
        return new int[]{cntCvt, cntDel};
    }
        
}
/*
1. s의 모든 0을 제거
2. 길이를 2진법 문자열로 변환
3. 1-2 과정을 "1"이 될 때까지 반복
4. 변환 횟수와 제거된 0의 갯수 반환
*/