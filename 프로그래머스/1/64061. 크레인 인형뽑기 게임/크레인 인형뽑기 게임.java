import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int ret = 0;
        int row = board.length;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        for(int i = 0; i < moves.length; i++){
            int k = moves[i] - 1; // 열번호
            boolean flag = false;
            for(int j = 0; j < row; j++){
                if(flag) continue;
                if(board[j][k] != 0){
                    // System.out.println(board[j][k]);
                    // 안비어있고 가장위가 넣을 수랑 같으면
                    if(!stk.isEmpty() && stk.peek() == board[j][k]){
                        // System.out.println(stk.peek() + "::" + board[j][k]);
                        stk.pop();
                        ret++;
                    } else stk.push(board[j][k]);
                    board[j][k] = 0;
                    flag = true;
                }
            }
        }
        // while(!stk.isEmpty()) System.out.println(stk.pop());
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return ret*2;
    }
}