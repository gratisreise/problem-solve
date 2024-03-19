class Solution {
    public int solution(String[] order) {
        int ret = 0;
        String a = "americano";
        String b = "latte";
        int temp1 = 0;
        int temp2 = 0;
        for(String s : order){
            if(s.contains(a)){
                temp1++;
            } else if(s.contains(b)){
                temp2++;
            } else temp1++;
        }
        ret = temp1 * 4500 + temp2 * 5000;
        return ret;
    }
}