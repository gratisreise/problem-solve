class Solution {
    public String solution(String s) {
        String ret = "";
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt[i] == 1) ret += (char)(i + 'a');
        }
        return ret;
    }
}