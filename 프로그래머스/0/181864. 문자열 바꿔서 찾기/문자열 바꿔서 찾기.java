class Solution {
    public int solution(String myString, String pat) {
        int ret = 0;
        String temp = "";
        for(char c : myString.toCharArray()){
            if(c == 'A') temp += 'B';
            else temp += 'A';
        }
        if(temp.contains(pat)) ret = 1;
        System.out.println(temp + " :: " + pat);
        return ret;
    }
}