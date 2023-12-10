class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String temp1 = myString.toLowerCase();
        String temp2 = pat.toLowerCase();
        if(temp1.length() < temp2.length()){
          return 0;  
        } else {
            if(temp1.contains(temp2)) answer = 1;
        } 
        
        return answer;
    }
}