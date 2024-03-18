class Solution {
    public int solution(String myString, String pat) {
        int ret = 0;
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        if(myString.length() >= pat.length()){
            if(myString.contains(pat)) ret = 1;
        }
        return ret;
    }
}