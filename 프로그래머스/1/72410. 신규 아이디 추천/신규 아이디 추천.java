class Solution {
    public String solution(String new_id) {
        String ret = new String(new_id.toLowerCase());
        ret = ret.replaceAll("[^a-z0-9._-]", "")
                 .replaceAll("\\.{2,}", ".")
                 .replaceAll("^\\.+|\\.$", "");
        ret = ret.equals("") ? "a" : ret;
        ret = ret.length() >= 16 ? ret.substring(0, 15) : ret;
        ret = lastProcess(ret.replaceAll("\\.$", ""));
        return ret;
    }
    private String lastProcess(String s){
        StringBuilder builder = new StringBuilder(s);
        while(builder.length() < 3){
            builder.append(builder.charAt(builder.length() -1));
        }
        return builder.toString();
    }
}
/*
1. 소문자 치환 : toLowerCase()
2. 알파벳 소문자, 숫자, -, _, . 제외 모든 문자 제거 : 정규식 replaceall
3. 마침표 . 2번 이상 연속 .하나로 치환 : 정규식 replaceall
4. 처음이나 끝에 . 제거 : 정규식 replaceall

5. 빈 문자열이면 "a" 대입 : if 조건 설정
6. 길이 16자 이상 15 제외 나머지 문자 제거 제거 후 마침표 잇으면 제거 : substring
7. 길이가 2자 이하면 길이가 3 될 때까지 마지막 문자 붙이기 : 
*/