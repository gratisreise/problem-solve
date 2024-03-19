import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] temp1 = Arrays.copyOf(emergency, emergency.length); // 응급도순정렬배열
        int[] temp2 = new int[emergency.length];
        // int[] destinationArray = Arrays.copyOf(sourceArray, sourceArray.length);
        int[] ret = new int[emergency.length]; // 진료순배열
        Arrays.sort(temp1);
        for(int i = emergency.length - 1; i >= 0; i--){
            temp2[(emergency.length - 1) - i] = temp1[i];
        }
        for(int i = 0; i < emergency.length; i++){
            for(int j = 0; j < temp2.length; j++){
                if(emergency[i] == temp2[j]){
                    ret[i] = j+1;
                }
            }
        }
        return ret;
    }
}

