class Solution {
    public boolean check(int n, int[] indices){
        boolean flag = false;
        for(int i : indices){
            if(i == n) flag = true;
        }
        return flag;
    }
    public String solution(String my_string, int[] indices) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            if(check(i, indices)) continue;
            answer += my_string.charAt(i);
        }
        return answer;
    }
}