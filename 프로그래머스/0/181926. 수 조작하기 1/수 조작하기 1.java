class Solution {
    static int check(char c){
        int ret = 0;
        if(c == 'w') ret = 1;
        else if(c == 's') ret = -1;
        else if(c == 'd') ret = 10;
        else if(c == 'a') ret = -10;
        return ret;
    }
    public int solution(int n, String control) {
        int ret = n;
        for(char c : control.toCharArray()){
            ret += check(c);
        }
        return ret;
    }
}