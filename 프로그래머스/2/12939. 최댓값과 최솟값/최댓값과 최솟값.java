class Solution {
    public String solution(String s) {
        String answer = "";
        String[] ss = s.split(" ");
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for(String sss : ss){
            int temp = Integer.parseInt(sss);
            if(temp > mx){
                mx = temp;
            } else if(temp < mn){
                mn = temp;
            }
        }
        answer = mn + " "+ mx;
        return answer;
    }
}