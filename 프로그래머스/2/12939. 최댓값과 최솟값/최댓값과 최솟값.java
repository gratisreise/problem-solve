class Solution {
    public String solution(String s) {
        String answer = "";
        String[] ss = s.split(" ");
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for(String sss : ss){
            int temp = Integer.parseInt(sss);
            mx = Math.max(temp, mx);
            mn = Math.min(temp, mn);
        }
        answer = mn + " "+ mx;
        return answer;
    }
}