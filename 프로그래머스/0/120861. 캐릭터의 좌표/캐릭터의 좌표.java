import java.util.*;
class Solution {
    static String[] move1 = {"up", "down", "left", "right"};
    
    static int[] move(int[] arr, String s, int ylimit, int xlimit){
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, -1, 1};
        int[] temp = {arr[0], arr[1]};
        for(int i = 0; i < move1.length; i++){
            if(s.equals(move1[i])){
                temp[0] += x[i];
                temp[1] += y[i];
            }
        }
        if(Math.abs(temp[0]) > xlimit || Math.abs(temp[1]) > ylimit){
            return arr;
        } else return temp;
    }
    public int[] solution(String[] keyinput, int[] board) {
        int yLimit = board[1]/2;
        int xLimit = board[0]/2;
        
        int[] arr = new int[2];
        for(String s : keyinput){
            arr = move(arr, s, yLimit, xLimit);
        }
        
        return arr;
    }
}