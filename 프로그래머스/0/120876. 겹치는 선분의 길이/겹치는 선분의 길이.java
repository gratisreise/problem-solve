class Solution {
    public int solution(int[][] lines) {
        int ret = 0;
        int[] cnt = new int[210];
        for(int i = 0; i < lines.length; i++){
            int a = lines[i][0] + 100;
            int b = lines[i][1] + 100;
            for(int j = a; j < b; j++) cnt[j]++;
        }
        for(int i : cnt) if(i >= 2) ret++;
        return ret;
    }
}