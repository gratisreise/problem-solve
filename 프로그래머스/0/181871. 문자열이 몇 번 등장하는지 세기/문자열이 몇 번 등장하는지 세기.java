class Solution {
    public int solution(String myString, String pat) {
        int ret = 0;
        char[] arr = myString.toCharArray();
        if(pat.length() > myString.length()) return ret;
        else {
            for(int i = 0; i < arr.length - (pat.length()-1); i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < pat.length(); j++){
                    sb.append(arr[i+j]);
                }
                if(pat.equals(sb.toString())) ret++;
            }
        }
        return ret;
    }
}