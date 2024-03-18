class Solution {
    public String solution(int age) {
        String ret = "";
        String temp = "" + age;
        System.out.println(temp);
        for(char c : temp.toCharArray()){
            ret += (char)((c-'0') + 'a');
        }
        
        return ret;
    }
}