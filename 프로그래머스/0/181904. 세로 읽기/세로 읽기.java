class Solution {
    public String solution(String my_string, int m, int c) {
        String ret = "";
        int row = my_string.length() / m;
        int col = m;
        char[][] temp = new char[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                temp[i][j] = my_string.charAt((i * m) + j);
            }
        }
        for(int i = 0; i < row; i++){
            ret += temp[i][c - 1];
        }
        return ret;
    }
}