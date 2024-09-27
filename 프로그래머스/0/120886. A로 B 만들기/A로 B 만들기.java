class Solution {
    private int[] cnt1 = new int[26];
    private int[] cnt2 = new int[26];
    public int solution(String before, String after) {
        for(int i = 0; i < before.length(); i++){
            cnt1[before.charAt(i) - 'a']++;
            cnt2[after.charAt(i) - 'a']++;
        }
        for(int i = 0; i < cnt1.length; i++){
            if(cnt1[i] != cnt2[i]) return 0;
        }
        return 1;
    }
}