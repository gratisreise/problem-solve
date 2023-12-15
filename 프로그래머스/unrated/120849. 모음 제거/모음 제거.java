class Solution {
    public boolean check(char c){
        boolean ret = false;
        if(c == 'a' || c =='e' || c=='i' || c == 'o' || c == 'u'){
            ret = true;
        }
        return ret;
    }
    public String solution(String my_string) {
        String answer = "";
        for(char c : my_string.toCharArray()){
            if(check(c)) continue;
            answer += c;
        }
        return answer;
    }
}