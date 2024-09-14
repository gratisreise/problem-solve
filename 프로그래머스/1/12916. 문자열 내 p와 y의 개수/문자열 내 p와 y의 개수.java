class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int countY = 0;
        int countP = 0;
        for(char c : s.toLowerCase().toCharArray()){
            if(c == 'p') countP++;
            else if(c == 'y') countY++;
        }
        return countP == countY ? true : false;
    }
    
}