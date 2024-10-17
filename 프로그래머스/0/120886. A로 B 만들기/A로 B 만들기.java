class Solution {
    public int solution(String before, String after) {
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        for(int i = 0; i < before.length(); i++){
            cntA[after.charAt(i) - 'a']++;
            cntB[before.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cntA[i] != cntB[i]) return 0;
        }
        return 1;
    }
}