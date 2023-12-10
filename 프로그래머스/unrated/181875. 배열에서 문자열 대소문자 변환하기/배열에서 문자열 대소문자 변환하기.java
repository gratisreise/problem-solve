class Solution {
    public String toLowerCase(String s){
        String ret = "";
        for(char c : s.toCharArray()){
            if(c < 97){
                ret += (char)(c + 32);
            } else ret += c;
        }
        return ret;
    }
    public String toUpperCase(String s){
        String ret = "";
        for(char c : s.toCharArray()){
            if(c >= 97){
                ret += (char)(c - 32);
            } else ret += c;
        }
        return ret;
    }
    public String[] solution(String[] strArr) {
        for(int i = 0; i < strArr.length; i++){
            if(i % 2 == 0){
                strArr[i] = toLowerCase(strArr[i]);
            } else {
                strArr[i] = toUpperCase(strArr[i]);
            }
        }
        return strArr;
    }
}