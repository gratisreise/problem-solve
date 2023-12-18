class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        for(int i = 0; i < queries.length; i++){
            String pre = my_string.substring(0, queries[i][0]);
            String suf = my_string.substring(queries[i][1]+1);
            StringBuilder temp = new StringBuilder(my_string.substring(queries[i][0], queries[i][1] + 1));
            temp.reverse();
            my_string = pre + temp.toString() + suf;
        }
        return my_string;
    }
}