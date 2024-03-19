class Solution {
    public int solution(String s) {
        int ret = 0;
        String[] temp = s.split(" ");
        for(int i = 0; i < temp.length; i++){
            if(temp[i].equals("Z")) ret -= Integer.parseInt(temp[i-1]);
            else ret += Integer.parseInt(temp[i]);
        }
        
        return ret;
    }
}