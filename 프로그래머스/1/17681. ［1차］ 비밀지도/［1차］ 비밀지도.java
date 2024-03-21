class Solution {
    static String intToBinary(int n, int a){
        String ans = "";
        while(n > 0){
            ans = "" + n % 2 + ans;
            n /= 2;
        }
        while(ans.length() - a < 0){
            ans = "0" + ans;
        }
        return ans;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ret = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            String temp1 = intToBinary(arr1[i], n);
            String temp2 = intToBinary(arr2[i], n);
            String temp3 = "";
            System.out.println(i + " :: " + temp1 + " :: " + temp2);
            for(int j = 0; j < temp1.length(); j++){
                char c1 = temp1.charAt(j);
                char c2 = temp2.charAt(j);
                if(c1 == '0' && c2 == '0') temp3 += " ";
                else temp3 += "#";
            }
            ret[i] = temp3;
        }
        
        return ret;
    }
}