class Solution {
    public String solution(String my_string, int[][] queries) {
        String ret = "";
        char[] cArr = my_string.toCharArray();
        for(int i = 0; i < queries.length; i++){
            int j = queries[i][0];
            int k = queries[i][1];
            if(j == k) continue;
            while(j <= k){
                char temp = cArr[j];
                cArr[j] = cArr[k];
                cArr[k] = temp;
                j++; k--;
            }
        }
        for(char c : cArr) ret += c;
        return ret;
    }
}