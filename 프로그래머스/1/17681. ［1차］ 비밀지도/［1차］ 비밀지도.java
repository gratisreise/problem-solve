class Solution {
    static String binary(int n, int size){
        String ret = "";
        int temp = n;
        while(temp > 0){
            ret = "" + temp % 2 + ret;
            temp /= 2;
        }
        while(ret.length() < size){
            ret = "0" + ret;
        }
        return ret;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ret = new String[n];
        String[] temp1 = new String[n];
        String[] temp2 = new String[n];
        for(int i = 0; i < n; i++){
            temp1[i] = binary(arr1[i], n);
            temp2[i] = binary(arr2[i], n);
            // System.out.println(temp1[i] + "::" + temp2[i]);
        }
        for(int i = 0; i < n; i++){
            String temp = "";
            for(int j = 0; j < n; j++){
                if(temp1[i].charAt(j) == '1' || temp2[i].charAt(j) == '1'){
                    temp += "#";
                } else temp += " ";
            }
            ret[i] = temp;
        }
        
        
        return ret;
    }
}