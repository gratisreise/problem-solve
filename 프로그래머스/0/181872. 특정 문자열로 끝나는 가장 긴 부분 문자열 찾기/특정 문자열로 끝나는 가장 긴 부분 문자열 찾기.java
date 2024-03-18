class Solution {
    public String solution(String myString, String pat) {
        String ret = "";
        String temp = "";
        for(int i = myString.length() - 1; i >= 0; i--){
            temp = "" + myString.charAt(i) + temp;
            if(temp.contains(pat)) break;
        }
        ret = myString.substring(0, myString.length() - temp.length() + pat.length());
        return ret;
    }
}
// pat으로 끝나는 가장 긴 부분문자열을 리턴
// myString을 
// 0 1 2 3 4 5 6
// 뒤에서부터 추가하면서 검사
// 원래 문자열 길이에서 임시문자열 길이에서 pat을 뺀만큼의 부분문자열 구하기
// 