class Solution {
    public int solution(String myString, String pat) {
        int ret = 0;
        for(int i = 0; i < myString.length() - pat.length() + 1; i++){
            String temp = myString.substring(i, i + pat.length());
            if(temp.equals(pat)) ret++;
        }
        return ret;
    }
}