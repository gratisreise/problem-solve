import java.util.*;
class Solution {
    static int[][] num = {{1,2,3},{4,5,6},{7,8,9},{15,0,16}};
    static int[] lArr = {1, 4, 7};
    static int[] rArr = {3, 6, 9};
    static int[] mArr = {0, 2, 5, 8};
    static int[] lLoc = {3, 0};
    static int[] rLoc = {3, 2};
    //가운데 문자 반환
    static String check(int n, String hand){
        String ret = " ";
        int[] loc = {0, 0}; // 들어갈 좌표 저장
        //해당점의 위치 체크
        loc = calc(n, loc);
        // System.out.println(loc[0] + " :: " + loc[1]);
        // 위치에 따른 거리 계산
        int L = Math.abs(lLoc[0] - loc[0]) + Math.abs(lLoc[1] - loc[1]);
        int R = Math.abs(rLoc[0] - loc[0]) + Math.abs(rLoc[1] - loc[1]);
        
        if(L == R){ // 둘의 거리가 같으면
            if(hand.equals("right")){ 
                rLoc = loc;
                return "R";
            } else if(hand.equals("left")){ 
                lLoc = loc;
                return "L";
            }
        } else if(L < R){ // 왼손
            lLoc = loc;
            return "L";
        } else { //오른손
            rLoc = loc;
            return "R";
        }
        return ret;
    }
    //숫자키패드 위치배열 반환
    static int[] calc(int n, int[] loc){
        int[] temp = {0, 0};
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < num[i].length; j++){
                if(num[i][j] == n){
                    temp = new int[]{i, j};
                } //왼손 오른속도 체크
            }
        }
        return temp;
    }
    public String solution(int[] numbers, String hand) {
        String ret = "";
        for(int i : numbers){
            if(Arrays.binarySearch(rArr, i) >= 0){ 
                ret += "R";
                rLoc = calc(i, rLoc);
            }
            else if(Arrays.binarySearch(lArr, i) >= 0){ 
                ret += "L";
                lLoc = calc(i, rLoc);
            }
            else if(Arrays.binarySearch(mArr, i) >= 0){
                ret += check(i, hand);
            }
        }
        return ret;
    }
}