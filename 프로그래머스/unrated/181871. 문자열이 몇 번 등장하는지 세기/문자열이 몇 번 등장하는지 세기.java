class Solution {
    public int solution(String myString, String pat) {
        int ret = 0;
        for(int i = 0; i < myString.length() - pat.length() + 1; i++){
            String temp = "";
            for(int j = i; j < i + pat.length(); j++){
                temp += myString.charAt(j);
            }
            System.out.println(temp);
            if(temp.equals(pat)) ret++;
        }
        return ret;
    }
}