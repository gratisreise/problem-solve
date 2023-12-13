class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        String s = String.valueOf(x);
        for(char c : s.toCharArray()){
            sum += (c - '0');
        }
        if(x % sum != 0) answer = false;
        return answer;
    }
}