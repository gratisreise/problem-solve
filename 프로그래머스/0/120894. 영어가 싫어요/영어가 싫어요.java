class Solution {
    public long solution(String numbers) {
        long ret = 0;
        String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String temp = "";
        String temp1 = "";
        for(char c : numbers.toCharArray()){
            temp += c;
            if(temp.length() >= 3){
                for(int i = 0; i <= 9; i++){
                    if(temp.equals(num[i])){
                        temp1 += i;
                        temp = "";
                    }
                }
            }
        }
        ret = Long.parseLong(temp1);
        
        
        return ret;
    }
}