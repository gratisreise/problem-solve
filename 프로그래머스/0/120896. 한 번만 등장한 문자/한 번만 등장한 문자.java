class Solution {
    private int[] cnt = new int[26];
    public String solution(String s) {
        StringBuilder ret = new StringBuilder();
        for(char c : s.toCharArray()) cnt[c - 'a']++;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 1) ret.append((char)(i + 'a'));
        }
        return ret.toString();
    }
}