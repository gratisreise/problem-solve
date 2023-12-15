class Solution {
    public int solution(String[] strArr) {
        int[] cnt = new int[34];
        for(String s : strArr){
            cnt[s.length()]++;
        }
        int mx = -1;
        for(int i : cnt) mx = Math.max(mx, i);
        return mx;
    }
}