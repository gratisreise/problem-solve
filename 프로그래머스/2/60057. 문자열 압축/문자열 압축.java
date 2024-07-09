class Solution {
    public int solution(String s) {
        int ans = 0;
        int n = s.length();
        int min = 1000000;
        for(int i = 1; i <= n / 2 + 1; i++){
            StringBuilder ret = new StringBuilder(); //결과 담을 것
            String prev = "";
            int size = 1;
            for(int j = 0; j < n; j += i){
                int end = Math.min(j + i, s.length());
                String temp = s.substring(j, end);
                if(temp.equals(prev)) size++;
                else {
                    ret.append(size > 1 ? size + prev : prev);
                    size = 1;
                }
                prev = temp;
            }
            ret.append(size > 1 ? size + prev : prev);
            min = Math.min(min, ret.length()); 
        } 
        return ans = min;
    }
}